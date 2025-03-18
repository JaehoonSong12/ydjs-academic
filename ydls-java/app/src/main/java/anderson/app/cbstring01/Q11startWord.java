package anderson.app.cbstring01;

public class Q11startWord {
    public static String startWord(String str, String word) {
        if (str.length() >= word.length() && str.substring(1, word.length()).equals(word.substring(1))) {
        return str.substring(0, word.length()); 
        } else {
        return "";
        }
    }
    public static void main(String[] args) {
        System.out.println(startWord("hippo", "hi"));
        System.out.println(startWord("hippo", "xip"));
        System.out.println(startWord("hippo", "i"));
        System.out.println(startWord("hippo", "ix"));
        System.out.println(startWord("h", "ix"));
        System.out.println(startWord("", "i"));
        System.out.println(startWord("hip", "zi"));
        System.out.println(startWord("hip", "zip"));
        System.out.println(startWord("hip", "zig"));
        System.out.println(startWord("h", "z"));
        System.out.println(startWord("hippo", "xippo"));
        System.out.println(startWord("hippo", "xyz"));
        System.out.println(startWord("hippo", "hip"));
        System.out.println(startWord("kitten", "cit"));
        System.out.println(startWord("kit", "cit") );
    }
}
