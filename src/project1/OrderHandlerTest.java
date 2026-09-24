package project1;
import student.TestCase;

public class OrderHandlerTest extends TestCase
{
    private OrderHandler handler;

    /**
     * Sets up an OrderHandler before each test.
     */
    public void setUp() {
        handler = new OrderHandler();
    }

    /**
     * Tests that an easy order is generated correctly.
     */
    public void testGenerateOrderEasy() {
        Order order = handler.generateOrder(0);

        assertNotNull(order);
        assertEquals(0, order.getQuestionDifficulty());
        assertEquals(60, order.getOrderTime());
        assertEquals(1, order.getFulfillOrderAmount());
        assertEquals(10, order.getOrderValue());
    }

    /**
     * Tests that a medium order is generated correctly.
     */
    public void testGenerateOrderMedium() {
        Order order = handler.generateOrder(1);

        assertNotNull(order);
        assertEquals(1, order.getQuestionDifficulty());
        assertEquals(45, order.getOrderTime());
        assertEquals(2, order.getFulfillOrderAmount());
        assertEquals(20, order.getOrderValue());
    }

    /**
     * Tests that a hard order is generated correctly.
     */
    public void testGenerateOrderHard() {
        Order order = handler.generateOrder(2);

        assertNotNull(order);
        assertEquals(2, order.getQuestionDifficulty());
        assertEquals(30, order.getOrderTime());
        assertEquals(3, order.getFulfillOrderAmount());
        assertEquals(30, order.getOrderValue());
    }

    /**
     * Tests that difficulty values greater than 2 use hard settings.
     */
    public void testGenerateOrderHighDifficulty() {
        Order order = handler.generateOrder(5);

        assertNotNull(order);
        assertEquals(5, order.getQuestionDifficulty());
        assertEquals(30, order.getOrderTime());
        assertEquals(3, order.getFulfillOrderAmount());
        assertEquals(30, order.getOrderValue());
    }

    /**
     * Tests setting the subject.
     */
    public void testSetSubject() {
        handler.setSubject("Math");

        handler.generateOrder(0);
        handler.nextQuestion();

        assertNotNull(handler.getCurrentQuestion());
        assertNotNull(handler.getCurrentQuestionAnswer());
    }

    /**
     * Tests that a Math question and answer are selected.
     */
    public void testNextQuestionMath() {
        handler.setSubject("Math");
        handler.generateOrder(0);
        handler.nextQuestion();

        assertNotNull(handler.getCurrentQuestion());
        assertNotNull(handler.getCurrentQuestionAnswer());
    }

    /**
     * Tests that a Science question and answer are selected.
     */
    public void testNextQuestionScience() {
        handler.setSubject("Science");
        handler.generateOrder(1);
        handler.nextQuestion();

        assertNotNull(handler.getCurrentQuestion());
        assertNotNull(handler.getCurrentQuestionAnswer());
    }

    /**
     * Tests that an English question and answer are selected.
     */
    public void testNextQuestionEnglish() {
        handler.setSubject("English");
        handler.generateOrder(2);
        handler.nextQuestion();

        assertNotNull(handler.getCurrentQuestion());
        assertNotNull(handler.getCurrentQuestionAnswer());
    }

    /**
     * Tests that the question changes or is valid when nextQuestion is called.
     */
    public void testNextQuestion() {
        handler.setSubject("Math");
        handler.generateOrder(0);

        handler.nextQuestion();

        assertNotNull(handler.getCurrentQuestion());
        assertNotNull(handler.getCurrentQuestionAnswer());
        assertTrue(handler.getCurrentQuestion().length() > 0);
        assertTrue(handler.getCurrentQuestionAnswer().length() > 0);
    }

    /**
     * Tests capitalization of the subject.
     */
    public void testSetSubjectIgnoreCase() {
        handler.setSubject("mAtH");
        handler.generateOrder(0);
        handler.nextQuestion();

        assertNotNull(handler.getCurrentQuestion());
        assertNotNull(handler.getCurrentQuestionAnswer());
    }

    /**
     * Tests that the current question is returned.
     */
    public void testGetCurrentQuestion() {
        handler.setSubject("Math");
        handler.generateOrder(0);
        handler.nextQuestion();

        assertNotNull(handler.getCurrentQuestion());
    }
    
    /**
     * Tests that the current question answer is returned.
     */
    public void testGetCurrentQuestionAnswer() {
        handler.setSubject("Math");
        handler.generateOrder(0);
        handler.nextQuestion();

        assertNotNull(handler.getCurrentQuestionAnswer());
    }
}
