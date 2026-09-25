package project1;

import java.util.Random;

/**
 * Handles the creation of customer orders and the selection of questions for
 * the Don't Burn Out game.
 * <p>
 * This class stores the question and answer banks for Math, Science, and
 * English. It can also use custom questions loaded through a
 * {@link CustomQuestionHandler}.
 * </p>
 * <p>
 * The {@code OrderHandler} is responsible for generating orders based on the
 * current question difficulty and selecting questions that match the difficulty
 * of the current order.
 * </p>
 * 
 * @author Brinda Amidyala
 * @author Paulo Korowajczuk Nader
 */
public class OrderHandler
{
    /**
     * The order currently being completed by the player.
     */
    private Order currentOrder;

    /**
     * The subject from which questions should be selected.
     */
    private String subject;

    /**
     * The question currently being asked.
     */
    private String currentQuestion;

    /**
     * The answer to the current question.
     */
    private String currentAnswer;

    /**
     * The bank of Math questions organized by difficulty.
     */
    private String[] mathQuestionBank = {

        // easy — 0 to 32

        "What is 5 + 7?", "What is 12 - 5?", "What is 6 * 4?",
        "What is 20 / 5?", "What is 10 + 15?", "What is 30 - 12?",
        "What is 7 * 3?", "What is 36 / 6?", "What is 9 + 8?",
        "What is 25 - 10?", "What is 5 * 5?", "What is 48 / 8?",
        "What is 14 + 9?", "What is 40 - 17?", "What is 8 * 4?",
        "What is 63 / 7?", "What is 11 + 12?", "What is 50 - 25?",
        "What is 9 * 6?", "What is 72 / 9?", "What is 15 + 16?",
        "What is 60 - 24?", "What is 7 * 8?", "What is 81 / 9?",
        "What is 18 + 17?", "What is 100 - 45?", "What is 12 * 5?",
        "What is 96 / 12?", "What is 22 + 19?", "What is 75 - 28?",
        "What is 11 * 7?", "What is 144 / 12?", "What is 25% of 100?",

        // medium — 33 to 65

        "What is 15% of 200?", "Solve: x + 7 = 15.", "Solve: x - 9 = 12.",
        "Solve: 3x = 21.", "Solve: x / 4 = 6.", "What is 3/4 + 1/4?",
        "What is 5/6 - 1/6?", "What is 2/3 * 3/4?",
        "What is 3/5 divided by 1/5?",
        "What is the perimeter of a rectangle with length 8 and width 5?",
        "What is the area of a rectangle with length 9 and width 4?",
        "What is the area of a triangle with base 10 and height 6?",
        "What is the average of 10, 20, and 30?",
        "What is the next number: 2, 4, 8, 16, ___?", "What is 2^5?",
        "What is the square root of 144?", "Simplify: 3(x + 4).",
        "Solve: 2x + 5 = 15.", "Solve: 4x - 3 = 17.",
        "What is the slope between (1,2) and (3,6)?",
        "What is the y-intercept of y = 2x + 5?", "Convert 0.75 to a fraction.",
        "Convert 3/5 to a decimal.", "What is 30% of 250?",
        "A shirt costs $40 and is 25% off. What is the sale price?",
        "What is the probability of rolling a 6 on a standard die?",
        "What is the probability of getting heads when flipping a fair coin?",
        "Simplify: 5x + 3x.", "Simplify: 7x - 2x + 4.", "Solve: 5x + 10 = 35.",
        "What is the circumference of a circle with radius 5?",
        "What is the area of a circle with radius 3?",
        "What is the volume of a rectangular prism measuring 2 × 3 × 4?",

        // hard — 66 to 99

        "Solve: 3x + 7 = 25.", "Solve: 5x - 8 = 32.", "Solve: 2(x + 3) = 18.",
        "Solve: 4(x - 2) = 28.", "Solve: 3x + 5 = 2x + 14.",
        "Solve: 7x - 4 = 3x + 20.", "Factor: x^2 + 5x + 6.", "Factor: x^2 - 9.",
        "Expand: (x + 3)(x + 4).", "Expand: (x - 2)(x + 5).",
        "Solve: x^2 = 49.", "Solve: x^2 - 9 = 0.",
        "What is the slope of a line perpendicular to y = 2x + 1?",
        "What is the distance between (0,0) and (3,4)?",
        "What is the midpoint of (2,4) and (6,8)?", "Simplify: (2x^2)(3x^3).",
        "Simplify: x^5 / x^2.", "Simplify: (x^3)^2.", "What is log10(1000)?",
        "What is 2^3 * 2^4?", "Solve: 2^x = 32.", "Solve: x/3 + 4 = 10.",
        "A right triangle has legs 6 and 8. What is its hypotenuse?",
        "What is the area of a trapezoid with bases 8 and 12 and height 5?",
        "What is the volume of a cylinder with radius 3 and height 4?",
        "What is the derivative of x^2?",
        "What is the derivative of 3x^2 + 2x?", "What is the integral of 2x?",
        "Evaluate: lim(x->2) (x + 3).",
        "Solve the system: x + y = 10 and x - y = 2.",
        "What is the discriminant of x^2 + 4x + 4?", "Solve: x^2 - 5x + 6 = 0.",
        "What is the probability of drawing an ace from a standard 52-card deck?",
        "If f(x) = 2x + 3, what is f(5)?" };

