import java.util.*;

public class Library {

    private int totalAvailableBooks = 0;
    private List<Book> availableBooks = new ArrayList<>();
    private List<Student> students = new ArrayList<>();


    public void addBook(String title, String author, String availableCopies) {
        int copies = Integer.parseInt(availableCopies);

        for (int i = 1; i <= copies; i++) {
            totalAvailableBooks++;
            String bookId = title.toLowerCase() + totalAvailableBooks;
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






    public void displayBooks() {
        for (Book book : availableBooks) {
            System.out.println(
                "ID: " + book.getBookId() +", Title: " + book.getTitle() +", Author: " + book.getAuthor()
            );
        }
    }

}