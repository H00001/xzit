import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock lock0 = new ReentrantLock();
        final ReentrantLock lock1 = new ReentrantLock();
        final Thread t0= new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock0.lock();
            lock1.lock();
            System.out.println("t0 complete");
            lock1.lock();
            lock0.lock();
        });
        //       |
        //       | start
        // for1/ | for2
        Thread t1= new Thread(()->{
            lock1.lock();
            lock0.lock();
            System.out.println("t1 complete");
            lock0.unlock();
            lock1.unlock();
        });
        t0.start();
        t1.start();

        t0.join();
        t1.join();
    }
}
