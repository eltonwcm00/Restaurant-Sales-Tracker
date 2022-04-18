package salestracker;

public interface ItemImplement {

    public ItemImplement foodName (String[] foodNameArr);
    public ItemImplement foodPrice (Double[] foodPriceArr);
    public ItemImplement drinkName (String[] drinkNameArr);
    public ItemImplement drinkPrice (Double[] drinkPriceArr);
    public Item buildItem();
}
