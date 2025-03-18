package anderson.app.cbstring01;

public class Q02MakeOutWord{
    public static String makeOutWord(String out, String word) {
        return out.substring(0, 2) + word + out.substring(2, 4);
    }
    
    

    public static void main(String[] args) {
        System.out.println(makeOutWord("<<>>", "Yay"));
        System.out.println(makeOutWord("<<>>", "WooHoo"));
        System.out.println(makeOutWord("[[]]", "word"));
        System.out.println(makeOutWord("HHoo", "Hello"));
        System.out.println(makeOutWord("abyz", "YAY"));
    }
}
