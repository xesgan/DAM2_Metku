package org.Model;

/**
 * Represents an author with a name and surname.
 * This class provides methods to access the author's information
 * and validates that the provided name and surname are not null or empty.
 *
 * Author: xesgan - Elias Roig
 */
public class Author {
    private String name;
    private String surname;

    /**
     * Constructor for creating an Author object.
     *
     * @param name    The first name of the author.
     * @param surname The last name of the author.
     * @throws LibraryException If the name or surname is null, empty, or whitespace.
     */
    public Author(String name, String surname) throws LibraryException {
        if (isNullOrEmpty(name) || isNullOrEmpty(surname)) { // Check for null, empty, or whitespace
            throw new LibraryException("Name and surname cannot be null, empty, or whitespace.");
        }
        this.name = name;
        this.surname = surname;
    }

    /**
     * Gets the author's first name.
     *
     * @return The author's first name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the author's last name.
     *
     * @return The author's last name.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Utility method to check for null, empty, or whitespace strings.
     *
     * @param value The string to check.
     * @return True if the string is null, empty, or whitespace; false otherwise.
     */
    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty(); // Also check for whitespace-only strings
    }

    /**
     * Returns a string representation of the Author object,
     * displaying the author's full name.
     *
     * @return A string containing the author's full name.
     */
    @Override
    public String toString() {
        return name + " " + surname;
    }
}
