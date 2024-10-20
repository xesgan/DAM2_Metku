package org.Controller;

import org.Model.Author;
import org.Model.Book;
import org.Model.LibraryException;

import java.util.ArrayList;
import java.util.List;

/**
 * LibraryController manages the library's authors and books.
 * It provides methods to find authors by name and to retrieve books
 * associated with specific authors.
 *
 * Author: xesgan - Elias Roig
 */
public class LibraryController {
    private List<Author> authors;
    private List<Book> books;

    /**
     * Constructor for LibraryController that initializes the authors
     * and books lists and populates them with sample data.
     *
     * @throws LibraryException If there is an issue initializing the data.
     */
    public LibraryController() throws LibraryException {
        authors = new ArrayList<>();
        books = new ArrayList<>();
        initializeDatabase(); // Method to initialize data
    }

    /**
     * Initializes the sample data for authors and books.
     *
     * @throws LibraryException If there is an issue creating the authors or books.
     */
    private void initializeDatabase() throws LibraryException {
        // Adding authors
        authors.add(new Author("George", "Orwell"));
        authors.add(new Author("Aldous", "Huxley"));

        // Adding books
        books.add(new Book("1984", 1949, List.of(authors.get(0)))); // George Orwell
        books.add(new Book("Brave New World", 1932, List.of(authors.get(1)))); // Aldous Huxley
    }

    /**
     * Finds an author by their name and surname.
     *
     * @param name    The first name of the author.
     * @param surname The last name of the author.
     * @return The Author object if found, otherwise null.
     */
    public Author findAuthorByName(String name, String surname) {
        for (Author author : authors) {
            System.out.println("Comparing with: " + author.getName() + " " + author.getSurname());
            if (author.getName().trim().equalsIgnoreCase(name.trim()) &&
                    author.getSurname().trim().equalsIgnoreCase(surname.trim())) {
                return author;  // Return the found author
            }
        }
        return null;  // If author is not found
    }

    /**
     * Retrieves a list of books written by a specific author.
     *
     * @param author The author whose books are to be retrieved.
     * @return A list of books written by the author.
     */
    public List<Book> getBooksByAuthor(Author author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthors().contains(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor; // Return the list of books by the author
    }

    /**
     * Retrieves all books available in the library.
     *
     * @return A list of all books.
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // Return a copy of the list of books
    }
}
