// Person.java
public class Person {
    // Private fields
    public String name;
    private int age;

    // String sample;
    // protected String sample2;

    // Constructor (public so it can be accessed from outside)
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public method to access private field 'name'
    public String getName() {
        return name;
    }

    // Public method to access private field 'age'
    public int getAge() {
        return age;
    }

    // Private method, cannot be accessed outside this class
    private void displayPrivateInfo() {
        System.out.println("This is private information.");
    }

    // Public method that can be accessed from outside
    public void displayPublicInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
        displayPrivateInfo(); // Private method can be accessed within this class
    }
}
