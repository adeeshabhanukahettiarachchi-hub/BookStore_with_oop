package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookstoreManager bookstore = new BookstoreManager();

    public static void main(String[] args) {
        // Add sample books
        addSampleBooks();
        System.out.println("=======================================");
        System.out.println("     BOOKSTORE MANAGEMENT SYSTEM");
        System.out.println("=======================================");
        boolean running = true;


        while (running) {
            displayMenu();
            int choice = readInteger("Enter your choice: ");
            switch (choice) {
                case 1:
                    bookstore.displayBooks();
                    break;
                case 2:
                    makePurchase();
                    break;
                case 3:
                    addNewBook();
                    break;
                case 4:
                    running = false;
                    System.out.println();
                    System.out.println("Thank you for using the Bookstore Management System.");
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 4.");
            }
        }

        scanner.close();
    }

    // Add sample books
    private static void addSampleBooks() {
        bookstore.addBook(
                new Book(
                        "Clean Code",
                        "Robert C. Martin",
                        4500.00
                )
        );
        bookstore.addBook(
                new Book(
                        "Effective Java",
                        "Joshua Bloch",
                        5200.00
                )
        );
        bookstore.addBook(
                new Book(
                        "Head First Java",
                        "Kathy Sierra",
                        3900.00
                )
        );
        bookstore.addBook(
                new Book(
                        "Java: The Complete Reference",
                        "Herbert Schildt",
                        5800.00
                )
        );
        bookstore.addBook(
                new Book(
                        "Design Patterns",
                        "Erich Gamma",
                        6100.00
                )
        );
    }

    // Display menu
    private static void displayMenu() {
        System.out.println();
        System.out.println("----------- MAIN MENU -----------");
        System.out.println("1. View Available Books");
        System.out.println("2. Purchase Books");
        System.out.println("3. Add New Book");
        System.out.println("4. Exit");
        System.out.println("---------------------------------");
    }

    // Purchase books
    private static void makePurchase() {
        if (bookstore.isInventoryEmpty()) {
            System.out.println("No books are available.");
            return;
        }

        System.out.println();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        // Create Customer object
        Customer customer = new Customer(customerName);

        // Create Purchase object
        Purchase purchase = new Purchase(customer);

        boolean selectingBooks = true;

        while (selectingBooks) {
            bookstore.displayBooks();
            System.out.println();
            System.out.println("Enter the book number to purchase.");
            System.out.println("Enter 0 when you have finished selecting books.");
            int bookNumber = readInteger("Book number: ");
            if (bookNumber == 0) {
                selectingBooks = false;
                continue;
            }

            // Find selected book
            Book selectedBook = bookstore.getBook(bookNumber);
            if (selectedBook != null) {
                purchase.addBook(selectedBook);
                System.out.println("\"" + selectedBook.getTitle() + "\" added to your purchase.");
            } else {
                System.out.println(
                        "Invalid book number. Please try again."
                );
            }
        }

        // Generate invoice
        if (purchase.isEmpty()) {
            System.out.println(
                    "No books were selected. Purchase cancelled."
            );
        } else {
            purchase.generateInvoice();
        }
    }

    // Add a new book
    private static void addNewBook() {
        System.out.println();
        System.out.println("----------- ADD NEW BOOK -----------");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");

        String author = scanner.nextLine();
        double price = readDouble("Enter book price: Rs. ");

        if (price <= 0) {
            System.out.println("Book price must be greater than zero.");
            return;
        }

        Book newBook = new Book(title, author, price);
        bookstore.addBook(newBook);
        System.out.println("Book added successfully.");
    }

    // Read integer input
    private static int readInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    // Read double input
    private static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine());
                return value;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price.");
            }
        }
    }
}