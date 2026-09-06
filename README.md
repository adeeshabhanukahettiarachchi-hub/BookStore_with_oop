# 📚 Bookstore Management System – OOP Version

## 📌 Project Overview

The **Bookstore Management System** is a Java console-based application developed using **Object-Oriented Programming (OOP)** principles.

This project is the OOP version of the procedural bookstore system developed in Task 2. The main purpose of this version is to improve the **maintainability, readability, reusability, and scalability** of the application by organizing data and behaviour into separate classes.

Instead of using a large number of static variables and methods, the OOP version uses objects to represent real-world entities such as books, customers, and purchases.

---

## 🎯 Project Objectives

The main objectives of this project are:

* To implement Object-Oriented Programming concepts using Java.
* To represent bookstore entities using classes and objects.
* To separate data and behaviour into appropriate classes.
* To improve code organization and readability.
* To reduce dependency on static variables and methods.
* To make the system easier to maintain and extend.
* To demonstrate concepts such as encapsulation, constructors, objects, methods, and class relationships.

---

## ✨ Features

The system provides the following features:

* 📖 View available books
* 🛒 Purchase multiple books
* 👤 Enter customer information
* 🧾 Generate a purchase invoice
* ➕ Add new books to the inventory
* 💰 Calculate the total purchase amount
* 🔎 Validate book numbers
* 💵 Validate book prices
* ❌ Handle invalid user input
* 🚪 Exit the application safely
* 📦 Manage books using an inventory manager

---

## 🏗️ OOP Class Structure

The system is divided into five main classes.

| Class              | Responsibility                                                        |
| ------------------ | --------------------------------------------------------------------- |
| `Book`             | Stores book title, author, and price                                  |
| `Customer`         | Stores customer information                                           |
| `Purchase`         | Manages purchased books, calculates the total, and generates invoices |
| `BookstoreManager` | Manages the bookstore inventory                                       |
| `Main`             | Handles user input and controls the application flow                  |

### Class Relationship

```text
                    ┌─────────────────────┐
                    │        Main         │
                    │                     │
                    │ User interaction    │
                    │ Program flow        │
                    └──────────┬──────────┘
                               │
                ┌──────────────┴──────────────┐
                │                             │
                ▼                             ▼
      ┌──────────────────┐          ┌──────────────────┐
      │ BookstoreManager │          │     Purchase     │
      │                  │          │                  │
      │ Manage inventory │          │ Manage purchase  │
      └────────┬─────────┘          └────────┬─────────┘
               │                             │
               ▼                             ▼
        ┌──────────────┐              ┌──────────────┐
        │     Book     │              │   Customer   │
        │              │              │              │
        │ Title        │              │ Customer     │
        │ Author       │              │ Name         │
        │ Price        │              └──────────────┘
        └──────────────┘
```

---

# 📖 Class Descriptions

## 1. Book Class

The `Book` class represents a single book in the bookstore.

It contains three private attributes:

* `title`
* `author`
* `price`

The constructor initializes these values when a new `Book` object is created.

### Main Methods

| Method             | Purpose                            |
| ------------------ | ---------------------------------- |
| `Book()`           | Creates a new book object          |
| `getTitle()`       | Returns the book title             |
| `getAuthor()`      | Returns the author name            |
| `getPrice()`       | Returns the book price             |
| `displayDetails()` | Displays book information          |
| `toString()`       | Returns formatted book information |

The attributes are declared as `private`, which demonstrates **encapsulation**.

---

## 2. BookstoreManager Class

The `BookstoreManager` class is responsible for managing the bookstore inventory.

It uses:

```java
private List<Book> inventory;
```

This allows multiple `Book` objects to be stored in the bookstore.

### Main Methods

| Method               | Purpose                           |
| -------------------- | --------------------------------- |
| `addBook()`          | Adds a book to the inventory      |
| `displayBooks()`     | Displays all available books      |
| `getBook()`          | Finds a book using its number     |
| `getBookCount()`     | Returns the number of books       |
| `isInventoryEmpty()` | Checks whether inventory is empty |
| `getInventory()`     | Returns a copy of the inventory   |

This class separates inventory management from the rest of the application.

---

## 3. Customer Class

The `Customer` class represents the customer making a purchase.

Currently, the class stores the customer's name.

```java
private String name;
```

The customer name is initialized using the constructor.

