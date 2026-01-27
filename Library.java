import java.util.*;

public class Library {

    private Map<String, List<String>> availableBooksByTitle = new HashMap<>();
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

    public void borrowBook(String title, Member member) {

    if (!availableBooksByTitle.containsKey(title)) {
        System.out.println("Book with this title does not exist.");
        return;
    }

    List<String> availableCopyIds = availableBooksByTitle.get(title);

    if (availableCopyIds.isEmpty()) {
        System.out.println("No available copies for this book.");
        return;
    }

    String issuedBookId = availableCopyIds.remove(0);

    // bookId -> memberId
    borrowedBooks.put(issuedBookId, member.getId());

    System.out.println(
        "Book borrowed successfully | " +
        "Title: " + title +
        " | Book ID: " + issuedBookId +
        " | Member ID: " + member.getId()
    );
}


    public boolean returnBook(String title, Student student) {
        if (!borrowedBooks.containsKey(title)) {
            return false;
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnCopy();
                borrowedBooks.remove(title);
                return true;
            }
        }
        return false;
    }
}