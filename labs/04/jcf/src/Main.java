//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

//    Plane[] myArray = new Plane[10];
//    for(int i = 0; i < 5; i++){
//        myArray[i] = new Plane(i, "Airbus" + i);
//    }
//    for(int i = 0; i < 3; i++){
//        System.out.println(myArray[i]);
//    }

   // List<Plane> myPlanes = new ArrayList<Plane>(100);
//    List<Plane> myPlanes = new LinkedList<Plane>();
//
//    for(int i = 0; i < 5; i++){
//        myPlanes.add(new Plane(i, "Airbus"+ i));
//    }
//
//    for(int i = 0; i < myPlanes.size(); i++){
//        System.out.println(myPlanes.get(i));
//    }

   // Map<Plane, Country> myMap = new HashMap<Plane, Country>();
    Map<Plane, Country> myMap = new TreeMap<Plane, Country>();
    for(int i = 0; i < 5; i++){
        Plane myPlane = new Plane(i, "Airbus"+ i);
        Country country = new Country(100 + i, "Name" + i);
        myMap.put(myPlane, country);
    }

    Plane myPlane = new Plane(0, "Airbus"+ 0);
    Country country = new Country(900, "Romania");
    myMap.put(myPlane, country);

    Set<Plane> set = myMap.keySet();
//    for(Plane p : set){
//        Country c = myMap.get(p);
//        System.out.println(p);
//        System.out.println(c);
//        System.out.println("--------");
//    }
    Iterator<Plane> i = set.iterator();
    for(;i.hasNext();){
        Plane p = i.next();
        Country c = myMap.get(p);
        System.out.println(p);
        System.out.println(c);
        System.out.println("--------");
    }

}
