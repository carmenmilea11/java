public class MyRunnable implements Runnable{

    private int[] vector;
    private int startIndex;
    private int stopIndex;
    private Long sum;

    public MyRunnable(int[] vector, int startIndex, int stopIndex) {
        this.vector = vector;
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public void run() {
        long mySum = 0;

        for(int i = startIndex; i <= stopIndex; i++){
            mySum += vector[i];
        }

        sum = mySum;
    }

    public Long getSum() {
        return sum;
    }
}
