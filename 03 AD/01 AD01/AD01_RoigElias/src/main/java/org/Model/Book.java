package org.Model;

import java.util.List;

/**
 * Represents a book with a title, publication year, and a list of authors.
 * This class validates the provided data upon instantiation and
 * provides methods to access the book's information.
 *
 * Author: xesgan - Elias Roig
 */
public class Book {
    private String title;
    private int publicationYear;
    private List<Author> authors;

    /**
     * Constructor for creating a Book object.
     *
     * @param title            The title of the book.
     * @param publicationYear  The year the book was published.
     * @param authors          The list of authors who wrote the book.
     * @throws LibraryException If the title is empty, the publication year is negative,
     *                          or the authors list is empty.
     */
    public Book(String title, int publicationYear, List<Author> authors) throws LibraryException {
        if (isNullOrEmpty(title)) { // Check for null or empty title
            throw new LibraryException("Book title cannot be empty");
        }

        if (publicationYear < 0) { // Check for negative publication year
            throw new LibraryException("Publication year cannot be negative");
        }

        if (authors == null || authors.isEmpty()) { // Check for empty authors list
            throw new LibraryException("Author list cannot be empty");
        }

        this.title = title;
        this.publicationYear = publicationYear;
        this.authors = authors;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the publication year of the book.
     *
     * @return The publication year of the book.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Gets the list of authors who wrote the book.
     *
     * @return The list of authors.
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Returns a string representation of the Book object,
     * displaying the book's title, publication year, and authors.
     *
     * @return A string containing structured information about the book.
     */
    @Override
    public String toString() {
        // StringBuilder to construct the authors list
        StringBuilder authorsString = new StringBuilder();
        for (Author author : authors) {
            authorsString.append(author.toString()).append(", ");
        }
        // Remove the last comma and space
        if (authorsString.length() > 0) {
            authorsString.setLength(authorsString.length() - 2);
        }

        // Return a clearer string with structured information
        return "Title: " + title + "\n" +
                "Publication Year: " + publicationYear + "\n" +
                "Authors: " + authorsString;
    }

    /**
     * Utility method to check for null or empty strings.
     *
     * @param value The string to check.
     * @return True if the string is null or empty; false otherwise.
     */
    private boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
