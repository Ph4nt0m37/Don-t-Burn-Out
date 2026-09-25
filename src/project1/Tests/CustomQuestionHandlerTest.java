package project1.Tests;

import student.TestCase;

/**
 * Tests for the OrderHandler class.
 *
 * @author Paulo Korowajczuk Nader
 * @version 09.24.2026
 */
public class OrderHandlerTest
    extends TestCase
{
    private ShopHandler shopHandler;
    private OrderHandler orderHandler;


    /**
     * Sets up each test.
     */
    public void setUp()
    {
        shopHandler = new ShopHandler();
        orderHandler = new OrderHandler(shopHandler);
    }


    /**
     * Tests generateOrder() with easy difficulty.
     */
    public void testGenerateEasyOrder()
    {
        Order order = orderHandler.generateOrder(0);

        assertNotNull(order);
        assertEquals(1, order.getFulfillOrderAmount());
        assertEquals(10, order.getOrderValue());
        assertEquals(0, order.getQuestionDifficulty());

        assertNotNull(order.getOrderType());
    }


    /**
     * Tests generateOrder() with medium difficulty.
     */
    public void testGenerateMediumOrder()
    {
        Order order = orderHandler.generateOrder(1);

        assertNotNull(order);
        assertEquals(2, order.getFulfillOrderAmount());
        assertEquals(20, order.getOrderValue());
        assertEquals(1, order.getQuestionDifficulty());

        assertNotNull(order.getOrderType());
    }


    /**
     * Tests generateOrder() with hard difficulty.
     */
    public void testGenerateHardOrder()
    {
        Order order = orderHandler.generateOrder(2);

        assertNotNull(order);
        assertEquals(3, order.getFulfillOrderAmount());
        assertEquals(30, order.getOrderValue());
        assertEquals(2, order.getQuestionDifficulty());

        assertNotNull(order.getOrderType());
    }


    /**
     * Tests generateOrder() with a difficulty greater than 2.
     * This should use the hard difficulty branch.
     */
    public void testGenerateOrderHighDifficulty()
    {
        Order order = orderHandler.generateOrder(3);

        assertNotNull(order);
        assertEquals(3, order.getFulfillOrderAmount());
        assertEquals(30, order.getOrderValue());
        assertEquals(3, order.getQuestionDifficulty());
    }


    /**
     * Tests generateOrder() with a negative difficulty.
     * This should use the easy difficulty branch.
     */
    public void testGenerateOrderNegativeDifficulty()
    {
        Order order = orderHandler.generateOrder(-1);

        assertNotNull(order);
        assertEquals(1, order.getFulfillOrderAmount());
        assertEquals(10, order.getOrderValue());
        assertEquals(-1, order.getQuestionDifficulty());
    }


    /**
     * Tests setting the subject to Math and getting a question.
     */
    public void testMathEasyQuestion()
    {
        orderHandler.setSubject("Math");

        Order order = orderHandler.generateOrder(0);
        orderHandler.nextQuestion();

        assertNotNull(order);
        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());

        assertTrue(
            orderHandler.getCurrentQuestion().startsWith("What")
                || orderHandler.getCurrentQuestion().startsWith("Solve")
                || orderHandler.getCurrentQuestion().startsWith("Simplify")
                || orderHandler.getCurrentQuestion().startsWith("Convert"));
    }


    /**
     * Tests the Math medium question branch.
     */
    public void testMathMediumQuestion()
    {
        orderHandler.setSubject("Math");

        orderHandler.generateOrder(1);
        orderHandler.nextQuestion();

        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());
    }


    /**
     * Tests the Math hard question branch.
     */
    public void testMathHardQuestion()
    {
        orderHandler.setSubject("Math");

        orderHandler.generateOrder(2);
        orderHandler.nextQuestion();

        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());
    }


    /**
     * Tests setting the subject to Science.
     */
    public void testScienceQuestion()
    {
        orderHandler.setSubject("Science");

        orderHandler.generateOrder(0);
        orderHandler.nextQuestion();

        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());
    }


    /**
     * Tests Science medium questions.
     */
    public void testScienceMediumQuestion()
    {
        orderHandler.setSubject("Science");

        orderHandler.generateOrder(1);
        orderHandler.nextQuestion();

        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());
    }


    /**
     * Tests Science hard questions.
     */
    public void testScienceHardQuestion()
    {
        orderHandler.setSubject("Science");

        orderHandler.generateOrder(2);
        orderHandler.nextQuestion();

        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());
    }


    /**
     * Tests setting the subject to English.
     */
    public void testEnglishQuestion()
    {
        orderHandler.setSubject("English");

        orderHandler.generateOrder(0);
        orderHandler.nextQuestion();

        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());
    }


    /**
     * Tests English medium questions.
     */
    public void testEnglishMediumQuestion()
    {
        orderHandler.setSubject("English");

        orderHandler.generateOrder(1);
        orderHandler.nextQuestion();

        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());
    }


    /**
     * Tests English hard questions.
     */
    public void testEnglishHardQuestion()
    {
        orderHandler.setSubject("English");

        orderHandler.generateOrder(2);
        orderHandler.nextQuestion();

        assertNotNull(orderHandler.getCurrentQuestion());
        assertNotNull(orderHandler.getCurrentQuestionAnswer());
    }


    /**
     * Tests getCurrentQuestion() after nextQuestion().
     */
    public void testGetCurrentQuestion()
    {
        orderHandler.setSubject("Math");
        orderHandler.generateOrder(0);
        orderHandler.nextQuestion();

        String question = orderHandler.getCurrentQuestion();

        assertNotNull(question);
        assertTrue(question.length() > 0);
    }


    /**
     * Tests getCurrentQuestionAnswer() after nextQuestion().
     */
    public void testGetCurrentQuestionAnswer()
    {
        orderHandler.setSubject("Math");
        orderHandler.generateOrder(0);
        orderHandler.nextQuestion();

        String answer = orderHandler.getCurrentQuestionAnswer();

        assertNotNull(answer);
        assertTrue(answer.length() > 0);
    }


    /**
     * Tests changing the subject.
     */
    public void testSetSubject()
    {
        orderHandler.setSubject("Math");

        orderHandler.generateOrder(0);
        orderHandler.nextQuestion();

        String mathQuestion =
            orderHandler.getCurrentQuestion();

        assertNotNull(mathQuestion);

        orderHandler.setSubject("Science");

        orderHandler.generateOrder(0);
        orderHandler.nextQuestion();

        String scienceQuestion =
            orderHandler.getCurrentQuestion();

        assertNotNull(scienceQuestion);
    }
}