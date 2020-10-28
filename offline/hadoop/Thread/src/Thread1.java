
public class Thread1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = ()->{
            for (int i=0;i<100;i++){
                System.out.print((i&1)==0?i:" ");
            }
        };
        new Thread(r).start();
        Thread.sleep(10);
        for (int i=0;i<100;i++){
            System.out.print((i&1)==1?i:" ");
        }
    }
}
