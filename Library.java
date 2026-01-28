import java.util.*;

public class Library {

    private int bookIdCounter = 0;
    private List<Book> availableBooks = new ArrayList<>();

    public void addBook(String title, String author, String availableCopies) {
        int copies = Integer.parseInt(availableCopies);

        for (int i = 1; i <= copies; i++) {
            bookIdCounter++;
            String bookId = title.toLowerCase() + bookIdCounter;
            Book book = new Book(bookId, title.toLowerCase(), author.toLowerCase());
            availableBooks.add(book);
        }
    }

    public void displayBooks() {
        for (Book book : availableBooks) {
            System.out.println(
                "ID: " + book.getBookId() +", Title: " + book.getTitle() +", Author: " + book.getAuthor()
            );
        }
    }
}