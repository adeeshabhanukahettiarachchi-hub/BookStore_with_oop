package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookstoreManager {
    private List<Book> inventory;

    // Constructor
    public BookstoreManager() {
        inventory = new ArrayList<>();
    }

    // Add a book to inventory
    public void addBook(Book book) {
        inventory.add(book);
    }

    // Display all available books
    public void displayBooks() {
        if (inventory.isEmpty()) {
            System.out.println("No books are currently available.");
            return;
        }

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                    AVAILABLE BOOKS");
        System.out.println("==============================================================");
        System.out.printf(
                "%-5s %-30s %-25s %10s%n",
                "No.",
                "Title",
                "Author",
                "Price"
        );
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < inventory.size(); i++) {
            Book book = inventory.get(i);
            System.out.printf(
                    "%-5d %-30s %-25s Rs.%8.2f%n",
                    i + 1,
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPrice()
            );
        }
        System.out.println("==============================================================");
    }

    // Get a book using its number
    public Book getBook(int bookNumber) {
        int index = bookNumber - 1;
        if (index >= 0 && index < inventory.size()) {
            return inventory.get(index);
        }
        return null;
    }

    // Get number of books
    public int getBookCount() {
        return inventory.size();
    }

    // Check inventory
    public boolean isInventoryEmpty() {
        return inventory.isEmpty();
    }

    // Get inventory
    public List<Book> getInventory() {
        return new ArrayList<>(inventory);
    }
}