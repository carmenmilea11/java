//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test2.txt"));
        URL url1 = new URL("https://google.com");
        URL url2 = url1;
        URL url3 = url1;

        ObjectsGraph og = new ObjectsGraph(url1, url2);
        oos.writeObject(og);
        oos.writeObject(url3);

        oos.close();
        System.out.println("og.url1 == url3 " + (og.getUrl1() == url3));
        System.out.println("og.url1 == og.url2 " + (og.getUrl1() == og.getUrl2()));

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test2.txt"));
        ObjectsGraph og2 = (ObjectsGraph) ois.readObject();
        URL url4 = (URL)ois.readObject();

        System.out.println(og2);
        System.out.println(url4);

        System.out.println("og2.url1 == url4 " + (og2.getUrl1() == url4));
        System.out.println("og2.url1 == og2.url2 " + (og2.getUrl1() == og2.getUrl2()));


    } catch (IOException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

}
