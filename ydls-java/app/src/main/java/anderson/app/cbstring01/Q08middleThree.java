package anderson.app.cbstring01;

public class Q08middleThree{
    public static String middleThree(String str) {
        int middle = str.length() / 2;
         // must be fixed
        return str.substring(middle - 1, middle + 2); 

    }
    public static void main(String[] args) {
        System.out.println(middleThree("Candy"));
        System.out.println(middleThree("and"));
        System.out.println(middleThree("solving"));
        System.out.println(middleThree("Hi yet Hi"));
        System.out.println(middleThree("java yet java"));
        System.out.println(middleThree("Chocolate"));
        System.out.println(middleThree("XabcxyzabcX"));
    }


}