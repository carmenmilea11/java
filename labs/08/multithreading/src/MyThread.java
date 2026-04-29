public class MyThread extends Thread{

    private static int a;
    private static int b;

    public MyThread(String name) {
        super(name);
    }

    private static void myMethod(){
        System.out.println(Thread.currentThread().getName() + "a "+ a + " b " + b);
        a++;
        try {
            sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        b++;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            myMethod();
        }
    }
}
