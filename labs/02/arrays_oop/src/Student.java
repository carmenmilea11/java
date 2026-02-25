import java.util.Arrays;
import java.util.Objects;

public class Student implements Cloneable{

    private String studentName;
    private short[] marks;
    private float averageMark;

    public Student(String studentName, short[] marks) {
        this.studentName = studentName;
        this.marks = marks;
        getAverageMark();
    }

    public String getStudentName() {
        return studentName;
    }

    public short[] getMarks() {
        return marks;
    }

    public float getAverageMark() {
        float result = 0;

        for(int i = 0; i < marks.length; i++){
            result += marks[i];
        }

        result /= marks.length;
        averageMark = result;
        return averageMark;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setMarks(short[] marks) {
        this.marks = marks;
        getAverageMark();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", marks=" + Arrays.toString(marks) +
                ", averageMark=" + averageMark +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if(this == o)
            return true;

        if(o == null)
            return false;

        if(this.getClass() != o.getClass())
            return false;

        Student other = (Student) o;

        //student name
        if(!this.studentName.equals(other.getStudentName()))
            return false;

        //marks
        if(!Arrays.equals(this.marks, other.getMarks()))
            return false;

        //averageMarks
        if(Float.floatToIntBits(this.averageMark) != Float.floatToIntBits(other.averageMark))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, Arrays.hashCode(marks), averageMark);
    }


    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            clone.setMarks(this.marks.clone());
            return clone;
        } catch (CloneNotSupportedException e) {
        }

        return null;
    }
}
