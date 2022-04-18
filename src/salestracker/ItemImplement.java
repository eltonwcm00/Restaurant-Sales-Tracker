package salestracker;

import javax.swing.*;

public interface ItemImplement {

    public ItemImplement foodImg (ImageIcon[] foodImgArr);
    public ItemImplement foodName (String[] foodNameArr);
    public ItemImplement foodPrice (Double[] foodPriceArr);
    public ItemImplement drinkImg (ImageIcon[] drinkImgArr);
    public ItemImplement drinkName (String[] drinkNameArr);
    public ItemImplement drinkPrice (Double[] drinkPriceArr);
    public Item buildItem();
}
