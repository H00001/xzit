
public class Thread2 {
    static int a = 0;
    public static void main(String[] args) throws InterruptedException {
       // ReentrantLock l = new ReentrantLock();
        var t9 = System.currentTimeMillis();
        Runnable r = ()->{
            for (int i=0;i<10000000;i++){
              //  l.lock();
                a++;
              //  l.unlock();
            }
        };
        Thread t=  new Thread(r);
        Thread t1 = new Thread(r);
        Thread t3=  new Thread(r);
        Thread t4 = new Thread(r);
        t.start();
        t1.start();
        t3.start();
        t4.start();
        t.join();
        t1.join();
        t4.join();
        t3.join();
        System.out.println(System.currentTimeMillis()-t9);
        System.out.println(a);
    }
}
