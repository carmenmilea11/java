package code;

public class Vehicle implements Movable{

    private int weight;

    public Vehicle(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void myDisplay(){
        System.out.println("code.Vehicle");
    }

    @Override
    public void startEngine() {
        System.out.println("code.Vehicle startEngine()");
    }

    @Override
    public void stopEngine() {
        System.out.println("code.Vehicle stopEngine()");
    }
}
