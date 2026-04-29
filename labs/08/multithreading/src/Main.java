void main() {
    //Singleton (Not Thread Safe)
//    Runnable r1 = () -> {
//        Singleton s = Singleton.getInstance();
//        s.setMyField(3);
//    };
//
//    Runnable r2 = () -> {
//        Singleton s = Singleton.getInstance();
//        s.setMyField(6);
//    };

    //Singleton (Thread Safe)
//    Runnable r1 = () -> {
//        SingletonThreadSafe s = SingletonThreadSafe.getInstance();
//        s.setMyField(3);
//    };
//
//    Runnable r2 = () -> {
//        SingletonThreadSafe s = SingletonThreadSafe.getInstance();
//        s.setMyField(6);
//    };
//
//    Thread t1 = new Thread(r1);
//    Thread t2 = new Thread(r2);
//
//    t1.start();
//    t2.start();

    //MyThread (Not Synchronized)

//    MyThread t1 = new MyThread("T1");
//    MyThread t2 = new MyThread("T2");
//
//    t1.start();
//    t2.start();

    //MyThreadSynch (Synchronized)

    MyThreadSynch t1 = new MyThreadSynch("T1");
    MyThreadSynch t2 = new MyThreadSynch("T2");

    t1.start();
    t2.start();

}
