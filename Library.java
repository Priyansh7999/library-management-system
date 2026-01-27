import java.util.*;

public class Library {

    private Map<String, List<String>> books = new HashMap<>();
    
    public void addBook(String title) {
        // Add refined addBook logic

        // validation - does book with same name already exist]
        if (hasBookWithTitle(title)) {
            System.out.println("The book with this title already exists");
            return;
        }

        // generate a simple key value pair such as {"Book Title": ["Id 1", "Id 2"]}

        // Add the book map to the hashmap of books.
    }

    public boolean hasBookWithTitle(String title) {
        return books.containsKey(title);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
    }
}