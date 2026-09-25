package project1;

import java.util.*;

/**
 * Represents a customer order in the Don't Burn Out game.
 * <p>
 * An order contains information about the type of order, the amount of time
 * available to complete it, the number of questions required to fulfill it, the
 * amount of money it is worth, and the difficulty of the questions associated
 * with it.
 * </p>
 * 
 * @author Rohan Sampath
 */
public class Order
{
    /**
     * The type of food or order requested by the customer.
     */
    private String orderType;

    /**
     * The amount of time, in seconds, allowed to complete the order.
     */
    private long orderTime;

    /**
     * The number of questions that must be answered correctly to fulfill the
     * order.
     */
    private int fulfillOrderAmount;

    /**
     * The amount of money earned for completing the order.
     */
    private int orderValue;

    /**
     * The difficulty level of the questions associated with the order.
     */
    private int questionDifficulty;

    /**
     * Creates a new order with the specified properties.
     *
     * @param orderType
     *            the type of order requested by the customer
     * @param orderTime
     *            the amount of time, in seconds, allowed to complete the order
     * @param fulfillOrderAmount
     *            the number of questions that must be answered correctly to
     *            fulfill the order
     * @param orderValue
     *            the amount of money earned for completing the order
     * @param questionDifficulty
     *            the difficulty level of the questions associated with the
     *            order
     */
    public Order(
        String orderType,
        long orderTime,
        int fulfillOrderAmount,
        int orderValue,
        int questionDifficulty)
    {
        this.orderType = orderType;
        this.orderTime = orderTime;
        this.fulfillOrderAmount = fulfillOrderAmount;
        this.orderValue = orderValue;
        this.questionDifficulty = questionDifficulty;
    }


    /**
     * Gets the type of order requested by the customer.
     *
     * @return the order type
     */
    public String getOrderType()
    {
        return orderType;
    }


    /**
     * Gets the amount of time allowed to complete the order.
     *
     * @return the order time in seconds
     */
    public long getOrderTime()
    {
        return orderTime;
    }


    /**
     * Gets the number of questions remaining to fulfill the order.
     *
     * @return the number of questions required to fulfill the order
     */
    public int getFulfillOrderAmount()
    {
        return fulfillOrderAmount;
    }


    /**
     * Sets the number of questions remaining to fulfill the order.
     *
     * @param amount
     *            the new number of questions required to fulfill the order
     */
    public void setFulfillOrderAmount(int amount)
    {
        this.fulfillOrderAmount = amount;
    }


    /**
     * Gets the monetary value of the order.
     *
     * @return the amount of money earned for completing the order
     */
    public int getOrderValue()
    {
        return orderValue;
    }


    /**
     * Gets the difficulty level of the questions associated with the order.
     *
     * @return the question difficulty level
     */
    public int getQuestionDifficulty()
    {
        return questionDifficulty;
    }
}
