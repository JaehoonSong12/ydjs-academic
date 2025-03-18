package anderson.app;

// HW REFERENCE: https://codingbat.com/java/String-1

// import java.nio.channels.Pipe.SourceChannel;

// import javax.sound.sampled.SourceDataLine;



public class Codingbat { // class shell (JAVA design restriction)
    
    
    



    
    // public static String middleThree(String str) {
    //     return str.substring(str.length()-3/2) +  str.substring(str.length()-3/2+1) + str.substring(str.length()-3/2 +1);
    // }
    

    


    public static String startWord(String str, String word) {
        if (str.length() >= word.length() && str.substring(1, word.length()).equals(word.substring(1))) {
        return str.substring(0, word.length()); 
        } else {
        return "";
        }
    }
          
    
    
        
            
    public static void main(String[] args) { // executable method (JAVA design pattern restriction) 






























        System.out.println("\nTEST");















        // helloNameTest();














    }
}

    
   
