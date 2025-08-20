package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Book management methods
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }

    public void updateBook(Book book, String title, String author, int publicationYear) {
        // In a real implementation, we would have setters in the Book class
        // For simplicity, we'll create a new book and replace the old one
        Book updatedBook = new Book(title, author, book.getIsbn(), publicationYear);
        updatedBook.setAvailable(book.isAvailable());

        int index = books.indexOf(book);
        if (index != -1) {
            books.set(index, updatedBook);
            System.out.println("Updated book: " + book.getTitle());
        }
    }

    // Search functionality
    public List<Book> searchBooksByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public Book searchBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Patron management methods
    public void addPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Added patron: " + patron.getName());
    }

    public void updatePatron(Patron patron, String name, String email, String phoneNumber) {
        patron.setName(name);
        patron.setEmail(email);
        patron.setPhoneNumber(phoneNumber);
        System.out.println("Updated patron: " + patron.getName());
    }

    // Lending process methods
    public boolean checkoutBook(Book book, Patron patron) {
        if (!book.isAvailable()) {
            System.out.println("Book is not available for checkout: " + book.getTitle());
            return false;
        }

        if (patron.getCurrentlyBorrowed().size() >= 5) { // Limit of 5 books per patron
            System.out.println("Patron has reached the maximum number of borrowed books: " + patron.getName());
            return false;
        }

        // Update book status
        book.setAvailable(false);

        // Update patron's records
        patron.addToBorrowingHistory(book);
        patron.addToCurrentlyBorrowed(book);

        System.out.println("Book checked out: " + book.getTitle() + " to " + patron.getName());
        return true;
    }

    public boolean returnBook(Book book, Patron patron) {
        if (!patron.getCurrentlyBorrowed().contains(book)) {
            System.out.println("This patron didn't borrow this book: " + book.getTitle());
            return false;
        }

        // Update book status
        book.setAvailable(true);

        // Update patron's records
        patron.removeFromCurrentlyBorrowed(book);

        System.out.println("Book returned: " + book.getTitle() + " by " + patron.getName());
        return true;
    }

    // Inventory management methods
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Book> getBorrowedBooks() {
        List<Book> borrowedBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isAvailable()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    // Getters for collections
    public List<Book> getBooks() { return new ArrayList<>(books); }
    public List<Patron> getPatrons() { return new ArrayList<>(patrons); }
}