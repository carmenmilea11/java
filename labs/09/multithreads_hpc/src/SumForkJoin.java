public class SumForkJoin {

    private final int threshold = 1000;

    private int startIndex;
    private int stopIndex;
    private int[] array;

    public SumForkJoin(int startIndex, int stopIndex, int[] array) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.array = array;
    }

    private Long compute(){
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

        }
    }
}

