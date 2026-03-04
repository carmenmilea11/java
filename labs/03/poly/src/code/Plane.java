package code;

public class Plane extends Vehicle{

    private int maxAlt;

    public Plane(int weight, int maxAlt) {
        super(weight);
        this.maxAlt = maxAlt;
    }

    public int getMaxAlt() {
        return maxAlt;
    }

    public void setMaxAlt(int maxAlt) {
        this.maxAlt = maxAlt;
    }

    @Override
    public void myDisplay() {
        System.out.println("code.Plane");
    }
}
