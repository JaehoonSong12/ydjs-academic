// Main.java
public class Main2 {
    public static void main(String[] args) {
        // Create an instance of the Person class
        Person person = new Person("John Doe", 30);

        // Access public methods
        System.out.println("Name (via public method): " + person.name);
        System.out.println("Name (via public method): " + person.getName());
        System.out.println("Age (via public method): " + person.getAge());

        // Attempt to access private fields or methods will cause a compilation error
        // person.name; // This will cause an error
        // person.age;  // This will cause an error
        // person.displayPrivateInfo(); // This will also cause an error

        // Accessing public method that uses a private method internally
        person.displayPublicInfo();
    }
}
