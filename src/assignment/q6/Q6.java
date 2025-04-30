package assignment.q6;
import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        Map<String, Set<Book>> catalog = new HashMap<>();

        // Add books to genres
        addBook(catalog, "Science Fiction", new Book("Dune", "Frank Herbert", 1965));
        addBook(catalog, "Science Fiction", new Book("Neuromancer", "William Gibson", 1984));
        addBook(catalog, "Science Fiction", new Book("Dune", "Frank Herbert", 1965)); // Duplicate
        addBook(catalog, "Fantasy", new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        addBook(catalog, "Fantasy", new Book("Harry Potter", "J.K. Rowling", 1997));

        // Print all books in each genre, sorted by year
        for (String genre : catalog.keySet()) {
            System.out.println("\nGenre: " + genre);
            catalog.get(genre).stream()
                    .sorted(Comparator.comparingInt(Book::getPublicationYear))
                    .forEach(System.out::println);
        }
    }

    private static void addBook(Map<String, Set<Book>> catalog, String genre, Book book) {
        catalog.computeIfAbsent(genre, k -> new HashSet<>()).add(book);
    }
}
