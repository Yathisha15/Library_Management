import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String checkoutStatus;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkoutStatus = "Available";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCheckOutStatus() {
        return checkoutStatus;
    }

    public void checkOut() {
        checkoutStatus = "Not avialable or Someone already taken from the library";
    }

    public void checkIn() {
        checkoutStatus = "Available";
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", status: " + checkoutStatus;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getCheckOutStatus().equals("Available")) {
                book.checkOut();
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found or already checked out.");
    }

    public void checkInBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getCheckOutStatus().equals("Not avialable or Someone already taken from the library")) {
                book.checkIn();
                System.out.println("Book checked in successfully.");
                return;
            }
        }
        System.out.println("Book not found or not checked out.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Parisarada Kathegalu", "Poornachandra Thejaswi");
        Book book2 = new Book("Malenadina Chithragalu", "Kuvempu");
        Book book3 = new Book("Karvalo", "Poornachandra Thejaswi");
        Book book4 = new Book("Ramayana Darshanam", "Kuvempu");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Books");
            System.out.println("2. Check Out a Book");
            System.out.println("3. Check In a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    library.checkOutBook(checkOutTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book to check in: ");
                    String checkInTitle = scanner.nextLine();
                    library.checkInBook(checkInTitle);
                    break;
                case 4:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
