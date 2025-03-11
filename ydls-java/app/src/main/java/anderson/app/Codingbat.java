package anderson.app;

// HW REFERENCE: https://codingbat.com/java/String-1

// import java.nio.channels.Pipe.SourceChannel;

// import javax.sound.sampled.SourceDataLine;



public class Codingbat { // class shell (JAVA design restriction)
    
    public static String makeOutWord(String out, String word) {
        return out.substring(0, 2) + word + out.substring(2, 4);
    }
    
    
    
    public static String firstHalf(String str) {
        return ""+str.substring(0, str.length() / 2);
    } 
    public static String nonStart(String a, String b) {
        return ""+ a.substring(1) + b.substring(1);
    }
    public static String theEnd(String str, boolean front) {
        if (front == false) {  // Corrected comparison: front == false
            return str.substring(str.length() - 1);  // Return the last character of the string
        } else {
            return str.substring(0, 1);  // Return the first character of the string
        }
    }
    public static boolean endsLy(String str) {
        if (str.length() != 1 && str.length() != 0 && str.substring(str.length() - 2).equals("ly")) {
            return true;
        } else{
            return false;
        }
    }  
    // public static String middleThree(String str) {
    //     return str.substring(str.length()-3/2) +  str.substring(str.length()-3/2+1) + str.substring(str.length()-3/2 +1);
    // }
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
    public static String middleThree(String str) {
        int middle = str.length() / 2;
         // must be fixed
        return str.substring(middle - 1, middle + 2); 

    }
    
    public static String seeColor(String str) {
        if (str.startsWith("red")){
            return "red";
        } else if (str.startsWith("blue")){
            return "blue";
        } else {
            return "";
        }
    }
    public static String extraFront(String str) {
        if (str.length() <= (1)) return str + str + str;
        return str.substring(0, 2) + str.substring(0, 2) + str.substring(0, 2);
    }
    public static String startWord(String str, String word) {
        if (str.length() >= word.length() && str.substring(1, word.length()).equals(word.substring(1))) {
        return str.substring(0, word.length()); 
        } else {
        return "";
        }
    }
          
    
    
        
            
    public static void main(String[] args) { // executable method (JAVA design pattern restriction) 
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





        System.out.println(extraFront("Hello"));
        System.out.println(extraFront("ab"));
        System.out.println(extraFront("H"));
        System.out.println(extraFront(""));
        System.out.println(extraFront("Candy"));
        System.out.println(extraFront("Code"));






        System.out.println(middleThree("Candy"));
        System.out.println(middleThree("and"));
        System.out.println(middleThree("solving"));
        System.out.println(middleThree("Hi yet Hi"));
        System.out.println(middleThree("java yet java"));
        System.out.println(middleThree("Chocolate"));
        System.out.println(middleThree("XabcxyzabcX"));



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


        System.out.println(lastChars("last", "chars"));
        System.out.println(lastChars("yo", "java"));
        System.out.println(lastChars("hi", ""));
        System.out.println(lastChars("", "hello"));
        System.out.println(lastChars("", ""));
        System.out.println(lastChars("kitten", "hi"));
        System.out.println(lastChars("k", "zip"));
        System.out.println(lastChars("kitten", ""));
        System.out.println(lastChars("kitten", "zip"));




        System.out.println(endsLy("oddle"));
        System.out.println(endsLy("y"));
        System.out.println(endsLy("oddy"));
        System.out.println(endsLy("oddl"));
        System.out.println(endsLy("olydd"));
        System.out.println(endsLy("ly"));
        System.out.println(endsLy(""));
        System.out.println(endsLy("falsey"));
        System.out.println(endsLy("evenly"));




        System.out.println("\nTEST");





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




        System.out.println(nonStart("Hello", "There"));
        System.out.println(nonStart("java", "code"));
        System.out.println(nonStart("shotl", "java"));
        System.out.println(nonStart("ab", "xy")); 
        System.out.println(nonStart("ab", "x"));
        System.out.println(nonStart("x", "ac"));
        System.out.println(nonStart("a", "x"));
        System.out.println(nonStart("kit", "kat")); 
        System.out.println(nonStart("mart", "dart"));




        // helloNameTest();




        System.out.println(firstHalf("WooHoo"));
        System.out.println(firstHalf("HelloThere"));
        System.out.println(firstHalf("abcdef"));
        System.out.println(firstHalf("ab"));
        System.out.println(firstHalf(""));
        System.out.println(firstHalf("0123456789"));
        System.out.println(firstHalf("kitten"));




        System.out.println(makeOutWord("<<>>", "Yay"));
        System.out.println(makeOutWord("<<>>", "WooHoo"));
        System.out.println(makeOutWord("[[]]", "word"));
        System.out.println(makeOutWord("HHoo", "Hello"));
        System.out.println(makeOutWord("abyz", "YAY"));




    }
}

    
   
