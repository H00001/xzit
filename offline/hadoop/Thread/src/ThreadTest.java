import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {
    static boolean a;
    public static void main(String[] args) {

        Thread t = new Thread(()->{
            while (a) {
                int k = 1 / 0;
            }
        },"name-1");
        t.setUncaughtExceptionHandler((t1,e)->{
            System.out.println("setu");
        });
        t.start();
       // Thread t = new Thread("name-1");
        t.start();
        System.out.println("name:"+t.getName());
        System.out.println("id:"+t.getId());
        System.out.println("state:"+t.getState());
        System.out.println("pri:"+t.getPriority());

    }
}
