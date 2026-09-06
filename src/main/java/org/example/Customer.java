package org.example;

public class Customer {

    private String name;

    // Constructor
    public Customer(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Display customer details
    public void displayCustomer() {
        System.out.println("Customer Name: " + name);
    }
}