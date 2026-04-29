//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

private static final int dimVect = 40_000_000;
private static final int noThreads = 4;

void main() {

    int[] vector = new int[dimVect];

    for(int i = 0; i < dimVect; i++){
        vector[i] = i + 1;
    }
    Long sum = 0L;
    long startTime, stopTime;

    //SEQUENTIAL
    startTime = System.currentTimeMillis();

    for(int i = 0; i < dimVect; i++){
        sum += vector[i];
    }

    stopTime = System.currentTimeMillis();

    System.out.println("Elapsed time: " + (stopTime - startTime) + " Sum: " + sum);

    //MULTI THREAD
    sum = 0L;
    startTime = System.currentTimeMillis();

    Thread[] threadVector = new Thread[noThreads];
    MyRunnable[] runnableVector = new MyRunnable[noThreads];

    for(int i = 0; i < noThreads; i++){
        int startIndex = i * (dimVect/noThreads);
        int stopIndex = (i + 1) * (dimVect/noThreads) - 1;
        runnableVector[i] = new MyRunnable(vector, startIndex, stopIndex);
        threadVector[i] = new Thread(runnableVector[i]);
    }
    //T0: startIndex 0, stopIndex 9,999,999
    //T1: startIndex 10,000,000, stopIndex 19,999,999
    //T2: startIndex 20,000,000, stopIndex 29,999,999
    //T3: startIndex 30,000,000, stopIndex 39,999,999

    for(int i = 0; i < noThreads; i++){
        threadVector[i].start();
    }

    for(int i = 0; i < noThreads; i++){
        try {
            threadVector[i].join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    for(int i = 0; i < noThreads; i++){
        sum += runnableVector[i].getSum();
    }

    stopTime = System.currentTimeMillis();

    System.out.println("Elapsed time: " + (stopTime - startTime) + " Sum: " + sum);

    //MULTI THREADING - EXECUTOR SERVICE
    sum = 0L;
    startTime = System.currentTimeMillis();

    ExecutorService executorService = Executors.newFixedThreadPool(noThreads);
    runnableVector = new MyRunnable[noThreads];

    for(int i = 0; i < noThreads; i++){
        int startIndex = i  * (dimVect/noThreads);
        int stopIndex = (i + 1) * (dimVect/noThreads) - 1;
        runnableVector[i] = new MyRunnable(vector, startIndex, stopIndex);
        executorService.execute(runnableVector[i]);
    }

    executorService.shutdown(); //no new commands accepted
    try {
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    for(int i = 0; i < noThreads; i++){
        sum += runnableVector[i].getSum();
    }

    stopTime = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (stopTime - startTime) + " Sum: " + sum);

    // CALLABLE
    sum = 0L;
    startTime = System.currentTimeMillis();

    executorService = Executors.newFixedThreadPool(noThreads);
    List<Future<Long>> futureList = new ArrayList<Future<Long>>();

    for(int i = 0; i < noThreads; i++){
        int startIndex = i * (dimVect/noThreads);
        int stopIndex = (i + 1) * (dimVect/noThreads) - 1;

        Callable<Long> myCallable = new MyCallable(vector, startIndex, stopIndex);
        Future<Long> myFuture =  executorService.submit(myCallable);
        futureList.add(myFuture);
    }

    for(int i = 0; i < noThreads; i++){
        try {
            sum += futureList.get(i).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    executorService.shutdown(); // no new commands accepted
    try {
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    stopTime = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (stopTime - startTime) + " Sum: " + sum);

}
