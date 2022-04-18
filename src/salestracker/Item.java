package salestracker;

import java.util.Arrays;

public class Item {

    private final String[] foodName;
    private final String[] drinkName;
    private final Double[] foodPrice;
    private final Double[] drinkPrice;

    public Item(ItemBuilder itemBuilder) {
        this.foodName = itemBuilder.foodName;
        this.foodPrice = itemBuilder.foodPrice;
        this.drinkName = itemBuilder.drinkName;
        this.drinkPrice = itemBuilder.drinkPrice;
    }

    public String[] getFoodName() {
        return foodName;
    }

    public String[] getDrinkName() {
        return drinkName;
    }

    public Double[] getFoodPrice() {
        return foodPrice;
    }

    public Double[] getDrinkPrice() {
        return drinkPrice;
    }

    @Override
    public String toString() {
        return Arrays.toString(foodName) + Arrays.toString(foodPrice) + Arrays.toString(drinkName) + Arrays.toString(drinkPrice);
    }
}