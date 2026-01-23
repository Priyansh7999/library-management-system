import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();
    private Map<String, String> borrowedBooks = new HashMap<>();
    
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

    public boolean borrowBook(String title, Student student) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                if (borrowedBooks.containsKey(title)) {
                    return false;
                }

                book.borrowCopy();
                borrowedBooks.put(title, student.getName());
                return true;
            }
        }
        return false;
    }
}