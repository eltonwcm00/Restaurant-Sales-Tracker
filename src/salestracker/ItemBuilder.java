package salestracker;

public class ItemBuilder implements ItemImplement {

        String[] foodName = new String[] {"Spicy Nasi Lemak", "Kampung Mi Goreng", "Roti Canai", "Roti Planta"};
        Double[] foodPrice = new Double[] {5.50, 3.30, 4.50, 9.0};
        String[] drinkName = new String[] {"Sirup Bandung", "Teh Ais", "Kopi Cham"};
        Double[] drinkPrice= new Double[] {5.20, 2.20, 1.20};

        public ItemBuilder foodName (String[] foodNameArr) {
            this.foodName = foodNameArr;
            return this;
        }

        public ItemBuilder foodPrice (Double[] foodPriceArr) {
            this.foodPrice = foodPriceArr;
            return this;
        }

        public ItemBuilder drinkName (String[] drinkNameArr) {
            this.drinkName = drinkNameArr;
            return this;
        }

        public ItemBuilder drinkPrice (Double[] drinkPriceArr) {
            this.drinkPrice = drinkPriceArr;
            return this;
        }

        public Item buildItem() {
            return new Item(this);
        }
}
