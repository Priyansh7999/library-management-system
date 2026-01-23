import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();
    
    public void addBook(String title, int copies) {
        books.add(new Book(title, copies));
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println(book.displayInfo());
        }
    }
}