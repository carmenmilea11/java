package code;

public class Auto extends Vehicle implements AutoCloseable{

    private int doorNo;
    private static int autoNo;

    public Auto(int weight, int doorNo) {
        super(weight);
        this.doorNo = doorNo;
        Auto.autoNo++;
    }

    public int getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(int doorNo) throws Exception {
        if(doorNo < 0) {
            throw new Exception("Negative doorNo not allowed");
        }
        this.doorNo = doorNo;
    }

    public static int getAutoNo() {
        return autoNo;
    }

    @Override
    public void myDisplay() {
        System.out.println("code.Auto");
    }

    @Override
    public void close(){
        Auto.autoNo--;
    }
}
