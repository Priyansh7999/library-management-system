import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");

            System.out.println("1. List books");
            System.out.println("2. Add book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Display Borrowed Books");
            System.out.println("6. Exit");

            System.out.print("Enter your choice(in numbers from 1 to 6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: // to display books
                    library.displayBooks();
                    break;

                case 2: // Add book feature
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter number of copies: ");
                    String copies = scanner.nextLine();

                    library.addBook(title, author, copies);

                    System.out.println("Book added successfully.");
                    break;
                case 3: // Borrow book feature
                    System.out.print("Enter student mobile: ");
                    String studentMobile = scanner.nextLine();

                    Student student = library.findStudentByMobile(studentMobile);
                    boolean isNewStudent = false;

                    if (student == null) {
                        System.out.print("Enter student name: ");
                        String studentName = scanner.nextLine();
                        student = new Student(studentName, studentMobile);
                        isNewStudent = true;
                    }

                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();

                    if (!library.isBookAvailable(bookTitle)) {
                        System.out.println("Book not available. Borrow not possible.");
                        break;
                    }
                    if (isNewStudent) {
                        library.addStudent(student);
                    }
                    library.borrowBook(bookTitle, student);
                                        break;
                
                case 4: // to return book
                    System.out.print("Enter Student Mobile Number: ");
                    String studMobileNumber = scanner.nextLine();

                    library.returnBook(studMobileNumber);

                    break;

                case 5: // Display Borrowed Books - YOUR ROLE
                    library.displayBorrowedBooks();
                    break;
                
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;


                default:
                    System.out.println("Invalid choice. Try again.");

            }

        }
    }
}
