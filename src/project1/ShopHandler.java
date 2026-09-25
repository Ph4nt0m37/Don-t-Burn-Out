package project1;

import java.util.ArrayList;

public class ShopHandler
{
    private Equipment userEquipment = Equipment.STOVE100;
    private User user;

    public ShopHandler(User user)
    {
        this.user = user;
    }

    public boolean purchaseItem(Equipment equipment)
    {
        if (equipment != null
            && user.getMoney() >= equipment.getValue())
        {
            user.setMoney(user.getMoney() - equipment.getValue());
            userEquipment = equipment;
            return true;
        }else {
            return false;
        }
    }

    public Equipment getUserEquipment()
    {
        return userEquipment;
    }
    
    public void printShop() {
        Equipment nextEquipment = Equipment.equipmentOrder.get(Equipment.equipmentOrder.indexOf(getUserEquipment()) + 1);
        
        System.out.println("Current equipment: "+userEquipment.toString());
        System.out.println("Next Equipment: "+nextEquipment.toString()+" - "+nextEquipment.getPerkDescription());
        System.out.println("Price: $"+nextEquipment.getValue());
        System.out.println("Your Money: $"+user.getMoney());
        
        boolean purchasedEquipment = InputHandler.getUserBoolInput("Would you like to purchase this equipment? (Y/N) ","That is not a valid option!");
        if (purchasedEquipment) {
            if (purchaseItem(nextEquipment)) {
                System.out.println("Successfully purchased "+nextEquipment.toString()+"!");
            }else {
                System.out.println("You do not have enough money to purchase this item!\nPlease try again when you have enough money.");
            }
        }
    }
}
