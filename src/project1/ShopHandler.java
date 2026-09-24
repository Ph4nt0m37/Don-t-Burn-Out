package project1;
public class ShopHandler
{
    package project1;

    import java.util.ArrayList;

    /**
     * Handles purchasing equipment from the shop.
     * Keeps track of the equipment owned by the user.
     *
     * @author Isabella Zhang
     * @version 2026.09.24
     */
    public class ShopHandler
    {
        private ArrayList<Equipment> userEquipment;
        private User user;


        /**
         * Creates a new ShopHandler for the given user.
         *
         * @param user
         *     the user who is using the shop
         */
        public ShopHandler(User user)
        {
            this.user = user;
            userEquipment = new ArrayList<Equipment>();
        }


        /**
         * Purchases an equipment item if the user has enough money.
         *
         * @param equipment
         *     the equipment the user wants to purchase
         */
        public void purchaseItem(Equipment equipment)
        {
            if (equipment != null
                && user.getMoney() >= equipment.getValue())
            {
                user.setMoney(user.getMoney() - equipment.getValue());
                userEquipment.add(equipment);
            }
        }


        /**
         * Returns whether the user owns a certain equipment item.
         *
         * @param equipment
         *     the equipment to check
         * @return true if the user owns the equipment
         */
        public boolean hasEquipment(Equipment equipment)
        {
            return userEquipment.contains(equipment);
        }


        /**
         * Returns the number of equipment items the user owns.
         *
         * @return number of equipment items
         */
        public int getEquipmentCount()
        {
            return userEquipment.size();
        }


        /**
         * Returns the user's equipment.
         *
         * @return list of equipment owned by the user
         */
        public ArrayList<Equipment> getUserEquipment()
        {
            return userEquipment;
        }
    }


}
