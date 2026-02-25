
public class Main{
    public static void main(String[] args){
        Student[] students = new Student[4];
        students[0] = new Student("S1", new short[] {3,5,8,10});
        students[1] = new Student("S2", new short[] {10, 9, 10});
        students[2] = new Student("S3", new short[] {3, 7,9,1});
        students[3] = students[2].clone();

        System.out.println(students[2]);
        System.out.println(students[3]);

        students[3].setStudentName("S5");
        students[3].setMarks(new short[]{10, 10, 10});

        System.out.println(students[2]);
        System.out.println(students[3]);

//        for (Student student : students) {
//            System.out.println(student);
//        }
//
//        System.out.println("Student at index 2 equals student at index 3 (using ==): "+ (students[2] == students[3]));
//        System.out.println("Student at index 2 equals student at index 3 (using equals): "+ students[2].equals(students[3]));
//        System.out.println("Student at index 0 equals student at index 1 (using equals): "+ students[0].equals(students[1]));



    }
}