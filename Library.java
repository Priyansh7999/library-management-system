import java.util.*;

public class Library {

    private Map<String, List<String>> books = new HashMap<>();
    
    public void addBook(String title) {
        // Add refined addBook logic

        // validation - does book with same name already exist

        // generate a simple key value pair such as {"Book Title": ["Id 1", "Id 2"]}

        // Add the book map to the hashmap of books.
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
    }
}