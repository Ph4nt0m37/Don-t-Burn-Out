package project1;
import java.util.*;

public class Order
{
    private String orderType;
    private long orderTime;
    private int fulfillOrderAmount;
    private int orderValue;
    private int questionDifficulty;

    public Order(String orderType, long orderTime, int fulfillOrderAmount, int orderValue, int questionDifficulty) {
        this.orderType = orderType;
        this.orderTime = orderTime;
        this.fulfillOrderAmount = fulfillOrderAmount;
        this.orderValue = orderValue;
        this.questionDifficulty = questionDifficulty;
    }

    public String getOrderType() {
        return orderType;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public int getFulfillOrderAmount() {
        return fulfillOrderAmount;
    }
    
    public void setFulfillOrderAmount(int amount) {
        this.fulfillOrderAmount = amount;
    }

    public int getOrderValue() {
        return orderValue;
    }
    
    public int getQuestionDifficulty() {
        return questionDifficulty;
    }
}