import java.util.*;

public class Driver {
    private static List<Book> bookCollection;
    private static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        bookCollection = DatasetReader.loadBooks("data.csv");
        System.out.println("Successfully loaded " + bookCollection.size() + " books.\n");

        while (true) {
            showMenu();
            int option = inputScanner.nextInt();
            inputScanner.nextLine(); // Clear the newline character

            switch (option) {
                case 1 -> countBooksByAuthor();
                case 2 -> listAllAuthors();
                case 3 -> displayBooksByAuthor();
                case 4 -> filterBooksByRating();
                case 5 -> calculateAuthorBookPrices();
                case 6 -> displayAllBooks();
                case 7 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    private static void showMenu() {
        System.out.println("========== Book Database ==========");
        System.out.println("1. Count books by an author");
        System.out.println("2. List all authors");
        System.out.println("3. Show books by an author");
        System.out.println("4. Filter books by rating");
        System.out.println("5. Calculate total price of books by an author");
        System.out.println("6. Display all books");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void countBooksByAuthor() {
        System.out.print("Enter the author's name: ");
        String author = inputScanner.nextLine();

        long count = bookCollection.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .count();

        System.out.println("Number of books by " + author + ": " + count + "\n");
    }

    private static void listAllAuthors() {
        Set<String> authors = new TreeSet<>();
        for (Book book : bookCollection) {
            authors.add(book.getAuthor());
        }

        System.out.println("Authors in the dataset:");
        authors.forEach(author -> System.out.println("- " + author));
        System.out.println("Total authors: " + authors.size() + "\n");
    }

    private static void displayBooksByAuthor() {
        System.out.print("Enter the author's name: ");
        String author = inputScanner.nextLine();

        List<String> titles = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                titles.add(book.getTitle());
            }
        }

        if (titles.isEmpty()) {
            System.out.println("No books found for author: " + author + "\n");
        } else {
            System.out.println("Books by " + author + ":");
            titles.forEach(title -> System.out.println("- " + title));
            System.out.println();
        }
    }

    private static void filterBooksByRating() {
        System.out.print("Enter the desired rating: ");
        double rating = inputScanner.nextDouble();

        List<Book> filteredBooks = bookCollection.stream()
                .filter(book -> book.getUserRating() == rating)
                .toList();

        if (filteredBooks.isEmpty()) {
            System.out.println("No books found with rating " + rating + "\n");
        } else {
            System.out.println("Books with rating " + rating + ":");
            filteredBooks.forEach(book -> System.out.println("- " + book.getTitle() + " by " + book.getAuthor()));
            System.out.println("Total books: " + filteredBooks.size() + "\n");
        }
    }

    private static void calculateAuthorBookPrices() {
        System.out.print("Enter the author's name: ");
        String author = inputScanner.nextLine();

        List<Book> authorBooks = bookCollection.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();

        if (authorBooks.isEmpty()) {
            System.out.println("No books found for author: " + author + "\n");
        } else {
            double totalPrice = 0;
            System.out.println("Books by " + author + ":");
            for (Book book : authorBooks) {
                System.out.println("- " + book.getTitle() + ": $" + book.getPrice());
                totalPrice += book.getPrice();
            }
            System.out.println("Total price: $" + totalPrice + "\n");
        }
    }

    private static void displayAllBooks() {
        System.out.println("Books in the database:");
        bookCollection.forEach(Book::printDetails);
    }
}