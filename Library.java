import java.util.*;

public class Library {

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

}