package xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "bookStore")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookStore {

    @XmlElementWrapper(name = "bookList")
    @XmlElement(name = "book")
    private ArrayList<Book> bookList;
    private String name;

    public BookStore() {
    }

    public BookStore(ArrayList<Book> bookList, String name) {


        this.bookList = bookList;
        this.name = name;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String getName() {
        return name;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "bookList=" + bookList +
                ", name='" + name + '\'' +
                '}';
    }
}
