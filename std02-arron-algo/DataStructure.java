/**
 * The DataStructure class demonstrates the implementation of a dynamic array (ArrayListX)
 * and a set (ArraySet) with custom behaviors.
 * <p>
 * It includes methods to perform basic list operations such as add, get, remove, and contains,
 * as well as set-specific operations like union and intersection. The ArraySet class extends
 * ArrayListX to enforce set semantics by preventing duplicate elements.
 * </p>
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      ```
 *      javac std02-arron-algo/DataStructure.java
 *      ```
 * 
 * 3. Run & Clean: 
 *      ```
 *      java -cp std02-arron-algo DataStructure; rm -rf std02-arron-algo/*.class
 *      ```
 */

// import mypack.MyClass; // 2. declare which package to use
import java.util.ArrayList;
// import java.util.*; // wildcard

// javac -> .java -> 1 class (public: main class) + n class (none (default): side class)
public class DataStructure { // executable file (class)
    public static void main(String[] args) {
        // CRUD == 
        // Create   v
        // Read
        // Update   v
        // Delete


        // // 1. Create (C)
        // ArrayList<String> fruits = new ArrayList<>();



        // // 2. [Update]
        // fruits.add("Apple");  // ["Apple","Orange","Banana","Cherry"]

        // System.out.println(fruits.toString());

        // fruits.add("Banana");

        // System.out.println(fruits);

        // fruits.add("Cherry");
        
        // System.out.println(fruits);

        // // 3. [Update] Insert at index
        // fruits.add(1, "Orange");  // ["Apple","Orange","Banana","Cherry"]

        // System.out.println(fruits);


        // // [Update]: setter
        // fruits.set(2, "Blueberry");        // replaces "Banana"
        // System.out.println(fruits);


        // // 5. [Update]: Remove
        // fruits.remove("Cherry");
        // System.out.println(fruits);

        // fruits.remove(0);                  // removes "Apple"
        // System.out.println(fruits);



        // // 4. READ
        // for (int i = 0; i < fruits.size(); i++) {
        //     System.out.println(fruits.get(i));
        // }
        // // 6. Iterate (****** for each loop)
        // for (String f : fruits) {
        //     System.out.println(f);
        // }


        ArrayListX arr = new ArrayListX();
        arr.add(8.8);

        arr.add(12.2);
        arr.add(20.2);
        System.out.println(arr);
        
        arr.add(1, 9.8);
        System.out.println(arr);

        arr.remove(12.2);
        System.out.println(arr);
        arr.remove(0);
        System.out.println(arr);
        
        
        
        arr.set(1, 100.11);
        System.out.println(arr);


        System.out.println(arr.contains(100.11));
        System.out.println(arr.contains(0.11));
        

        
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    


        // MyClass.main(args);



        // ArrayList<String> // generics





        ArrayListX set = new ArraySet();
        // statical typing (static binding)
        // statically typed data vs dynamically typed data (polymorphism)
        set.add(2.5);
        System.out.println(set);
        set.add(10.5);
        System.out.println(set);
        set.add(9.99); // (dynamic binding)
        System.out.println(set);
        set.add(9.99);
        System.out.println(set);

        if (set instanceof ArraySet) {
            System.out.println("you are ArraySet data type! (Dynamically decided)");
            ArrayListX newArr = ((ArraySet) set).get(); // (down casting)
            System.out.println(newArr);
        }

        double d = -4.67;
        System.out.println((int) d);
        for (int i = 0; i < 50; i++) System.out.println(Math.random());
    }
}




class ArrayListX extends Object {
    protected double[] arr;
    protected int size;
    private static final int defaultSize = 16;

    public ArrayListX() { // no-args constructor
        super();
        this.size = 0;
        this.arr = new double[defaultSize];
    }
    public ArrayListX(double[] arr, int size) {
        this(); // constructor chain, 
        for (int i = 0; i < size; i++) {
            add(arr[i]);
        }
    }



    public int size() { return this.size; }
    public boolean isEmpty() { return this.size == 0; }






    public boolean add(double element) {
        if (this.size == this.arr.length) resize(); // full of elements, resize
        this.arr[size++] = element;
        return true;
    } // Overload
    public boolean add(int index, double element) {
        if (this.size == this.arr.length) resize();
        for(int i = this.size; i > index; i--){
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        this.size++;
        return true;
    }
    private void resize() {
        double[] temp = new double[this.arr.length * 2];
        for(int i = 0; i < this.arr.length; i++){
            temp[i] = this.arr[i];
        }
        this.arr = temp;
        return;
    }

    public double remove(double element){
        int index = -1;
        for(int i = 0; i < size(); i++){
            if(arr[i] == element) {
                index = i;
                break;
            }
        }
        if (index == -1) throw new RuntimeException("Value is not found: " + element);
        for(int i = index + 1; i < size(); i++){
            arr[i - 1] = arr[i];
        } 
        this.size--;
        return element;
    } //overload
    public double remove(int index) {
        double element = arr[index];
        for(int i = index + 1; i < size(); i++){
            arr[i - 1] = arr[i];
        } 
        this.size--;
        return element;
    }

    public boolean set(int index, double element){
        arr[index] = element;
        return true;
    }
    
    public double get(int index){
        return arr[index];
    }

    public boolean contains(double element){
        for(int i = 0; i < this.size; i++){
            if(arr[i] == element) return true;
        }
        return false;
    }





    
    @Override // Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.size; i++) {
            result += (i == this.size - 1) ? (this.arr[i]) : (this.arr[i] + ", ");
        }
        result += "]";
        return result;
    }
    
}



class ArraySet extends ArrayListX {
    public ArraySet() {
        super();
    }

    @Override
    public boolean add(double element) {
        if(this.contains(element)) return false;
        return super.add(element);
    }
    @Override
    public boolean add(int index, double element) {
        return this.add(element);
    }
    
    @Override
    public boolean set(int index, double element){
        return false;
    }
    

    public ArrayListX get() {
        return new ArrayListX(super.arr, super.size);
    }


    @Override // Override
    public String toString() {
        String result = "{";
        for (int i = 0; i < this.size; i++) {
            result += (i == this.size - 1) ? (this.arr[i]) : (this.arr[i] + ", ");
        }
        result += "}";
        return result;
    }
}
