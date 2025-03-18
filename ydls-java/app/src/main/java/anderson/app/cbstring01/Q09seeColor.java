package anderson.app.cbstring01;

public class Q09seeColor {
    public static String seeColor(String str) {
        if (str.startsWith("red")){
            return "red";
        } else if (str.startsWith("blue")){
            return "blue";
        } else {
            return "";
        }
    }
    public static void main(String[] args) {
        System.out.println(seeColor("redxx"));
        System.out.println(seeColor("xxred"));
        System.out.println(seeColor("blueTimes"));	
        System.out.println(seeColor("NoColor"));
        System.out.println(seeColor("red"));	
        System.out.println(seeColor("re"));
        System.out.println(seeColor("blu")); 
        System.out.println(seeColor("blue"));
        System.out.println(seeColor("a") );
        System.out.println(seeColor(""));
        System.out.println(seeColor("xyzred"));
    }
}
