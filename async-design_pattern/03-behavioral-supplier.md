# The Supplier Design Pattern in Software Development

The **Supplier Design Pattern** is a **functional design pattern** commonly used in software development, particularly in Java and other object-oriented languages. It falls under the category of **behavioral patterns** and is closely related to the *Factory Pattern*, but with a functional programming twist.



## 1. Understanding the Supplier Pattern
The **Supplier Design Pattern** is used to **encapsulate object creation logic** inside a **function**, rather than creating objects directly using the `new` keyword everywhere.  

This is particularly useful in:  
- **Lazy initialization:** Objects are created **only when needed**.  
- **Dependency Injection:** You can supply different implementations dynamically.  
- **Decoupling object creation from usage**, making the code **more flexible and testable**.  

---

## 2. Example Scenario: Creating Database Connections
### Scenario
Suppose we have a **DatabaseConnection** class that represents a connection to a database. Instead of creating the connection manually using `new DatabaseConnection()`, we can use a **Supplier** to encapsulate the creation logic.

---

## 3. Code Implementation
### Step 1: Create the DatabaseConnection Class

```java
class DatabaseConnection {
    private String dbUrl;

    public DatabaseConnection(String dbUrl) {
        this.dbUrl = dbUrl;
        System.out.println("Database connection created for: " + dbUrl);
    }

    public void connect() {
        System.out.println("Connecting to " + dbUrl);
    }
}
```

---

### Step 2: Use `Supplier` to Encapsulate Object Creation

```java
import java.util.function.Supplier;

public class SupplierPatternExample {
    public static void main(String[] args) {
        // Supplier encapsulating the object creation logic
        Supplier<DatabaseConnection> dbSupplier = () -> new DatabaseConnection("jdbc:mysql://localhost:3306/mydb");

        // The connection is NOT created yet
        System.out.println("Before calling get() on Supplier");

        // Now, when we call get(), the object is created
        DatabaseConnection connection = dbSupplier.get();
        connection.connect();
    }
}
```

---

## 4. Explanation
1. **Encapsulation of Object Creation:**  
   - We define `Supplier<DatabaseConnection> dbSupplier`, which is a function that **returns a new `DatabaseConnection` when called**.
   - This avoids manually using `new DatabaseConnection(...)` everywhere.

2. **Lazy Initialization:**  
   - Notice **"Before calling get() on Supplier"** is printed **before** the connection is created.  
   - The connection is **only created when we call `dbSupplier.get()`**.  

3. **Flexibility & Decoupling:**  
   - If we later decide to use **a different database**, we only change the **Supplier implementation** rather than modifying multiple parts of the code.  

---

## 5. Real-World Use Cases
The **Supplier Pattern** is commonly used in:
- **Lazy Initialization:** Delay object creation until actually needed.  
- **Dependency Injection:** Supply different implementations dynamically.  
- **Caching:** Generate values only when required, e.g., retrieving a cached item.  
- **Factory Methods in Functional Programming:** Replace traditional factory patterns with functions.  

---

## 6. Extending the Example: Dynamic Database Selection

```java
import java.util.function.Supplier;

public class DynamicSupplierExample {
    public static void main(String[] args) {
        // Creating a dynamic supplier
        Supplier<DatabaseConnection> mysqlSupplier = () -> new DatabaseConnection("jdbc:mysql://localhost:3306/mysql_db");
        Supplier<DatabaseConnection> postgresSupplier = () -> new DatabaseConnection("jdbc:postgresql://localhost:5432/postgres_db");

        // Dynamically choose which database to connect to
        DatabaseConnection connection;
        boolean useMySQL = true; // This could be based on config

        connection = useMySQL ? mysqlSupplier.get() : postgresSupplier.get();
        connection.connect();
    }
}
```

🔹 **Benefit:** Easily switch database connections without modifying object creation logic everywhere.  

---

## 7. Comparison with Factory Pattern

| Feature | **Supplier Pattern** | **Factory Pattern** |
|---------|----------------|---------------|
| **Implementation Style** | Functional (`Supplier<T>` as Lambda/Method Reference) | Traditional Object-Oriented (Factory Class) |
| **Object Creation Timing** | **Lazy**, when `get()` is called | Often **eager** unless explicitly lazy |
| **Flexibility** | Can dynamically change the Supplier at runtime | More rigid, usually hardcoded |
| **Use Case** | Simple object providers (e.g., configurations, database connections) | More complex object creation requiring logic |

---

## 8. Conclusion
- **Encapsulates object creation logic** in a function (`Supplier<T>`) rather than using `new`.  
- **Improves flexibility and testability** by decoupling instantiation from usage.  
- **Enables lazy initialization**, reducing unnecessary resource consumption.  
- **Enhances dependency injection** by allowing different suppliers for different implementations.  

---

### Would you like more examples or further clarifications? 🚀
