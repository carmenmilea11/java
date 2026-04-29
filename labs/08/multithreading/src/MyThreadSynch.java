public class MyThreadSynch extends Thread {

    private static final Object lock = new Object();
    private static int a;
    private static int b;

    public MyThreadSynch(String name) {
        super(name);
    }

    private static void myMethod(){

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "a "+ a + " b " + b);
            a++;
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b++;
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            myMethod();
        }
    }
}