### Main Methods

| Method              | Purpose                       |
| ------------------- | ----------------------------- |
| `Customer()`        | Creates a customer object     |
| `getName()`         | Returns the customer's name   |
| `displayCustomer()` | Displays customer information |

For example:

```java
Customer customer = new Customer("John");
```

This creates a `Customer` object containing the customer's name.

---

## 4. Purchase Class

The `Purchase` class represents a purchase transaction.

It contains:

```java
private Customer customer;
private List<Book> purchasedBooks;
```

Therefore, a purchase is associated with a customer and a collection of books.

### Main Methods

| Method                | Purpose                                |
| --------------------- | -------------------------------------- |
| `Purchase()`          | Creates a purchase for a customer      |
| `addBook()`           | Adds a book to the purchase            |
| `calculateTotal()`    | Calculates the total price             |
| `isEmpty()`           | Checks whether any books were selected |
| `getPurchasedBooks()` | Returns purchased books                |
| `getCustomer()`       | Returns the customer                   |
| `generateInvoice()`   | Generates the final invoice            |

The `calculateTotal()` method loops through the purchased books and adds their prices together.

---

## 5. Main Class

The `Main` class is responsible for controlling the overall application.

It handles:

* User input
* Main menu
* Book purchasing
* Adding new books
* Input validation
* Application termination

The class creates objects of other classes instead of storing all bookstore data directly.

For example:

```java
BookstoreManager bookstore = new BookstoreManager();
```

A new book can then be added using:

```java
bookstore.addBook(
    new Book("Clean Code", "Robert C. Martin", 4500.00)
);
```

This demonstrates how objects work together in the OOP implementation.

---

# 🔐 Encapsulation

Encapsulation is an important OOP principle used in this project.

For example, the `Book` class uses private variables:

```java
private String title;
private String author;
private double price;
```

These variables cannot be accessed directly from outside the class.

Instead, getter methods are provided:

```java
public String getTitle()
public String getAuthor()
public double getPrice()
```

This provides controlled access to the object's data.

---

# 🧱 Constructors

Constructors are used to initialize objects when they are created.

For example:

```java
Book book = new Book(
    "Clean Code",
    "Robert C. Martin",
    4500.00
);
```

The constructor receives the title, author, and price and stores them inside the object.

Similarly, a customer can be created using:

```java
Customer customer = new Customer("John");
```

---

# 📦 ArrayList and List

The project uses Java's `List` interface and `ArrayList` implementation.

For example:

```java
private List<Book> inventory;
```

and:

```java
inventory = new ArrayList<>();
```

The bookstore can therefore store multiple `Book` objects dynamically.

The purchase class also uses:

```java
private List<Book> purchasedBooks;
```

This makes it possible for a customer to purchase multiple books during one transaction.

---

# 🛒 Purchase Process

The purchasing process works as follows:

```text
Start
  │
  ▼
Enter Customer Name
  │
  ▼
Create Customer Object
  │
  ▼
Create Purchase Object
  │
  ▼
Display Available Books
  │
  ▼
Select Book Number
  │
  ├── Invalid ──► Display Error
  │                   │
  │                   └──► Select Again
  │
  ▼
Add Book to Purchase
  │
  ▼
Select Another Book?
  │
  ├── Yes ─────► Display Books Again
  │
  └── No
        │
        ▼
Calculate Total
        │
        ▼
Generate Invoice
        │
        ▼
       End
```

---

# 📚 Sample Book Inventory

The application starts with the following sample books:

| No. | Book                         | Author           |        Price |
| --: | ---------------------------- | ---------------- | -----------: |
|   1 | Clean Code                   | Robert C. Martin | Rs. 4,500.00 |
|   2 | Effective Java               | Joshua Bloch     | Rs. 5,200.00 |
|   3 | Head First Java              | Kathy Sierra     | Rs. 3,900.00 |
|   4 | Java: The Complete Reference | Herbert Schildt  | Rs. 5,800.00 |
|   5 | Design Patterns              | Erich Gamma      | Rs. 6,100.00 |

---

# 🧾 Example Invoice

When a customer completes a purchase, the system generates an invoice similar to:

