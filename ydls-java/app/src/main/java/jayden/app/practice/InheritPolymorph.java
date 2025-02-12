package jayden.app.practice;








public class InheritPolymorph {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.makeSound();  // Output: Some generic animal sound

        Animal myDog = new Dog();
        myDog.makeSound();  // Output: Bark
        
        Animal myDog2 = new Pitbull();
        myDog2.makeSound();  // Output: Bark
        
        Animal myDog3 = new GoldenRetriever();
        myDog3.makeSound();  // Output: Bark

        Animal myCat = new Cat();
        myCat.makeSound();  // Output: Meow
    }
}






// Parent class
class Animal { // spicies
    void makeSound() { // behavior
        System.out.println("Some generic animal sound");
    }
}

// Child classa=
class Dog extends Animal { // spicies // Dog -> Animal (Inheritance)
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
    
    void hi() {
        System.out.println("Hi");
    }
}


class Pitbull extends Dog { // spicies // Dog -> Animal (Inheritance)
    @Override
    void makeSound() {
        super.makeSound(); // parent behavior (inherit)
        System.out.println("loud");
        super.hi();
    }
    
    @Override
    void hi() {
        System.out.println("Hi2");
    }
}
class GoldenRetriever extends Dog { // spicies // Dog -> Animal (Inheritance)
    @Override
    void makeSound() {
        System.out.println("low");
    }
}

// Another Child class
class Cat extends Animal { // spicies
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}


























