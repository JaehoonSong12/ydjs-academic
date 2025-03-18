package anderson.app.cbstring01;

public class Q05theEnd {
    public static String theEnd(String str, boolean front) {
        if (front == false) {  // Corrected comparison: front == false
            return str.substring(str.length() - 1);  // Return the last character of the string
        } else {
            return str.substring(0, 1);  // Return the first character of the string
        }
    }
        public static void main(String[] args) {
            System.out.println(theEnd("Hello", false));
            System.out.println(theEnd("Hello", true)) ;
            System.out.println(theEnd("oh", true));
            System.out.println(theEnd("oh", false));
            System.out.println(theEnd("x", true));
            System.out.println(theEnd("x", false));
            System.out.println(theEnd("java", true)) ;
            System.out.println(theEnd("chocolate", false));
            System.out.println(theEnd("1234", true)) ;
            System.out.println(theEnd("code", false));
        }
    }
