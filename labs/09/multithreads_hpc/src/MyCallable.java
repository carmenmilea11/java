import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {

    private int[] vector;
    private int startIndex;
    private int stopIndex;
    private Long sum;

    public MyCallable(int[] vector, int startIndex, int stopIndex) {
        this.vector = vector;
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public Long call() throws Exception {
        sum = 0L;
        for(int i = startIndex; i <= stopIndex; i++){
            sum += vector[i];
        }
        return sum;
    }
}
