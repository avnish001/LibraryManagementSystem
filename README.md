# Library Management System

A Java-based Library Management System that allows librarians to manage books, patrons, and lending processes efficiently.

## Features

- **Book Management**: Add, remove, update, and search books
- **Patron Management**: Add and update patron information, track borrowing history
- **Lending Process**: Checkout and return books with validation
- **Inventory Management**: Track available and borrowed books
- **Search Functionality**: Find books by title, author, or ISBN

## Technologies Used

- Java 11+
- Maven (for dependency management)
- Object-Oriented Programming principles


## How to Run

### Using Maven:
1. Clone the repository
2. Navigate to the project directory
3. Compile: `mvn compile`
4. Run: `mvn exec:java -Dexec.mainClass="com.library.Main"`

### Using Java directly:
1. Compile: `javac -d target/classes src/main/java/com/library/*.java`
2. Run: `java -cp target/classes com.library.Main`

## Class Diagram

![Class Diagram](E:\Prg Files\LibraryManagementSystem\class-diagram.png)

The system follows a simple object-oriented design with three main classes:
- `Book`: Represents a book with properties like title, author, ISBN, etc.
- `Patron`: Represents a library member with borrowing history
- `Library`: Manages all operations including book and patron management

## Usage Examples

```java
// Create library instance
Library library = new Library();

// Add books
Book book = new Book("Title", "Author", "ISBN", 2023);
library.addBook(book);

// Add patrons
Patron patron = new Patron("ID", "Name", "email@example.com", "555-1234");
library.addPatron(patron);

// Checkout a book
library.checkoutBook(book, patron);

// Search for books
List<Book> results = library.searchBooksByTitle("Gatsby");