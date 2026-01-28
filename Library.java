import java.util.*;

public class Library {
    
    Scanner scanner = new Scanner(System.in);

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
        Map<String, List<Book>> borrowedBooksByStudentID = new HashMap<>();
        
        // Dummy record
        borrowedBooksByStudentID.put(
            "STUD1",
            new ArrayList<>(List.of(
                new Book("1", "Harry potter", "JK Rowling"),
                new Book("1", "Harry potter", "JK Rowling")
            ))
        );

        // verify if student member has borrowed any book -> hasUserBorrowedBook()
        if(!hasUserBorrowedBook(studMobileNumber, borrowedBooksByStudentID)){
            System.out.print("This student member has not borrowed any book.");
        } else {
            // Output: “Choose a book. Enter your choice:” (Iterate borrowedBooksByStudentID and print Book.name)
            System.out.println("\nWhich book do you want to return:");

            borrowedBooksByStudentID.forEach((studentId, books) -> {
                for (Book book: books) {
                    System.out.println(book.getTitle());
                }
            });

            String bookTitle = scanner.nextLine();
            

            // Input: choice number
            // returnBook()
        }
        
        // Remove book from Borrowed books -> removeBorrowedBook()
        // Add book in available books -> addBookInAvailableBooks()

        // Print message "Book returned successfully"
    }

    public Student findStudentByMobile(String mobile, List<Student> students) {
        for (Student student : students) {
            if (student.getMobileNumber().equals(mobile)) {
                return student;
            }
        }
        return null;
    }
    
    public boolean hasUserBorrowedBook(String mobileNumber, Map<String, List<Book>> borrowedBooksByStudentID){
        // Logic to check if Student has borrowed book
        List<Student> students = new ArrayList<>(); //temp variable
        
        Student student = findStudentByMobile(mobileNumber, students);

        if(!borrowedBooksByStudentID.containsKey(student.getId())){
           return false;
        } else {
            return true;
        }
    }

}