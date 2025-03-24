# The Factory Design Pattern in Software Development

## 1. Why Use the Factory Pattern?
- **Encapsulation of Object Creation:** Keeps the creation logic in one place, reducing code duplication.  
- **Decoupling:** Clients (users of the objects) don’t need to know which class to instantiate.  
- **Flexibility & Maintainability:** Adding new types doesn’t require changing existing code.  
- **Better Code Organization:** Keeps object creation separate from business logic.  

---

## 2. Example Scenario: Creating Different Shapes
Imagine a drawing application where we need different shapes (`Circle`, `Rectangle`, `Square`). Instead of manually instantiating these shapes, we use a **Factory** to create them dynamically.

---

## 3. Implementation of Factory Pattern

### Step 1: Define the Interface

```java
interface Shape {
    void draw();
}
```

This ensures all shapes implement a common method, `draw()`.

---

### Step 2: Create Concrete Classes

Each shape implements the `Shape` interface.

```java
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}
```

---

### Step 3: Create the Factory Class

The factory class decides which object to return based on input.

```java
class ShapeFactory {
    // Factory Method
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
```

---

### Step 4: Use the Factory to Get Objects

```java
public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        // Get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}
```

---

## 4. Explanation

1. **Encapsulation of Object Creation:**  
   - Instead of using `new Circle()`, `new Rectangle()`, etc., we call `shapeFactory.getShape("CIRCLE")`.  
   - The **Factory class** takes care of instantiation.

2. **Flexibility:**  
   - If we need a new shape (e.g., `Triangle`), we simply add it to the factory without modifying the client code.

3. **Decoupling:**  
   - The client (`FactoryPatternExample`) doesn’t need to know the concrete classes (`Circle`, `Rectangle`, `Square`).  

---

## 5. Real-World Use Cases

- **Database Connections:** Factory can create `MySQLConnection` or `PostgreSQLConnection` dynamically.  
- **Logging Frameworks:** A factory can decide between `FileLogger` and `ConsoleLogger`.  
- **Payment Systems:** Choosing between `CreditCardPayment` or `PayPalPayment`.  

---

## 6. Factory Pattern vs Supplier Pattern

| Feature | **Factory Pattern** | **Supplier Pattern** |
|---------|----------------|---------------|
| **Implementation Style** | Class-based (OO Design) | Functional (`Supplier<T>` as Lambda/Method Reference) |
| **Object Creation Timing** | Eager or controlled by logic | Lazy, when `get()` is called |
| **Flexibility** | Handles multiple object types | Best for single-object suppliers |
| **Use Case** | Complex object creation with logic | Simple, lightweight object providers |

---

## 7. Conclusion

- The **Factory Pattern** simplifies object creation by centralizing instantiation logic.  
- It **improves maintainability** and **enhances flexibility**.  
- It is **widely used** in **real-world applications** like logging, database connections, and UI elements.  

