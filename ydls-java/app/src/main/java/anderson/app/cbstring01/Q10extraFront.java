package anderson.app.cbstring01;

public class Q10extraFront {
    public static String extraFront(String str) {
        if (str.length() <= (1)) return str + str + str;
        return str.substring(0, 2) + str.substring(0, 2) + str.substring(0, 2);
    }
    public static void main(String[] args) {
        System.out.println(extraFront("Hello"));
        System.out.println(extraFront("ab"));
        System.out.println(extraFront("H"));
        System.out.println(extraFront(""));
        System.out.println(extraFront("Candy"));
        System.out.println(extraFront("Code"));
    }
}
