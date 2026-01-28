import java.util.*;

public class Library {

    Scanner scanner = new Scanner(System.in);

    private int bookIdCounter = 0;
    private List<Book> availableBooks = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private Map<String, List<Book>> borrowedBooksByStudentID = new HashMap<>();

    public void addBook(String title, String author, String availableCopies) {
        availableCopies = availableCopies.trim();
        title = title.trim();
        author = author.trim();
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
    public boolean isValidIndiaMobile(String number) {
        // Regex allows +91, 91, or 0 prefixes, followed by 10 digits starting with 6-9
        String regex = "^(\\+91[\\-\\s]?)?[0]?(91)?[6-9]\\d{9}$";
        return number != null && number.matches(regex);
    }

    public boolean isValidPersonName(String name) {
        if (name == null)
            return false;

        name = name.trim();
        return !name.isEmpty() && name.matches("[a-zA-Z\\s]+");
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
                        " | Student ID: " + student.getId());
    }

    public void returnBook(String studMobileNumber) {

        Student student = findStudentByMobile(studMobileNumber);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String studentId = student.getId();

        if (!hasUserBorrowedBook(studMobileNumber)) {
            System.out.println("This student member has not borrowed any book.");
            return;
        }

        List<Book> borrowedBooks = borrowedBooksByStudentID.get(studentId);

        System.out.println("\nBorrowed books:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }

        System.out.print("\nEnter book title to return: ");
        String bookTitle = scanner.nextLine();

        Book returnedBook = null;

        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                returnedBook = book;
                break;
            }
        }

        borrowedBooks.remove(returnedBook);
        availableBooks.add(returnedBook);
        if (borrowedBooks.isEmpty()) {
            borrowedBooksByStudentID.remove(studentId);
        }

        System.out.println(
                "Book returned successfully | " +
                        "Title: " + returnedBook.getTitle() +
                        " | Book ID: " + returnedBook.getBookId());
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

    public void displayBorrowedBooks() {
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

    public Student findStudentByMobile(String mobile, List<Student> students) {
        for (Student student : students) {
            if (student.getMobileNumber().equals(mobile)) {
                return student;
            }
        }
        return null;
    }

    public boolean hasUserBorrowedBook(String mobileNumber) {

        Student student = findStudentByMobile(mobileNumber);

        if (student == null) {
            return false;
        }

        return borrowedBooksByStudentID.containsKey(student.getId());
    }

    public boolean isValidNumberInput(String numberInput) {
        numberInput = numberInput.trim();
        return numberInput != null && numberInput.matches("\\d+") && Integer.parseInt(numberInput) > 0;
    }

}