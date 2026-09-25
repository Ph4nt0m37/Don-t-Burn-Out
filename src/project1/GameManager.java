package project1;

import java.io.*;
import project1.*;

/**
 * Manages the main game flow for Don't Burn Out.
 * <p>
 * The GameManager handles setting up the user, selecting the question subject,
 * loading custom questions, configuring the maximum number of incorrect
 * answers, and starting the main game loop.
 * </p>
 * <p>
 * It also manages the progression of question difficulty and allows the player
 * to access the shop after completing orders.
 * </p>
 * 
 * @author Paulo Korowajczuk Nader
 */
public class GameManager
{
    // Setup

    private static User user;
    private static String subject;
    private static int maxWrongAnswers;
    private static OrderHandler orderHandler;
    private static CustomQuestionHandler customQuestionHandler = null;
    private static int questionDifficulty = 0;
    private static ShopHandler shopHandler;

    /**
     * Starts the Don't Burn Out game.
     * <p>
     * This method creates the player, initializes the shop and question
     * handlers, allows the player to choose between custom and built-in
     * questions, and asks the player how many questions they may answer
     * incorrectly before the game ends.
     * </p>
     * <p>
     * If the player chooses to use custom questions and the questions file does
     * not exist, the method attempts to create the file before ending the
     * program.
     * </p>
     *
     * @param args
     *            command-line arguments passed to the program
     */
    public static void main(String[] args)
    {
        System.out.println("Hello! Welcome to Don't Burn Out.");

        String name = InputHandler.getUserInput("What is your name? ");

        user = new User(name);

        shopHandler = new ShopHandler(user);

        System.out.println("Hello, " + name + "!");

        boolean loadCustomQuestions = InputHandler.getUserBoolInput(
            "Would you like to load custom questions from questions.txt? (Y/N) ",
            "This is not a valid input!");

        if (loadCustomQuestions)
        {

            try
            {
                customQuestionHandler =
                    new CustomQuestionHandler("questions.txt");
            }
            catch (FileNotFoundException e)
            {
                System.out.println(
                    "questions.txt was not found! Attempting to create "
                        + "questions.txt...");

                File questionsFile = new File("questions.txt");

                try
                {
                    if (questionsFile.createNewFile())
                    {

                        System.out.println(
                            "questions.txt successfully created! Please "
                                + "add your questions to the file and rerun "
                                + "the program.");

                    }
                    else
                    {

                        System.out.println(
                            "Something went wrong when creating "
                                + "questions.txt. Please try again later.");
                    }

                }
                catch (IOException e1)
                {
                    System.out.println(
                        "Something went wrong when creating "
                            + "questions.txt. Please try again later.");
                }

                System.exit(0);
            }

            orderHandler = new OrderHandler(customQuestionHandler, shopHandler);

            subject = "custom";

            orderHandler.setSubject(subject);

            System.out.println("Questions successfully loaded!");

        }
        else
        {

            orderHandler = new OrderHandler(shopHandler);

            System.out.println(
                "Hello, " + name
                    + "!\nWhat subject would you like to study today?");

            subject = InputHandler.getUserInput(
                "Please choose a subject:\nEnglish\nMath\nScience\n",
                new String[] { "English", "Math", "Science" },
                "This is not a valid subject!");

            orderHandler.setSubject(subject);

            System.out.println("Alright, " + subject + " it is!\n");
        }

        maxWrongAnswers = InputHandler.getUserIntInput(
            "How many questions should you be able to\n"
                + "get wrong before ending the game? (0-99) ",
            0,
            99,
            "This is not a valid input! Please enter a number between "
                + "0 and 99.");

        System.out.println(
            "Ok, you can get " + maxWrongAnswers
                + " questions wrong\nbefore the game ends.");

        System.out.println(
            "\nWell would you look at the time! You restaurant is just "
                + "about to open!\nGood Luck!");

        // Ask question/start game loop.
        startGameLoop();
    }


    /**
     * Runs the main game loop.
     * <p>
     * Orders are generated and the player must correctly answer questions to
     * fulfill each order. Incorrect answers increase the player's failed
     * question count. The game ends when the player exceeds the maximum number
     * of allowed incorrect answers.
     * </p>
     * <p>
     * The question difficulty increases as the player completes orders. The
     * shop is also made available after every five completed orders.
     * </p>
     */
    private static void startGameLoop()
    {
        int numOrdersCompleted = 0;

        while (user.getNumFailedQuestions() <= maxWrongAnswers)
        {

            if (numOrdersCompleted % 5 == 0 && numOrdersCompleted != 0)
            {

                System.out.println(
                    "Would you like to purchase anything from the shop?");

                shopHandler.printShop();
            }

            if (questionDifficulty < 2
                && numOrdersCompleted % Math.max(5, maxWrongAnswers) == 0
                && numOrdersCompleted != 0)
            {

                questionDifficulty++;

                System.out.println("Question Difficulty Increased!");
            }

            Order currentOrder = orderHandler.generateOrder(questionDifficulty);

            System.out.println(
                "A customer wants a(n) " + currentOrder.getOrderType() + ".");

            orderHandler.nextQuestion();

            while (currentOrder.getFulfillOrderAmount() > 0
                && user.getNumFailedQuestions() <= maxWrongAnswers)
            {
                orderHandler.nextQuestion();
                System.out.println(
                    "You need to answer " + currentOrder.getFulfillOrderAmount()
                        + " more questions to fulfill this order.");

                long startTime = System.currentTimeMillis();

                String answer = InputHandler
                    .getUserInput(orderHandler.getCurrentQuestion() + "\n");

                if (System.currentTimeMillis()
                    - startTime > (currentOrder.getOrderTime() * 1000))
                {

                    System.out.println(
                        "You took too long to answer the question "
                            + "so the customer left!");

                    break;
                }

                if (answer
                    .equalsIgnoreCase(orderHandler.getCurrentQuestionAnswer()))
                {

                    currentOrder.setFulfillOrderAmount(
                        currentOrder.getFulfillOrderAmount() - 1);

                    System.out.println(
                        "Correct! You just got $" + currentOrder.getOrderValue()
                            + ".");

                    user.setMoney(
                        user.getMoney() + currentOrder.getOrderValue());

                }
                else
                {

                    user.setNumFailedQuestions(
                        user.getNumFailedQuestions() + 1);

                    if (maxWrongAnswers - user.getNumFailedQuestions() >= 0)
                    {

                        System.out.println(
                            "Incorrect! The correct answer is: "
                                + orderHandler.getCurrentQuestionAnswer()
                                + ". You can get "
                                + (maxWrongAnswers
                                    - user.getNumFailedQuestions())
                                + " more questions wrong before the game ends.");

                        orderHandler.nextQuestion();

                    }
                    else
                    {

                        System.out.println(
                            "Incorrect! The correct answer is: "
                                + orderHandler.getCurrentQuestionAnswer()
                                + ". The game is now over.");
                    }
                }
            }

            numOrdersCompleted++;
        }
    }
}
