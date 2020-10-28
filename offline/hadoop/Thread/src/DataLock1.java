import java.util.concurrent.locks.ReentrantLock;

public class DataLock1 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        Thread t = new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock2.lock();
            System.out.println("t1 complete");
            lock2.unlock();
            lock.unlock();
        });
        Thread t2 = new Thread(()->{
            lock2.lock();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("t2 complete");
            lock.unlock();
            lock2.unlock();
        });
        t.start();
        t2.start();
    }
}
