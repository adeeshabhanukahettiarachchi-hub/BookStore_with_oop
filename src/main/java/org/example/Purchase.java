package org.example;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private Customer customer;
    private List<Book> purchasedBooks;

    // Constructor
    public Purchase(Customer customer) {
        this.customer = customer;
        this.purchasedBooks = new ArrayList<>();
    }

    // Add a book to the purchase
    public void addBook(Book book) {
        purchasedBooks.add(book);
    }

    // Calculate total price
    public double calculateTotal() {
        double total = 0;
        for (Book book : purchasedBooks) {
            total += book.getPrice();
        }
        return total;
    }

    // Check whether purchase is empty
    public boolean isEmpty() {
        return purchasedBooks.isEmpty();
    }

    // Get purchased books
    public List<Book> getPurchasedBooks() {
        return new ArrayList<>(purchasedBooks);
    }

    // Get customer
    public Customer getCustomer() {
        return customer;
    }

    // Generate invoice
    public void generateInvoice() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("              BOOKSTORE INVOICE");
        System.out.println("==============================================");

        System.out.println("Customer: " + customer.getName());

        System.out.println("----------------------------------------------");

        System.out.printf(
                "%-5s %-28s %10s%n",
                "No.",
                "Book",
                "Price"
        );
        System.out.println("----------------------------------------------");
        for (int i = 0; i < purchasedBooks.size(); i++) {
            Book book = purchasedBooks.get(i);
            System.out.printf(
                    "%-5d %-28s Rs.%8.2f%n",
                    i + 1,
                    book.getTitle(),
                    book.getPrice()
            );
        }
        System.out.println("----------------------------------------------");
        System.out.printf(
                "Total Bill:                         Rs. %.2f%n",
                calculateTotal()
        );
        System.out.println("==============================================");
        System.out.println("       Thank you for your purchase!");
        System.out.println("==============================================");
    }
}