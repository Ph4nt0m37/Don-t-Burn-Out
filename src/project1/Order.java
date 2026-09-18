package project1;
package java.uti.*;

public class Order
{
    private String orderType;
    private long orderTime;
    private int fulfillOrderAmount;
    private int orderValue;

    public Order(String orderType, long orderTime, int fulfillOrderAmount, int orderValue) {
        this.orderType = orderType;
        this.orderTime = orderTime;
        this.fulfillOrderAmount = fulfillOrderAmount;
        this.orderValue = orderValue;
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

    public int getOrderValue() {
        return orderValue;
    }
}