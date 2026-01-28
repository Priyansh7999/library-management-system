import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();
    private Map<String, List<String>> availableBooksByTitle = new HashMap<>();
    private Map<String, String> borrowedBooks = new HashMap<>();

    private int totalAvailableBooks = 0;
    private List<Book> availableBooks = new ArrayList<>();

    public void addBook(String title, String author, String availableCopies) {
        int copies = Integer.parseInt(availableCopies);

        for (int i = 1; i <= copies; i++) {
            totalAvailableBooks++;
            String bookId = title.toLowerCase() + totalAvailableBooks;
            Book book = new Book(bookId, title.toLowerCase(), author.toLowerCase());
            availableBooks.add(book);
        }
    }
    public boolean hasBookWithTitle(String title) {
        return availableBooksByTitle.containsKey(title);
    }

    public void displayBooks() {
        for (Book book : availableBooks) {
            System.out.println(
                "ID: " + book.getBookId() +", Title: " + book.getTitle() +", Author: " + book.getAuthor()
            );
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