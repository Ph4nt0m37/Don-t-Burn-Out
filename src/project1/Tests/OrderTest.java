package project1.Tests;
import project1.Order;
import student.TestCase;

public class OrderTest
    extends TestCase
{
    private Order order;

    /**
     * Sets up an Order before each test.
     */
    public void setUp()
    {
        order = new Order("pizza", 60L, 3, 25, 1);
    }


    /**
     * Tests getting the order type.
     */
    public void testGetOrderType()
    {
        assertEquals("pizza", order.getOrderType());
    }


    /**
     * Tests getting the order time.
     */
    public void testGetOrderTime()
    {
        assertEquals(60L, order.getOrderTime());
    }


    /**
     * Tests getting the amount needed to fulfill the order.
     */
    public void testGetFulfillOrderAmount()
    {
        assertEquals(3, order.getFulfillOrderAmount());
    }


    /**
     * Tests setting the amount needed to fulfill the order.
     */
    public void testSetFulfillOrderAmount()
    {
        order.setFulfillOrderAmount(1);

        assertEquals(1, order.getFulfillOrderAmount());
    }


    /**
     * Tests getting the order value.
     */
    public void testGetOrderValue()
    {
        assertEquals(25, order.getOrderValue());
    }


    /**
     * Tests getting the question difficulty.
     */
    public void testGetQuestionDifficulty()
    {
        assertEquals(1, order.getQuestionDifficulty());
    }
}
