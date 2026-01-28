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
        for (Book book : availableBooks) {
            System.out.println(
                "ID: " + book.getBookId() +", Title: " + book.getTitle() +", Author: " + book.getAuthor()
            );
        }
    }

    public void returnBook(String studMobileNumber){
        // Logic for returning book
        
        // verify if student member has borrowed any book -> hasUserBorrowedBook()
        if(!hasUserBorrowedBook()){
            System.out.print("This student member has not borrowed any book.");
        } else {
            System.out.println("Enter your choice: ");
            // Output: “Choose a book. Enter your choice:” (Iterate borrowedBooks and print Book.name)
            // Input: choice number
            // returnBook()
        }
        
        // Remove book from Borrowed books -> removeBorrowedBook()
        // Add book in available books -> addBookInAvailableBooks()

        // Print message "Book returned successfully"
    }

    public boolean hasUserBorrowedBook(){
        // Logic to check if Student has borrowed book
        return true; // Temporirily assigning true for testing.
    }

}