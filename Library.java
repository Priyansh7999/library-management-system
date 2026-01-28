import java.util.*;

public class Library {

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

    public void displayBooks() {
    if (availableBooks.isEmpty()) {
        System.out.println("No books available in the library.");
        return;
    }
    
    System.out.println("\nList of available books:");
    for (int i = 0; i < availableBooks.size(); i++) {
        Book book = availableBooks.get(i);
        System.out.println((i + 1) + ". " + book.getTitle() + 
                          " by " + book.getAuthor() + 
                          " (ID: " + book.getBookId() + ")");
    }
    System.out.println("Total: " + availableBooks.size() + " books");
}


public void displayBorrdevelopowedBooks() {
    if (borrowedBooksByStudentID.isEmpty()) {
        System.out.println("No books are currently borrowed.");
        return;
    }
    
    System.out.println("\nLIST OF BORROWED BOOKS:");
    int bookCount = 1;
    
    for (Map.Entry<String, List<Book>> entry : borrowedBooksByStudentID.entrySet()) {
        String studentId = entry.getKey();
        
        for (Book book : entry.getValue()) {
            System.out.println(bookCount + ". \"" + book.getTitle() + 
                             "\" borrowed by Student ID: " + studentId);
            bookCount++;
        }
    }
    
    System.out.println("Total borrowed books: " + (bookCount - 1));
}


}