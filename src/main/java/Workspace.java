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

        int a = 2;
        int b = 6;
        int c = 3;

        System.out.println(true);
        System.out.println(a > b == b < c);
        System.out.println(a < b != b < c);
        System.out.println(false);
        System.out.println(a > b != b > c);




        
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





        String temp = "Mississippi";
        String part = "si";
        int position = 0;
        int count = 0;
        while(temp.indexOf(part) >= 0) {
            System.out.println(temp);
            System.out.println("index: " + temp.indexOf(part));
            
            position = temp.indexOf(part); System.out.println(position);
            count++;
            temp = temp.substring(position + 1);
        }
        System.out.println(temp);
        System.out.println(count);


        return;
    }
}
