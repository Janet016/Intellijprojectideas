//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}

 class Library { // Ensure this is declared in a file named Library.java
    private static final Map<String, Book> library = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    borrowBooks(scanner);
                    break;
                case 3:
                    returnBooks(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void addBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity  = quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book book = library.get(title);
        if (book != null) {
            book.quantity += quantity;
            System.out.println("Updated the quantity of \"" + title + "\" by " + author + " to " + book.quantity);
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("Added \"" + title + "\" by " + author + " with quantity " + quantity);
        }
    }

    private static void borrowBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to borrow: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book book = library.get(title);
        if (book != null) {
            if (book.quantity >= quantity) {
                book.quantity -= quantity;
                System.out.println("Borrowed " + quantity + " copy/copies of \"" + title + "\" by " + book.author);
            } else {
                System.out.println("Not enough copies of \"" + title + "\" by " + book.author + " available.");
            }
        } else {
            System.out.println("Book \"" + title + "\" does not exist in the library.");
        }
    }

    private static void returnBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to return: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book book = library.get(title);
        if (book != null) {
            book.quantity += quantity;
            System.out.println("Returned " + quantity + " copy/copies of \"" + title + "\" by " + book.author);
        } else {
            System.out.println("Book \"" + title + "\" does not exist in the library.");
        }
    }
}