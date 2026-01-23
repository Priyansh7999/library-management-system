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

            System.out.println("4. to return book");
            System.out.println("5. exit");

            System.out.print("Enter your choice(in numbers from 1 to 5): ");

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

            }
            return;
        }
    }
}
