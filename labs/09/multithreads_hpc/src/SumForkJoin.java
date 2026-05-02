import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumForkJoin extends RecursiveTask<Long> {

    private final int threshold = 5000;

    private int startIndex;
    private int stopIndex;
    private int[] array;

    public SumForkJoin(int startIndex, int stopIndex, int[] array) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.array = array;
    }

    protected Long compute(){
        if(stopIndex - startIndex <= threshold){
            Long sum = 0L;
            for(int i = startIndex; i < stopIndex; i++){
                sum += array[i];
            }
            return sum;
        }else{
            int middle = startIndex + (stopIndex - startIndex) / 2;
            SumForkJoin left = new SumForkJoin(startIndex, middle, array);
            SumForkJoin right = new SumForkJoin(middle, stopIndex, array);
            left.fork();
            Long rightResult = right.compute();
            Long leftResult = left.join();
            return leftResult + rightResult;

        }
    }

}

