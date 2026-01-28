import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");

            System.out.println("1. list books");
            System.out.println("2. add book");
            System.out.println("3. to borrow book");

           // System.out.println("4. to return book");
           System.out.println("4. exit");

            System.out.print("Enter your choice(in numbers from 1 to 4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: // to display books
                    library.displayBooks();
                    break;

                case 2: //Add book Feature
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter number of copies: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();

                    library.addBook(title, copies);
                    System.out.println("Book added successfully.");
                    break;
                 case 3: // to borrow book
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();

                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();

                    Student student = new Student(studentId, studentName);

                    System.out.print("Enter book title: ");
                    String borrowTitle = scanner.nextLine();

                    if (library.borrowBook(borrowTitle, student)) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not available or already borrowed.");
                    }
                    break;

                // case 4: // to return book
                //     System.out.print("Enter student ID: ");
                //     String returnId = scanner.nextLine();

                //     System.out.print("Enter student name: ");
                //     String returnName = scanner.nextLine();

                //     Student returnStudent = new Student(returnId, returnName);

                //     System.out.print("Enter book title: ");
                //     String returnTitle = scanner.nextLine();

                //     if (library.returnBook(returnTitle, returnStudent)) {
                //         System.out.println("Book returned successfully.");
                //     } else {
                //         System.out.println("Invalid return request.");
                //     }
                //     break;

                case 4: 
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");

            }
            
        }
    }
}
