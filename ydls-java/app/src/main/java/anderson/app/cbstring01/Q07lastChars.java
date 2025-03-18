package anderson.app.cbstring01;

public class Q07lastChars{
    public static String lastChars(String a, String b) {
        if (a.length() == (0)){
            a = "@";
        } else {
        a = a.substring(0,1);
        }
        if (b.length() == (0)){
            b = "@";
        } else {
        b = b.substring(b.length() - 1);
        }
        return a + b;
    }  
    public static void main(String[] args) {
    System.out.println(lastChars("last", "chars"));
    System.out.println(lastChars("yo", "java"));
    System.out.println(lastChars("hi", ""));
    System.out.println(lastChars("", "hello"));
    System.out.println(lastChars("", ""));
    System.out.println(lastChars("kitten", "hi"));
    System.out.println(lastChars("k", "zip"));
    System.out.println(lastChars("kitten", ""));
    System.out.println(lastChars("kitten", "zip"));
    }

}