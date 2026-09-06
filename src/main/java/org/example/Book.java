package org.example;

public class Book {
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }

    // Display book details
    public void displayDetails() {
        System.out.printf(
                "%-30s %-25s Rs. %.2f%n",
                title,
                author,
                price
        );
    }
    @Override
    public String toString() {
        return title + " - " + author +
                " - Rs. " + String.format("%.2f", price);
    }
}