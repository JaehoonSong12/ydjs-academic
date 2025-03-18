<!-- 
 @requires
 1. VSCode extension: Markdown Preview Enhanced
 2. Shortcut: 'Ctrl' + 'Shift' + 'V'
 3. Split: Drag to right (->)

 @requires
 1. VSCode extension: Markdown All in One
 2. `File` > `Preferences` > `Keyboard Shortcuts`
 3. toggle code span > `Ctrl + '`
 4. toggle code block > `Ctrl + Shift + '`

 @usage
 1. End of Proof (Q.E.D.): <div style="text-align: right;">&#11035;</div>
 2. End of Each Section: 

     <br /><br /><br />

     ---



     <p align="right">(<a href="#readme-top">back to top</a>)</p>
     

 3. ![image_title_](images/imagefile.png)
 4. [url_title](URL)
 -->
<!-- Anchor Tag (Object) for "back to top" -->


# Java Programming Language System & JDK Structure

## 1. Setting Up Java
To start coding in Java, you need:
- **Java Development Kit (JDK)** – Download from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or use [OpenJDK](https://openjdk.org/).
- **An IDE or Text Editor** – Examples: IntelliJ IDEA, Eclipse, or VS Code.

---

## 2. JDK Structure
The **Java Development Kit (JDK)** provides the essential tools for developing Java applications. Here’s a breakdown of key components:

| Tool   | Purpose |
|--------|---------|
| `javac` (JAVA Compiler)  | Compiles `.java` files to `.class` (bytecode) |
| `java` (JAVA virtual machine)   | Runs `.class` files on the JVM |
| `javadoc` (JAVA DOCumentation) | Generates documentation from comments |
| `jar` (Java ARchive)    | Packages Java files into `.jar` |

### **`javac` (Java Compiler)**
**Purpose:** Converts `.java` source files into `.class` bytecode files.

#### **Usage Example:**
1. Write a Java program (`HelloWorld.java`):
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```
2. Open the terminal and compile:
   ```
   javac HelloWorld.java
   ```
3. This generates `HelloWorld.class`, which contains bytecode.

### **`java` (Java Virtual Machine)**
**Purpose:** Runs compiled Java programs (`.class` files).

#### **Usage Example:**
After compiling, run the program with:
```
java HelloWorld
```

### **`javadoc` (Java Documentation Generator)**
**Purpose:** Generates HTML documentation from comments in Java source code.

#### **Usage Example:**
Write a Java file with Javadoc comments (`Example.java`):
```java
/**
 * This class demonstrates Javadoc.
 */
public class Example {
    /**
     * Prints a greeting message.
     */
    public void greet() {
        System.out.println("Hello!");
    }
}
```
Generate documentation:
```
javadoc Example.java -d docs
```
This creates HTML docs inside the `docs/` folder.

### **`jar` (Java Archive Tool)**
**Purpose:** Packages Java classes into `.jar` files.

#### **Usage Example:**
```
jar cf MyApp.jar HelloWorld.class
```
This creates `MyApp.jar`, which you can run with:
```
java -jar MyApp.jar
```

---

## 3. Basic Java Program Structure
A simple Java program consists of a class and a `main` method.

#### Example:
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

---

## 4. Variables and Data Types
Java has different data types:
```java
public class DataTypesExample {
    public static void main(String[] args) {
        int age = 14;
        double price = 19.99;
        char letter = 'A';
        boolean isJavaFun = true;
        String name = "Dean";
        
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
        System.out.println("Letter: " + letter);
        System.out.println("Java is fun: " + isJavaFun);
    }
}
```

---

## 5. Control Statements (if, loops)
### If-Else Statement:
```java
public class IfElseExample {
    public static void main(String[] args) {
        int num = 10;
        
        if (num > 0) {
            System.out.println("Number is positive.");
        } else {
            System.out.println("Number is not positive.");
        }
    }
}
```

### Loops:
**For Loop**
```java
public class ForLoopExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
    }
}
```

**While Loop**
```java
public class WhileLoopExample {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println("Count: " + i);
            i++;
        }
    }
}
```

---

## 6. Functions (Methods)
```java
public class MethodExample {
    public static void main(String[] args) {
        greet();
    }

    static void greet() {
        System.out.println("Hello, welcome to Java!");
    }
}
```

---

## 7. Object-Oriented Programming (OOP)
### Class and Object Example:
```java
class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method
    void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
    }
}

public class OOPExample {
    public static void main(String[] args) {
        Person person1 = new Person("Dean", 16);
        person1.introduce();
    }
}
```

---

## 8. User Input
```java
import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.println("Hello, " + name + "!");
    }
}
```

---

## 9. Exception Handling
```java
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }
}
```

---

## 10. File Handling
**Write to a File:**
```java
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Hello, file handling in Java!");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
```

**Read from a File:**
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        try {
            File file = new File("output.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
```

