public class SingletonThreadSafe {

    private static SingletonThreadSafe instance;
    private static final Object lock = new Object();
    private int myField;

    private SingletonThreadSafe() {
    }

    public static SingletonThreadSafe getInstance(){
        if(instance == null){
            synchronized (lock) {
                if(instance == null){
                    instance = new SingletonThreadSafe();
                }

            }
        }

        return instance;
    }

    public int getMyField() {
        return myField;
    }

    public void setMyField(int myField) {
        this.myField = myField;
    }
}
