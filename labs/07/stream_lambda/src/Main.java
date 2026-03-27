//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    List<String> myList = Arrays.asList("dfgs","fgdf","","","fdsfdsf","fsdfsf");

    int count = 0;
//
//    for(int i = 0; i < myList.size(); i++){
//        if(myList.get(i).length() == 0){
//            count++;
//        }
//    }

    for (String s : myList) {
        if (s.isEmpty()) {
            count++;
        }
    }

    System.out.println("Empty string count " + count);

    Predicate<String> p = s -> s.isEmpty();
    long count2 = myList.stream().filter(p).count();

    System.out.println("Empty string count2 " + count2);

    long count3 = myList.stream().filter(x -> x.isEmpty()).count();
    System.out.println("Empty string count3 " + count3);

    long count4 = myList.stream().filter(x -> x.length() == 4).count();
    System.out.println("Empty string count4 " + count4);

    //List<String> nonEmptyList = myList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
    List<String> nonEmptyList = myList.stream().filter(x -> !x.isEmpty()).toList();
    System.out.println("Non Empty List " + nonEmptyList);
    //int i = 1;
    List<Integer> intList = Arrays.asList(1,2,2,3,4,5,6,6,7,8,9);
    List<Integer> squaredlist = intList.stream().map(x -> x*x).distinct().toList();
    System.out.println("Squared List " + squaredlist);

    IntSummaryStatistics iss = intList.stream().mapToInt(x -> x).summaryStatistics();
    System.out.println("Min " + iss.getMin());
    System.out.println("Max " + iss.getMax());
    System.out.println("Avg " + iss.getAverage());
}
