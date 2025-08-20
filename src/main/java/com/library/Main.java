package com.library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "0987654321", 1960);
        Book book3 = new Book("1984", "George Orwell", "1122334455", 1949);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Add patrons
        Patron patron1 = new Patron("P001", "John Doe", "john@example.com", "555-1234");
        Patron patron2 = new Patron("P002", "Jane Smith", "jane@example.com", "555-5678");

        library.addPatron(patron1);
        library.addPatron(patron2);

        // Checkout books
        library.checkoutBook(book1, patron1);
        library.checkoutBook(book3, patron2);

        // Display available and borrowed books
        System.out.println("\nAvailable books:");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println("  " + book);
        }

        System.out.println("\nBorrowed books:");
        List<Book> borrowedBooks = library.getBorrowedBooks();
        for (Book book : borrowedBooks) {
            System.out.println("  " + book);
        }

        // Return a book
        library.returnBook(book1, patron1);

        // Search for books
        System.out.println("\nSearch results for 'Gatsby':");
        List<Book> searchResults = library.searchBooksByTitle("Gatsby");
        for (Book book : searchResults) {
            System.out.println("  " + book);
        }

        // Update patron information
        library.updatePatron(patron1, "John Doe Jr.", "johnjr@example.com", "555-4321");

        // Display patron borrowing history
        System.out.println("\n" + patron1.getName() + "'s borrowing history:");
        List<Book> borrowingHistory = patron1.getBorrowingHistory();
        for (Book book : borrowingHistory) {
            System.out.println("  " + book);
        }

        System.out.println("\nLibrary Management System completed successfully!");
    }
}