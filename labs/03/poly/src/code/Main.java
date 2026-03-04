import code.Auto;
import code.Plane;
import code.Vehicle;

void main() {

    Auto a = new Auto(500, 5);
    Plane p = new Plane(2000, 20000);
    a.myDisplay();
    p.myDisplay();

    Vehicle v = null;
    v = a;
    v.myDisplay();
    //    v = p;
    //    v.myDisplay();
    Auto auto = (Auto)v;

    //Casting error if v references an Auto object
    //Plane plane = (Plane)v;

    //traditional try/catch with connection close
    //open connection
    //try{
    //write to file
    //}finally{
    //close connection
    //}

    //try-with-resource
    //try(code.Auto a = new code.Auto)
    //close method from class Auto will be called implicitly after try-with-resources finishes

    System.out.println(Auto.getAutoNo());

    try(Auto temp = new Auto(300, 4)){
        System.out.println(Auto.getAutoNo());
    }
    System.out.println(Auto.getAutoNo());
}

