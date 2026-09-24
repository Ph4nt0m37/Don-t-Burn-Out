package project1;

import student.TestCase;

/**
 * Tests ShopHandler.
 */
public class ShopHandlerTest extends TestCase
{
    private User user;
    private ShopHandler shop;
    private Equipment oven;

    /**
     * Sets up each test.
     */
    public void setUp()
    {
        user = new User();
        user.setMoney(500);

        shop = new ShopHandler(user);

        oven = new Equipment(
            200,
            "Orders give more money");
    }

    /**
     * Tests a successful purchase.
     */
    public void testPurchaseItem()
    {
        shop.purchaseItem(oven);

        assertEquals(300, user.getMoney());
        assertTrue(shop.hasEquipment(oven));
        assertEquals(1, shop.getEquipmentCount());
    }

    /**
     * Tests when the user cannot afford an item.
     */
    public void testPurchaseItemNotEnoughMoney()
    {
        user.setMoney(100);

        shop.purchaseItem(oven);

        assertEquals(100, user.getMoney());
        assertFalse(shop.hasEquipment(oven));
        assertEquals(0, shop.getEquipmentCount());
    }

    /**
     * Tests purchasing null.
     */
    public void testPurchaseNull()
    {
        shop.purchaseItem(null);

        assertEquals(500, user.getMoney());
        assertEquals(0, shop.getEquipmentCount());
    }
}
