import java.util.*;

public class Library {

    private Map<String, List<String>> availableBooksByTitle = new HashMap<>();
    
    public void addBook(String id, String title, String availableCopies) {
        // Add refined addBook logic

        // validation - does book with same name already exist]
        if (hasBookWithTitle(title)) {
            System.out.println("The book with this title already exists");
            return;
        }

        // Create new book object
        Book book = new Book(id, title);

        // generate a simple key value pair such as {"Book Title": ["Id 1", "Id 2"]}
        generateBookCopyIds(title, availableCopies);

        // Add the book map to the hashmap of books.
    }

    public boolean hasBookWithTitle(String title) {
        return availableBooksByTitle.containsKey(title);
    }

    public void displayBooks() {
        if (availableBooksByTitle.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
    }

    public void generateBookCopyIds(String title, String availableCopies) {
        int copies = Integer.parseInt(availableCopies);

        List<String> copyId = new ArrayList<>();
        
        for (int i=1; i<=copies; i++){
            copyId.add(title + String.valueOf(i));
        }

        availableBooksByTitle.put(title, copyId);
    }
}