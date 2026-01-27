import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");

            System.out.println("1. list books");
            System.out.println("2. add book");
            System.out.println("3. exit");

            System.out.print("Enter your choice(in numbers from 1 to 3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: // to display books
                    library.displayBooks();
                    break;

                case 2: //Add book Feature
                    System.out.print("Enter book ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter number of copies: ");
                    String copies = scanner.nextLine();

                    library.addBook(id, title, copies);
                    System.out.println("Book added successfully.");
                    break;

                case 3: 
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");

            }
            
        }
    }
}