```text
==============================================
              BOOKSTORE INVOICE
==============================================
Customer: John
----------------------------------------------
No.   Book                              Price
----------------------------------------------
1     Clean Code                    Rs.4500.00
2     Effective Java                Rs.5200.00
----------------------------------------------
Total Bill:                         Rs.9700.00
==============================================
       Thank you for your purchase!
==============================================
```

---

# ⚖️ Task 2 vs Task 3

The main difference between the two implementations is how the program organizes data and behaviour.

| Task 2 – Procedural                   | Task 3 – OOP                     |
| ------------------------------------- | -------------------------------- |
| Uses static variables                 | Uses objects                     |
| Uses static methods                   | Uses instance methods            |
| Book data stored separately           | Book represented as an object    |
| Less separation of responsibilities   | Clear class responsibilities     |
| More difficult to extend              | Easier to extend                 |
| Data and behaviour are less connected | Data and behaviour are grouped   |
| Suitable for a small simple program   | More suitable for larger systems |

The OOP version is therefore more structured and provides a better foundation for future development.

---

# 🧠 OOP Concepts Demonstrated

This project demonstrates several important OOP concepts.

### 1. Encapsulation

Data is kept private inside classes and accessed through methods.

### 2. Classes and Objects

Real-world entities such as books, customers, and purchases are represented using classes and objects.

### 3. Constructors

Constructors initialize objects when they are created.

### 4. Abstraction

Each class provides specific functionality without requiring the rest of the program to know all implementation details.

### 5. Composition / Object Relationships

A `Purchase` contains a `Customer` object and multiple `Book` objects.

The `BookstoreManager` manages a collection of `Book` objects.

---

# 🛠️ Technologies Used

* ☕ **Java**
* 📦 **Java Collections Framework**
* 🧱 **Object-Oriented Programming**
* 💻 **Console Application**
* 🗂️ **ArrayList / List**
* 🔄 **Loops and Conditional Statements**
* ⌨️ **Scanner for User Input**

---

# 📂 Project Structure

```text
BookStore_OOP/
│
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Book.java
│                   ├── BookstoreManager.java
│                   ├── Customer.java
│                   ├── Purchase.java
│                   └── Main.java
│
└── README.md
```

---

# ▶️ How to Run

## 1. Clone the Repository

```bash
git clone https://github.com/your-username/your-repository-name.git
```

## 2. Open the Project

Open the project using an IDE such as:

* IntelliJ IDEA
* Eclipse
* Visual Studio Code

## 3. Run the Main Class

Open:

```text
Main.java
```

and run the `main()` method.

---

# 💻 Example Program Flow

```text
=======================================
     BOOKSTORE MANAGEMENT SYSTEM
=======================================

----------- MAIN MENU -----------
1. View Available Books
2. Purchase Books
3. Add New Book
4. Exit
---------------------------------

Enter your choice:
```

The user can select an option and interact with the bookstore through the console.

---

# 🔎 Input Validation

The application includes basic input validation.

For integer values, the program uses exception handling:

```java
try {
    int value = Integer.parseInt(scanner.nextLine());
    return value;
} catch (NumberFormatException e) {
    System.out.println(
        "Invalid input. Please enter a whole number."
    );
}
```

This prevents the program from terminating when the user enters invalid numeric data.

Book prices are also checked to make sure that they are greater than zero.

---

# 🚀 Possible Future Improvements

The current application can be extended with additional functionality such as:

* 📦 Book stock quantities
* 🔐 User authentication
* 👨‍💼 Admin login
* 🗄️ Database integration
* 🔍 Book searching
* ✏️ Update and delete books
* 🏷️ Book categories
* 💳 Payment processing
* 🧾 Saving invoices
* 📊 Sales reports
* 📅 Purchase history
* 🌐 Web-based interface

These improvements would demonstrate how the OOP structure can be extended as the requirements of the bookstore become more complex.

---

# 🎓 Academic Purpose

This project was developed as part of an academic task to demonstrate the difference between **Procedural Programming** and **Object-Oriented Programming** using Java.

The Task 3 implementation refactors the procedural solution from Task 2 into a class-based design. By separating responsibilities into different classes, the system becomes easier to understand, maintain, modify, and extend.

---

# 👨‍💻 Author

**Adeesha Bhanuka**

GitHub: `adeeshabhanukahettiarachchi-hub`

---

## 📄 License

This project was developed for **educational and academic purposes**.

---

⭐ **Bookstore Management System – Java Object-Oriented Programming**
