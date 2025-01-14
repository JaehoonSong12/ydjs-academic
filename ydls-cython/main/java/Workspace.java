import java.util.Scanner;

public class Workspace {
    public static void main(String[] args) {

        // // 2.2.1
        // double i = 50.0;
        // double k = i + 50.0;
        // double j = k + 1;

        // System.out.println("j is " + j + " and k is " 
        // + k);

        // // 2.3.1
        // Scanner input = new Scanner(System.in);
        // double radius = input.nextDouble();

        // 2.3.2

        // int a = 2;
        // int b = 6;
        // int c = 3;

        // System.out.println(true);
        // System.out.println(a > b == b < c);
        // System.out.println(a < b != b < c);
        // System.out.println(false);
        // System.out.println(a > b != b > c);




        
        // int temp = 80; // 51, 30, 60
        // String weather = "warm";
        // if (temp <= 70) { weather = "moderate";}
        // if (temp <= 50) { weather = "cool";}
        // if (temp <= 31) { weather = "cold"; }
        
        // System.out.println(weather);



        // int x = 100;
        // int total = 0;
        // while(x > 0){
        //     total = total + x;
        //     x = x - 10;
        // }
        // System.out.println(total);

        // int total = 0;
        // int counter = 0;
        // for (int k = 0; k <= 100; k += 2)
        // {
        //     total += k;
        //     counter++;
        // }

        // System.out.println(total);
        // System.out.println(counter);




        // String temp = "Mississippi";
        // String part = "si";
        // int position = 0;
        // int count = 0;
        // while(temp.indexOf(part) >= 0) {
        //     System.out.println(temp);
        //     System.out.println("index: " + temp.indexOf(part));
            
        //     position = temp.indexOf(part); System.out.println(position);
        //     count++;
        //     temp = temp.substring(position + 1);
        // }
        // System.out.println(temp);
        // System.out.println(count);







      

        return;
    }
}

System.out.println((double) 2 / 4 + 3);
System.out.println((double) (2 / 4) + 3);
System.out.println((double) (2 / 4 + 3));

public class Student
{
private String myName;
private int myAge;


public Student()
{ /* implementation not shown */ }


public Student(String name, int age)
{ /* implementation not shown */ }


//No other constructors
 }


Which of the following declarations will compile without error?
Student a = new Student();
Student b = new Student("Juan", 15);
Student c = new Student("Juan", "15");


I only
II only
I and II only
I and III only
I, II, and III

public static String scramble(String word, int howFar) {
return word.substring(howFar + 1, word.length()) +   
        word.substring(0, howFar);
}

What value is returned as a result of the call scramble("compiler", 3)?

"compiler"
"pilercom"
"ilercom"
"ilercomp"
No value is returned because an IndexOutOfBoundsException will be thrown.

Consider the following code segment, which is intended to assign to num a random integer value between min and max, inclusive. Assume that min and max are integer variables and that the value of max is greater than the value of min.

double rn = Math.random();
int num = /* missing code */;

Which of the following could be used to replace /* missing code */ so that the code segment works as intended?

(int) (rn * max) + min
(int) (rn * max) + min - 1
(int) (rn * (max - min)) + min
(int) (rn * (max - min)) + 1
(int) (rn * (max - min + 1)) + min
