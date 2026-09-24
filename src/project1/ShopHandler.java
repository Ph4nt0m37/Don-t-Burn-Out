package project1;

import java.util.ArrayList;

public class ShopHandler
{
    private ArrayList<Equipment> userEquipment;
    private User user;

    public ShopHandler(User user)
    {
        this.user = user;
        userEquipment = new ArrayList<Equipment>();
    }

    public void purchaseItem(Equipment equipment)
    {
        if (equipment != null
            && user.getMoney() >= equipment.getValue())
        {
            user.setMoney(user.getMoney() - equipment.getValue());
            userEquipment.add(equipment);
        }
    }

    public boolean hasEquipment(Equipment equipment)
    {
        return userEquipment.contains(equipment);
    }

    public int getEquipmentCount()
    {
        return userEquipment.size();
    }

    public ArrayList<Equipment> getUserEquipment()
    {
        return userEquipment;
    }
}