    /**
     * The bank of answers corresponding to the Math question bank.
     */
    private String[] mathAnswerBank = {

        // easy — 0 to 32

        "12", "7", "24", "4", "25", "18", "21", "6", "17", "15", "25", "6",
        "23", "23", "32", "9", "23", "25", "54", "8", "31", "36", "56", "9",
        "35", "55", "60", "8", "41", "47", "77", "12", "25",

        // medium — 33 to 65

        "30", "8", "21", "7", "24", "1", "2/3", "1/2", "3", "26", "36", "30",
        "20", "32", "32", "12", "3x + 12", "5", "5", "2", "5", "3/4", "0.6",
        "75", "$30", "1/6", "1/2", "8x", "5x + 4", "5", "10π", "9π", "24",

        // hard — 66 to 99

        "6", "8", "6", "9", "9", "6", "(x+2)(x+3)", "(x-3)(x+3)",
        "x^2 + 7x + 12", "x^2 + 3x - 10", "7 or -7", "3 or -3", "-1/2", "5",
        "(4,6)", "6x^5", "x^3", "x^6", "3", "128", "5", "18", "10", "50", "36π",
        "2x", "6x + 2", "x^2 + C", "5", "6", "0", "0", "1/13", "13" };

    /**
     * The bank of Science questions organized by difficulty.
     */
    private String[] scienceQuestionBank = {
        // Your existing Science questions...
    };

    /**
     * The bank of answers corresponding to the Science question bank.
     */
    private String[] scienceAnswerBank = {
        // Your existing Science answers...
    };

    /**
     * The bank of English questions organized by difficulty.
     */
    private String[] englishQuestionBank = {
        // Your existing English questions...
    };

    /**
     * The bank of answers corresponding to the English question bank.
     */
    private String[] englishAnswerBank = {
        // Your existing English answers...
    };

    /**
     * Handles questions loaded from a custom questions file.
     */
    private CustomQuestionHandler customQuestionHandler;

    /**
     * Handles the player's equipment and shop-related information.
     */
    private ShopHandler shopHandler;

    /**
     * Creates an OrderHandler for the standard built-in question banks.
     *
     * @param shopHandler
     *            the ShopHandler used to access the player's equipment and its
     *            effects on orders
     */
    public OrderHandler(ShopHandler shopHandler)
    {
        this.shopHandler = shopHandler;
    }


    /**
     * Creates an OrderHandler that uses custom questions.
     *
     * @param questionHandler
     *            the handler used to retrieve custom questions
     * @param shopHandler
     *            the ShopHandler used to access the player's equipment and its
     *            effects on orders
     */
    public OrderHandler(
        CustomQuestionHandler questionHandler,
        ShopHandler shopHandler)
    {
        this.customQuestionHandler = questionHandler;
        this.shopHandler = shopHandler;
    }


