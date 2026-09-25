package project1.Tests;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import project1.*;
import student.TestCase;

public class ShopHandlerTest
    extends TestCase
{
    private User user;
    private ShopHandler shopHandler;

    public void setUp()
    {
        user = new User("Test User");
        shopHandler = new ShopHandler(user);
    }


    public void testInitialEquipment()
    {
        assertEquals(Equipment.STOVE100, shopHandler.getUserEquipment());
    }


    public void testPurchaseItem()
    {
        user.setMoney(1000);

        boolean result = shopHandler.purchaseItem(Equipment.STOVE250);

        assertTrue(result);
        assertEquals(Equipment.STOVE250, shopHandler.getUserEquipment());

        assertEquals(900, user.getMoney());
    }


    public void testPurchaseItemWithExactMoney()
    {
        user.setMoney(100);

        boolean result = shopHandler.purchaseItem(Equipment.STOVE250);

        assertTrue(result);
        assertEquals(Equipment.STOVE250, shopHandler.getUserEquipment());

        assertEquals(0, user.getMoney());
    }


    public void testPurchaseItemNotEnoughMoney()
    {
        user.setMoney(50);

        boolean result = shopHandler.purchaseItem(Equipment.STOVE250);

        assertFalse(result);

        // Equipment should not change
        assertEquals(Equipment.STOVE100, shopHandler.getUserEquipment());

        // Money should not change
        assertEquals(50, user.getMoney());
    }


    public void testPurchaseNullItem()
    {
        user.setMoney(1000);

        boolean result = shopHandler.purchaseItem(null);

        assertFalse(result);

        assertEquals(Equipment.STOVE100, shopHandler.getUserEquipment());

        assertEquals(1000, user.getMoney());
    }


    public void testPurchaseMultipleItems()
    {
        user.setMoney(2000);

        boolean firstPurchase = shopHandler.purchaseItem(Equipment.STOVE250);

        assertTrue(firstPurchase);
        assertEquals(Equipment.STOVE250, shopHandler.getUserEquipment());
        assertEquals(1900, user.getMoney());

        boolean secondPurchase = shopHandler.purchaseItem(Equipment.STOVE500);

        assertTrue(secondPurchase);
        assertEquals(Equipment.STOVE500, shopHandler.getUserEquipment());
        assertEquals(1650, user.getMoney());
    }


    public void testPurchaseStove750()
    {
        user.setMoney(500);

        boolean result = shopHandler.purchaseItem(Equipment.STOVE750);

        assertTrue(result);
        assertEquals(Equipment.STOVE750, shopHandler.getUserEquipment());
        assertEquals(0, user.getMoney());
    }


    public void testPurchaseStove1000()
    {
        user.setMoney(750);

        boolean result = shopHandler.purchaseItem(Equipment.STOVE1000);

        assertTrue(result);
        assertEquals(Equipment.STOVE1000, shopHandler.getUserEquipment());
        assertEquals(0, user.getMoney());
    }


    public void testPurchaseTooExpensiveStove1000()
    {
        user.setMoney(749);

        boolean result = shopHandler.purchaseItem(Equipment.STOVE1000);

        assertFalse(result);

        assertEquals(Equipment.STOVE100, shopHandler.getUserEquipment());

        assertEquals(749, user.getMoney());
    }


    public void testPrintShopPurchase()
    {
        // Set current equipment to STOVE250 so that
        // equipmentOrder.indexOf(...) + 1 is valid.
        user.setMoney(250);
        shopHandler.purchaseItem(Equipment.STOVE500);

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream("Y\n".getBytes()));

        shopHandler.printShop();

        assertEquals(Equipment.STOVE500, shopHandler.getUserEquipment());

        assertEquals(0, user.getMoney());
    }


    public void testPrintShopDeclinePurchase()
    {
        user.setMoney(250);
        shopHandler.purchaseItem(Equipment.STOVE250);

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream("N\n".getBytes()));

        shopHandler.printShop();

        // Equipment should remain the same
        assertEquals(Equipment.STOVE250, shopHandler.getUserEquipment());

        // Money should remain the same
        assertEquals(150, user.getMoney());
    }


    public void testPrintShopInvalidThenPurchase()
    {
        user.setMoney(250);
        shopHandler.purchaseItem(Equipment.STOVE500);

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream("Maybe\nY\n".getBytes()));

        shopHandler.printShop();

        assertEquals(Equipment.STOVE500, shopHandler.getUserEquipment());

        assertEquals(0, user.getMoney());
    }


    public void testPrintShopInvalidThenDecline()
    {
        user.setMoney(250);
        shopHandler.purchaseItem(Equipment.STOVE250);

        InputHandler.scanner =
            new Scanner(new ByteArrayInputStream("Maybe\nN\n".getBytes()));

        shopHandler.printShop();

        assertEquals(Equipment.STOVE250, shopHandler.getUserEquipment());

        assertEquals(150, user.getMoney());
    }
}
