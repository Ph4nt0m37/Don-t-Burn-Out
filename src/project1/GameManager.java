package project1;
import project1.InputHandler;
import project1.User;
public class GameManager
{
    //Setup
    private static User user;
    private static String subject;
    private static int maxWrongAnswers;
    //private OrderHandler orderHandler = new OrderHandler();
    private int questionDifficulty = 0;
    
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to Don't Burn Out.");
        String name = InputHandler.getUserInput("What is your name? ");
        user = new User(name);
        
        System.out.println("Hello, "+name+"!\nWhat subject would you like to study today?");
        subject = InputHandler.getUserInput("Please choose a subject:\nEnglish\nMath\nScience\n",new String[]{"English","Math","Science"},"This is not a valid subject!");
        
        System.out.println("Alright, "+subject+ " it is!\n");
        maxWrongAnswers = InputHandler.getUserIntInput("How many questions should you be able to\nget wrong before ending the game? (0-99) ",0,99,"This is not a valid input! Please enter a number between 0 and 99.");
        
        System.out.println("Ok, you can get "+maxWrongAnswers+" questions wrong\nbefore the game ends.");
        System.out.println("\nWell would you look at the time! You restaurant is just about to open!\nGood Luck!");
        
        //ask question/start game loop.
    }

}
