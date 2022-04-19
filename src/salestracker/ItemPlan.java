package salestracker;

import javax.swing.*;

public interface ItemPlan {
    public ItemPlan foodImg (ImageIcon[] foodImgArr);
    public ItemPlan foodName (String[] foodNameArr);
    public ItemPlan foodPrice (Double[] foodPriceArr);
    public ItemPlan drinkImg (ImageIcon[] drinkImgArr);
    public ItemPlan drinkName (String[] drinkNameArr);
    public ItemPlan drinkPrice (Double[] drinkPriceArr);
    public ItemPlan discountAmount (Double[] discountAmountArr);
    public ItemPlan discountType (String[] discountTypeArr);
    public ItemPlan discountCode (String[] discountCodeArr);
    public ItemPlan discountCodeDesc (String[] discountCodeDescArr);
    public Item buildItem();
}
