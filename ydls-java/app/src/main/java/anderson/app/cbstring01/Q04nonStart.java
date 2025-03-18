package anderson.app.cbstring01;

public class Q04nonStart{
    public static String nonStart(String a, String b) {
        return ""+ a.substring(1) + b.substring(1);
    }
    
    

    public static void main(String[] args) {
        System.out.println(nonStart("Hello", "There"));
        System.out.println(nonStart("java", "code"));
        System.out.println(nonStart("shotl", "java"));
        System.out.println(nonStart("ab", "xy")); 
        System.out.println(nonStart("ab", "x"));
        System.out.println(nonStart("x", "ac"));
        System.out.println(nonStart("a", "x"));
        System.out.println(nonStart("kit", "kat")); 
        System.out.println(nonStart("mart", "dart"));
    }
}
