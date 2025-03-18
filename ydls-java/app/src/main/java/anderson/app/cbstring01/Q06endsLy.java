package anderson.app.cbstring01;

public class Q06endsLy {
 public static boolean endsLy(String str) {
        if (str.length() != 1 && str.length() != 0 && str.substring(str.length() - 2).equals("ly")) {
            return true;
        } else{
            return false;
        }
    }  
    public static void main(String[] args) {
        System.out.println(endsLy("oddle"));
        System.out.println(endsLy("y"));
        System.out.println(endsLy("oddy"));
        System.out.println(endsLy("oddl"));
        System.out.println(endsLy("olydd"));
        System.out.println(endsLy("ly"));
        System.out.println(endsLy(""));
        System.out.println(endsLy("falsey"));
        System.out.println(endsLy("evenly"));
    }
}