package salestracker;

import javax.swing.*;

public class ItemBuilder implements ItemPlan {

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
        String[] foodName = new String[] {"Spicy Nasi Lemak", "Kampung Mi Goreng", "Roti Canaiiii"};
        Double[] foodPrice = new Double[] {5.50, 3.30, 4.70, 9.0};
        String[] drinkName = new String[] {"Sirup Bandung", "Teh Ais", "Kopi Cham"};
        Double[] drinkPrice= new Double[] {5.20, 2.10, 1.90};
        Double[] discountAmt = new Double[] {0.9, 0.8};
        String[] discountAmtDesc = new String[] {"10%", "20%"};
        String[] discountType =  new String[] {"Food & Drink", "Food", "Drink"};
        String[] discountCode = new String[] {"OFF10", "OFF20"};

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

        public ItemBuilder discountAmount (Double[] discountAmountArr) {
            this.discountAmt = discountAmountArr;
            return this;
        }

        public ItemBuilder discountType (String[] discountTypeArr) {
            this.discountType = discountTypeArr;
            return this;
        }

        public ItemBuilder discountCode (String[] discountCodeArr) {
            this.discountCode = discountCodeArr;
            return this;
        }

        public ItemBuilder discountCodeDesc (String[] discountCodeDescArr) {
            this.discountAmtDesc = discountCodeDescArr;
            return this;
        }

        public Item buildItem() {
            return new Item(this);
        }
}
