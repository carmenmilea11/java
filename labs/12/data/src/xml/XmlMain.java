package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class XmlMain {
    public static void main(){
        ArrayList<Book> bookList = new ArrayList<>();

        Book book1 = new Book("Book 1", "Author 1");
        Book book2 = new Book("Book 2", "Author 2");

        bookList.add(book1);
        bookList.add(book2);

        BookStore bookStore = new BookStore(bookList, "Carturesti");

        try {
            //WRITE XML
            JAXBContext context = JAXBContext.newInstance(BookStore.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(bookStore, System.out);
            marshaller.marshal(bookStore, new File("myXml.xml"));

            //READ XML
            Unmarshaller unmarshaller = context.createUnmarshaller();
            BookStore bookStore2 = (BookStore) unmarshaller.unmarshal(new FileReader("myXml.xml"));

            System.out.println(bookStore2.toString());


        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
