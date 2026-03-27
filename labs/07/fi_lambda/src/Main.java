
@FunctionalInterface
interface Greetings{
    void greet(String message);
}

@FunctionalInterface
interface MathOperation{
    int operation(int a, int b);
}

class Math{
    int calculate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}

void main() {

    Greetings g1 = (String s) -> {
        System.out.println("G1 " + s);
    };

    Greetings g2 = message -> System.out.println("G2 "+ message);

    g1.greet("Test");
    g2.greet("Test2");

    MathOperation add = (a, b) -> a+b;
    MathOperation substract = (x,y) -> x-y;

    int first = 7;
    int second = 9;

    Math math = new Math();
    System.out.println("a + b " + math.calculate(first, second, add));
    System.out.println("a - b " + math.calculate(first, second, substract));

}
