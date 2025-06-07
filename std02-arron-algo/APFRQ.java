
/**
 * The Algorithm class contains recursive methods for several algorithmic problems.
 * <p>
 * It includes methods to compute factorial, count bunny ears, calculate Fibonacci numbers,
 * sum the digits of a number, count occurrences of the digit 8 (with special counting rules),
 * and compute exponentiation recursively.
 * </p>
 * 
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      ```
 *      javac std02-arron-algo/APFRQ.java
 *      ```
 * 3. Run & Clean: 
 *      ```
 *      java -cp std02-arron-algo APFRQ; rm -rf std02-arron-algo/*.class
 *      ```
 */
public class APFRQ {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
    }
}




class Level
{
    /** Returns true if the player reached the goal on this level and returns false otherwise */
    public boolean goalReached() {
        return false;
    }
    /** Returns the number of points (a positive integer) recorded for this level */
    public int getPoints(){
        return 0;
    }
    // There may be instance variables, constructors, and methods that are not shown.
}

class Game
{
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;
    /** Postcondition: All instance variables have been initialized. */
    public Game()
    { /* implementation not shown */ }
    /** Returns true if this game is a bonus game and returns false otherwise */
    public boolean isBonus(){
        return false;
    }
    /** Simulates the play of this Game (consisting of three levels) and updates all relevant
        * game data
        */
    public void play()
    { /* implementation not shown */ }


    /** Simulates the play of num games and returns the highest score earned, as
        * described in part (b)
        * Precondition: num > 0
        */
    public int playManyTimes(int num) {
        int maxScore = 0;
        for(int i = 0; i < num; i++) {
            this.play();
            int score = this.getScore();
            if(score > maxScore) maxScore = score;
        }
        return maxScore;
    }
    // There may be instance variables, constructors, and methods that are not shown.




    /** Returns the score earned in the most recently played game, as described in part (a) */
    public int getScore() {
        int score = 0;
        if (levelOne.goalReached()) {
            score += levelOne.getPoints();
        }

        if(levelOne.goalReached() && levelTwo.goalReached()) {
            score += levelTwoPoint.getPoints();
        }

        if(levelOne.goalReached() && levelTwo.goalReached() && levelThree.goalReached()) {
            score += levelThreePoint.getPoints();
        }
        
        
        if (isBonus()){
            score *= 3;
        } 
    }
}







class Book
{
    /** The title of the book */
    private String title;
    /** The price of the book */
    private double price;
    /** Creates a new Book with given title and price */
    public Book(String bookTitle, double bookPrice)
    { /* implementation not shown */ }
    /** Returns the title of the book */
    public String getTitle()
    { return title; }
    /** Returns a string containing the title and price of the Book */
    public String getBookInfo()
    {
        return title + "-" + price;
    }
    // There may be instance variables, constructors, and methods that are not shown.
}
public class TextBooks extends Book {
    private int edition;
    public int getEdition() {
        return this.edition;
    }
    
    public boolean canSubstitiuteFor(){
        if(edition)
    }

}