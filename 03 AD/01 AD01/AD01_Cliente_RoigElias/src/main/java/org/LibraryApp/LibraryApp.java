package org.LibraryApp;

import org.Controller.LibraryController;
import org.Model.Author;
import org.Model.Book;

import java.util.List;
import java.util.Scanner;

/**
 * LibraryApp is a console-based application that allows users to interact with a simulated library.
 * Users can view all available books or search for books by a specific author.
 *
 * Author: xesgan - Elias Roig
 */
public class LibraryApp {

    private LibraryController libraryController;

    /**
     * Constructor to initialize the LibraryApp and its controller.
     */
    public LibraryApp() {
        try {
            libraryController = new LibraryController();
        } catch (Exception e) {
            System.out.println("Error initializing the library: " + e.getMessage());
        }
    }

    /**
     * Starts the application, displaying the menu and handling user input.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            switch (option) {
                case 1:
                    showAllBooks();
                    break;
                case 2:
                    searchAuthor(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    /**
     * Displays the main menu to the user.
     */
    private void showMenu() {
        System.out.println("\n---- Library Menu ----");
        System.out.println("1. Show all books");
        System.out.println("2. Search books by author");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    /**
     * Displays all books available in the library.
     */
    private void showAllBooks() {
        List<Book> books = libraryController.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\n---- All Books ----");
            for (Book book : books) {
                System.out.println("\n" + book + "\n");
            }
        }
    }

    /**
     * Searches for books by a specified author.
     *
     * @param scanner Scanner object to read user input
     */
    private void searchAuthor(Scanner scanner) {
        System.out.print("\nEnter the author's first name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the author's last name: ");
        String surname = scanner.nextLine();
        System.out.println("\n");

        Author author = libraryController.findAuthorByName(name, surname);
        if (author != null) {
            List<Book> booksByAuthor = libraryController.getBooksByAuthor(author);
            if (booksByAuthor.isEmpty()) {
                System.out.println("No books found written by " + author);
            } else {
                System.out.println("\nBooks written by " + author + ":");
                for (Book book : booksByAuthor) {
                    System.out.println(book);
                }
            }
        } else {
            System.out.println("\nAuthor not found.");
        }
    }

    /**
     * The main method to run the LibraryApp.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.start();
    }
}
