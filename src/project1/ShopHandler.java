package project1;

import java.util.ArrayList;

/**
 * Handles the player's equipment purchases and displays available equipment
 * upgrades in the Don't Burn Out shop.
 * <p>
 * The ShopHandler keeps track of the equipment currently owned by the player
 * and allows the player to purchase equipment upgrades using money earned from
 * completing orders.
 * </p>
 * 
 * @author Isabella Zhang
 * @author Paulo Korowajczuk Nader
 */
public class ShopHandler
{
    /**
     * The equipment currently owned by the player.
     */
    private Equipment userEquipment = Equipment.STOVE100;

    /**
     * The player whose money is used to purchase equipment.
     */
    private User user;

    /**
     * Creates a new ShopHandler for the specified user.
     *
     * @param user
     *            the player whose equipment and money are managed
     */
    public ShopHandler(User user)
    {
        this.user = user;
    }


    /**
     * Attempts to purchase the specified equipment for the player.
     * <p>
     * The purchase is successful only if the equipment is not {@code null} and
     * the player has enough money to afford it. If the purchase is successful,
     * the equipment becomes the player's current equipment and the equipment's
     * cost is deducted from the player's money.
     * </p>
     *
     * @param equipment
     *            the equipment the player wants to purchase
     * @return {@code true} if the equipment was successfully purchased;
     *             {@code false} otherwise
     */
    public boolean purchaseItem(Equipment equipment)
    {
        if (equipment != null && user.getMoney() >= equipment.getValue())
        {
            user.setMoney(user.getMoney() - equipment.getValue());
            userEquipment = equipment;
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Gets the equipment currently owned by the player.
     *
     * @return the player's current equipment
     */
    public Equipment getUserEquipment()
    {
        return userEquipment;
    }


    /**
     * Displays the player's current equipment and the next available equipment
     * upgrade.
     * <p>
     * The player is shown the next equipment upgrade, its perk, price, and the
     * player's current amount of money. The player is then given the option to
     * purchase the displayed equipment.
     * </p>
     */
    public void printShop()
    {
        Equipment nextEquipment = Equipment.equipmentOrder
            .get(Equipment.equipmentOrder.indexOf(getUserEquipment()) + 1);

        System.out.println("Current equipment: " + userEquipment.toString());
        System.out.println(
            "Next Equipment: " + nextEquipment.toString() + " - "
                + nextEquipment.getPerkDescription());
        System.out.println("Price: $" + nextEquipment.getValue());
        System.out.println("Your Money: $" + user.getMoney());

        boolean purchasedEquipment = InputHandler.getUserBoolInput(
            "Would you like to purchase this equipment? (Y/N) ",
            "That is not a valid option!");

        if (purchasedEquipment)
        {
            if (purchaseItem(nextEquipment))
            {
                System.out.println(
                    "Successfully purchased " + nextEquipment.toString() + "!");
            }
            else
            {
                System.out.println(
                    "You do not have enough money to purchase this item!\n"
                        + "Please try again when you have enough money.");
            }
        }
    }
}
