package anderson.app.cbstring01;

public class Q03firstHalf{

    public static String firstHalf(String str) {
        return ""+str.substring(0, str.length() / 2);
    } 
    public static void main(String[] args) {
    System.out.println(firstHalf("WooHoo"));
    System.out.println(firstHalf("HelloThere"));
    System.out.println(firstHalf("abcdef"));
    System.out.println(firstHalf("ab"));
    System.out.println(firstHalf(""));
    System.out.println(firstHalf("0123456789"));
    System.out.println(firstHalf("kitten"));
    }
}
