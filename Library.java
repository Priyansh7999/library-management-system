import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();
    
    public void addBook(String title, int copies) {
        books.add(new Book(title, copies));
    }
}