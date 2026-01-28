import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, String> borrowedBooks = new HashMap<>();

    //book title mapped to list of available bookIds
    protected Map<String, List<String>> availableBooksByTitle = new HashMap<>();

    // book title mapped to total number of copies of that particular book
    protected Map<String, Integer> numberOfCopiesByTitle = new HashMap<>();

    public boolean bookExists(String title) {
        return availableBooksByTitle.containsKey(title);
    }

    public int getTotalCopies(String title) {
        return numberOfCopiesByTitle.getOrDefault(title, 0);
    }


    public void addBook(String id, String title, String availableCopies) {

       
    }
    public boolean hasBookWithTitle(String title) {
        return availableBooksByTitle.containsKey(title);
    }

    public void displayBooks() {
        if (availableBooksByTitle.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println("Book Id: " + book.getBookId() + ", Book Title: " + book.getTitle());
        }
    }

    public void borrowBook(String title, Student student) {

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

        // bookId will be mapped to memberId
        borrowedBooks.put(issuedBookId, student.getId());

        System.out.println(
                "Book borrowed successfully | " +
                        "Title: " + title +
                        " | Book ID: " + issuedBookId +
                        " | Member ID: " + student.getId());
    }

    public void generateBookCopyIds(String title, String availableCopies) {
        int copies = Integer.parseInt(availableCopies);

        List<String> copyId = new ArrayList<>();

        for (int i = 1; i <= copies; i++) {
            copyId.add(title + String.valueOf(i));
        }

        availableBooksByTitle.put(title, copyId);
    }
}