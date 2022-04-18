package salestracker;

import javax.swing.*;

public class ItemBuilder implements ItemImplement {

        ImageIcon[] foodImg = {
            new ImageIcon(getClass().getResource("../foodImg/nasi_lemak.png")),
            new ImageIcon(getClass().getResource("../foodImg/mi_goreng.png")),
            new ImageIcon(getClass().getResource("../foodImg/roti_canai.png")),
         };
        ImageIcon[] drinkImg= {
                new ImageIcon(getClass().getResource("../drinkImg/sirup.png")),
                new ImageIcon(getClass().getResource("../drinkImg/teh-ais.png")),
                new ImageIcon(getClass().getResource("../drinkImg/milo-ais.png")),
        };
        String[] foodName = new String[] {"Spicy Nasi Lemak", "Kampung Mi Goreng", "Roti Canai"};
        Double[] foodPrice = new Double[] {5.50, 3.30, 4.50, 9.0};
        String[] drinkName = new String[] {"Sirup Bandung", "Teh Aissie", "Kopi Cham"};
        Double[] drinkPrice= new Double[] {5.20, 2.20, 1.20};

        public ItemBuilder foodImg (ImageIcon[] foodImgArr) {
            this.foodImg = foodImgArr;
            return this;
        }

        public ItemBuilder foodName (String[] foodNameArr) {
            this.foodName = foodNameArr;
            return this;
        }

        public ItemBuilder foodPrice (Double[] foodPriceArr) {
            this.foodPrice = foodPriceArr;
            return this;
        }

        public ItemBuilder drinkImg (ImageIcon[] drinkImgArr) {
            this.drinkImg = drinkImgArr;
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
