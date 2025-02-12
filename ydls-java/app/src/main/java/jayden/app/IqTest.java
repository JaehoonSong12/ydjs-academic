package jayden.app;


import java.util.Scanner;



public class IqTest {
    public static void main(String[] args) {
        int IQ_random = (int)(Math.random() * 110);
        
        String name;
        
        int age;
        
        String Q1 = "";
        String Q2 = "";
        
        int Answer1;
        int Answer2;
        
        String fake;
        
        System.out.println("Welcome to IQ test");
        Scanner sc = new Scanner(System.in);
        System.out.print("name: ");
        name = sc.nextLine();
        System.out.print("age: ");
        age = sc.nextInt();
        sc.nextLine(); // consume the newline character
        
        
        
        System.out.print("The test starts now! Lock in! \n");
        
        Scanner scc = new Scanner(System.in);
        
        System.out.print("Do all the non-trivial roots have real part 1/2?(yes or no): ");
        Q1 = scc.nextLine();
        
        System.out.print("What does Z stand in math?(in one lowercase word): ");
        Q2 = scc.nextLine();
        
        System.out.print("200*100: ");
        fake = scc.nextLine();
        
        System.out.print("What is life? ");
        fake = scc.nextLine();
        
        System.out.print("Do you need water(yes or no): ");
        fake = scc.nextLine();
        
        System.out.print("What is most common word you use? ");
        fake = scc.nextLine();
        
        switch(Q1){
            case "yes":
                Answer1 = 30;
                break;
            default:
                Answer1 = 0;
                break;
        }
        
        
        switch(Q2){
            case "integers":
                Answer2 = 60;
                break;
            default:
                Answer2 = 0;
                break;
        }
        
        
        
        int totalIQ = IQ_random + Answer1 + Answer2;

        System.out.println("Your IQ is " + totalIQ);
        
        sc.close(); // Close the scanner
        
        
        
        
        

    }
}





