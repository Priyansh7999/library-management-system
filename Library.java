import java.util.*;

public class Library {
    
    Scanner scanner = new Scanner(System.in);

    private int bookIdCounter = 0;
    private List<Book> availableBooks = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private Map<String, List<Book>> borrowedBooksByStudentID = new HashMap<>();


    public void addBook(String title, String author, String availableCopies) {
        int copies = Integer.parseInt(availableCopies);

        for (int i = 1; i <= copies; i++) {
            bookIdCounter++;
            String bookId = title.toLowerCase() + bookIdCounter;
            Book book = new Book(bookId, title.toLowerCase(), author.toLowerCase());
            availableBooks.add(book);
        }
    }
    public boolean isBookAvailable(String title) {
    for (Book book : availableBooks) {
        if (book.getTitle().equalsIgnoreCase(title)) {
            return true;
        }
    }
    return false;
}
    public Student findStudentByMobile(String mobile) {
    for (Student student : students) {
        if (student.getMobileNumber().equals(mobile)) {
            return student;
        }
    }
    return null;
}
    public void addStudent(Student student) {
        students.add(student);
    }
    public void borrowBook(String bookName, Student student) {
    int firstIndex = -1;
    for (int i = 0; i < availableBooks.size(); i++) {
        if (availableBooks.get(i).getTitle().equalsIgnoreCase(bookName)) {
            firstIndex = i;
            break;
        }
    }
    if (firstIndex == -1) {
        System.out.println("Book not available: " + bookName);
        return;
    }

    Book borrowedBook = availableBooks.remove(firstIndex);

    borrowedBooksByStudentID
            .computeIfAbsent(student.getId(), id -> new ArrayList<>())
            .add(borrowedBook);

    System.out.println(
            "Book borrowed successfully | " +
            "Title: " + borrowedBook.getTitle() +
            " | Book ID: " + borrowedBook.getBookId() +
            " | Student ID: " + student.getId()
    );
}








    public void displayBooks() {
        for (Book book : availableBooks) {
            System.out.println(
                "ID: " + book.getBookId() +", Title: " + book.getTitle() +", Author: " + book.getAuthor()
            );
        }
    }

    public void returnBook(String studMobileNumber){
        
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