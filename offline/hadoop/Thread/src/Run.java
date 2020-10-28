import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Supplier;

public class Run {
    static long a= 0;
    public static void main(String[] args) throws InterruptedException {
        long old = System.currentTimeMillis();
       // final ReentrantLock lock = new ReentrantLock();
        Runnable r = ()->{
            for1:for (long i = 0;i<20000000;i++){
           //     lock.lock();
                Run.a++;
          //      lock.unlock();
            }
        };
        final Thread t0= new Thread(r);

        //       |
        //       | start
        // for1/ | for2
        Thread t1= new Thread(r);
        t0.start();
        t1.start();
        t0.join();
        t1.join();

        System.out.println(a+":"+(System.currentTimeMillis()-old));
    }
}
