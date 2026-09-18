package project1;
import project1.*;
public class GameManager
{
    //Setup
    private static User user;
    private static String subject;
    private static int maxWrongAnswers;
    //private OrderHandler orderHandler = new OrderHandler();
    private static int questionDifficulty = 0;
    
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
        orderHandler.nextQuestion();
        while (user.getNumFailedQuestions()<=maxWrongAnswers) {
            Order currentOrder = orderHandler.generateOrder(questionDifficulty);
            System.out.println("A customer wants a(n) "+currentOrder.getOrderType()+".");
            while (currentOrder.getFulfillOrderAmount()>0) {
                System.out.println("You need to answer "+currentOrder.getFulfillOrderAmount()+" more questions to fulfill this order.");
                String answer = InputHandler.getUserInput(orderHandler.getCurrentQuestion()+"\n");
                if (answer.equalsIgnoreCase(orderHandler.getCurrentQuestionAnswer())) {
                    currentOrder.setFulfillOrderAmount(currentOrder.getFulfillOrderAmount()-1);
                    System.out.println("Correct! You just got $"+currentOrder.getOrderValue()+".");
                    orderHandler.nextQuestion();
                }else {
                    user.setNumFailedQuestions(user.getNumFailedQuestions()+1);
                    System.out.println("Incorrect! You can get "+(maxWrongAnswers-user.getNumFailedQuestions())+" more questions wrong before the game ends.");
                    if (user.getNumFailedQuestions()<=maxWrongAnswers) break;
                }
            }
            currentOrder = orderHandler.generateOrder(questionDifficulty);
        }
    }

}
