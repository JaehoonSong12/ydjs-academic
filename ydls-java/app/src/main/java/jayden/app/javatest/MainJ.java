package jayden.app.javatest;
import java.util.Scanner;  // Correct import statement for NumberFormat

public class MainJ {

    public static void main(String[] args) {
        int height = 5;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a width: ");
        int width = scanner.nextInt();
        // System.out.print("Enter a height: ");
        // int height = scanner.nextInt();


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}