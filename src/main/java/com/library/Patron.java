package com.library;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Book> borrowingHistory;
    private List<Book> currentlyBorrowed;

    public Patron(String id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowingHistory = new ArrayList<>();
        this.currentlyBorrowed = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public List<Book> getBorrowingHistory() { return new ArrayList<>(borrowingHistory); }
    public List<Book> getCurrentlyBorrowed() { return new ArrayList<>(currentlyBorrowed); }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void addToBorrowingHistory(Book book) {
        borrowingHistory.add(book);
    }

    public void addToCurrentlyBorrowed(Book book) {
        currentlyBorrowed.add(book);
    }

    public void removeFromCurrentlyBorrowed(Book book) {
        currentlyBorrowed.remove(book);
    }

    @Override
    public String toString() {
        return name + " (" + id + ") - Email: " + email + " - Phone: " + phoneNumber +
                " - Books borrowed: " + currentlyBorrowed.size();
    }
}