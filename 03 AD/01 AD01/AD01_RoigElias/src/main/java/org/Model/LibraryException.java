package org.Model;

/**
 * Custom exception class to handle library-related errors.
 * This class extends the Exception class to provide specific error messages
 * related to library operations.
 *
 * Author: xesgan - Elias Roig
 */
public class LibraryException extends Exception {

    /**
     * Constructor for creating a LibraryException with a specific error message.
     *
     * @param message The error message associated with the exception.
     */
    public LibraryException(String message) {
        super(message); // Call the parent class constructor with the error message
    }
}
