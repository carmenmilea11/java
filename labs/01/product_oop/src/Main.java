public class Main {
    public static void main(String[] args) {

        //int Copy Sample (Value Type)
        int a = 1;
        int b = 2;

        System.out.println("Initial values:");
        System.out.println("a: "+ a);
        System.out.println("b: "+ b);

        b = a;
        b = 3;

        System.out.println("Values after b = a and b = 3");
        System.out.println("a: "+ a);
        System.out.println("b: "+ b);

        //String Copy Sample (Reference Type, Immutable)
        String first = "a";
        String second = "b";

        System.out.println("Initial values");
        System.out.println("first: " + first);
        System.out.println("second: " + second);

        second = first;
        second = "c";

        System.out.println("Values after second = first and second = 'c'");
        System.out.println("first: " + first);
        System.out.println("second: " + second);

        //Product Class Copy Sample (Reference Type)

        Product p1 = new Product(2000, "Laptop");
        Product p2 = new Product(100, "Mouse");

        System.out.println("Initial values:");
        System.out.println("p1: price: "+ p1.getPrice() + " name: " + p1.getName());
        System.out.println("p2: price: "+ p2.getPrice() + " name: " + p2.getName());

        //Shallow Copy - Ensure below line is uncommented and Deep Copy line is commented
        //p2 = p1;

        //Deep Copy - Ensure below line is uncommented and Shallow Copy is commented
        p2 = p1.myClone();

        p2.setPrice(300);

        System.out.println("Values after Deep Copy or Shallow Copy");
        System.out.println("p1: price: "+ p1.getPrice() + " name: " + p1.getName());
        System.out.println("p2: price: "+ p2.getPrice() + " name: " + p2.getName());

    }
}