    /**
     * Generates a new customer order based on the specified question
     * difficulty.
     * <p>
     * The order type is randomly selected from the available food items. The
     * time allowed, number of questions required, and monetary value depend on
     * the specified difficulty. The player's equipment time multiplier is also
     * applied to the time allowed.
     * </p>
     * <p>
     * Difficulty 0 generates an order requiring one question and worth $10.
     * Difficulty 1 generates an order requiring two questions and worth $20.
     * Difficulty 2 or higher generates an order requiring three questions and
     * worth $30.
     * </p>
     *
     * @param questionDifficulty
     *            the difficulty level of the order
     * @return the newly generated customer order
     */
    public Order generateOrder(int questionDifficulty)
    {
        String orderType;
        long orderTime = 0;
        int fulfillOrderAmount = 0;
        int orderValue = 0;

        double rand = Math.random();

        if (rand < 0.1)
        {
            orderType = "pizza";
        }
        else if (rand < 0.2)
        {
            orderType = "sandwich";
        }
        else if (rand < 0.3)
        {
            orderType = "pasta";
        }
        else if (rand < 0.4)
        {
            orderType = "chicken";
        }
        else if (rand < 0.5)
        {
            orderType = "steak";
        }
        else if (rand < 0.6)
        {
            orderType = "burger";
        }
        else if (rand < 0.7)
        {
            orderType = "hot dog";
        }
        else if (rand < 0.8)
        {
            orderType = "taco";
        }
        else if (rand < 0.9)
        {
            orderType = "burrito";
        }
        else
        {
            orderType = "fries";
        }

        if (questionDifficulty == 0)
        {
            orderTime =
                (long)(60 * shopHandler.getUserEquipment().getTimeMult());
            fulfillOrderAmount = 1;
            orderValue = 10;
        }
        else if (questionDifficulty == 1)
        {
            orderTime =
                (long)(50 * shopHandler.getUserEquipment().getTimeMult());
            fulfillOrderAmount = 2;
            orderValue = 20;
        }
        else
        {
            orderTime =
                (long)(40 * shopHandler.getUserEquipment().getTimeMult());
            fulfillOrderAmount = 3;
            orderValue = 30;
        }

        currentOrder = new Order(
            orderType,
            orderTime,
            fulfillOrderAmount,
            orderValue,
            questionDifficulty);

        return currentOrder;
    }


    /**
     * Selects the next question based on the current subject and the difficulty
     * of the current order.
     * <p>
     * For Math, Science, and English, a random question is selected from the
     * appropriate section of the corresponding question bank. When the subject
     * is Custom, the {@link CustomQuestionHandler} is used to retrieve a
     * question and answer.
     * </p>
     */
    public void nextQuestion()
    {
        if (subject.equalsIgnoreCase("Math"))
        {
            Random random = new Random();

            int index = random.nextInt(mathQuestionBank.length / 3)
                + (mathQuestionBank.length / 3
                    * currentOrder.getQuestionDifficulty());

            currentQuestion = mathQuestionBank[index];
            currentAnswer = mathAnswerBank[index];
        }
        else if (subject.equalsIgnoreCase("Science"))
        {
            Random random = new Random();

            int index = random.nextInt(scienceQuestionBank.length / 3)
                + (scienceQuestionBank.length / 3
                    * currentOrder.getQuestionDifficulty());

            currentQuestion = scienceQuestionBank[index];
            currentAnswer = scienceAnswerBank[index];
        }
        else if (subject.equalsIgnoreCase("English"))
        {
            Random random = new Random();

            int index = random.nextInt(englishQuestionBank.length / 3)
                + (englishQuestionBank.length / 3
                    * currentOrder.getQuestionDifficulty());

            currentQuestion = englishQuestionBank[index];
            currentAnswer = englishAnswerBank[index];
        }
        else if (subject.equalsIgnoreCase("Custom"))
        {
            String[] qAndA = customQuestionHandler
                .getQuestionAndAnswer(currentOrder.getQuestionDifficulty());

            currentQuestion = qAndA[0];
            currentAnswer = qAndA[1];
        }
    }


    /**
     * Sets the subject used to determine which question bank should provide
     * questions.
     *
     * @param subject
     *            the subject to use, such as Math, Science, English, or Custom
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }


    /**
     * Gets the question currently being asked.
     *
     * @return the current question
     */
    public String getCurrentQuestion()
    {
        return currentQuestion;
    }


    /**
     * Gets the correct answer to the current question.
     *
     * @return the current question's correct answer
     */
    public String getCurrentQuestionAnswer()
    {
        return currentAnswer;
    }
}
