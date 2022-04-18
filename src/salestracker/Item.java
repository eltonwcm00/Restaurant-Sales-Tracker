package salestracker;

import java.util.Arrays;
import javax.swing.*;

public class Item {

    ImageIcon[] foodImg;
    ImageIcon[] drinkImg;
    private final String[] foodName;
    private final String[] drinkName;
    private final Double[] foodPrice;
    private final Double[] drinkPrice;

    public Item(ItemBuilder itemBuilder) {
        this.foodImg = itemBuilder.foodImg;
        this.foodName = itemBuilder.foodName;
        this.foodPrice = itemBuilder.foodPrice;
        this.drinkImg = itemBuilder.drinkImg;
        this.drinkName = itemBuilder.drinkName;
        this.drinkPrice = itemBuilder.drinkPrice;
    }

    public ImageIcon[] getFoodImg() {
        return foodImg;
    }

    public ImageIcon[] getDrinkImg() {
        return drinkImg;
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
        return Arrays.toString(foodImg) + Arrays.toString(foodName) + Arrays.toString(foodPrice) + Arrays.toString(drinkImg) + Arrays.toString(drinkName) + Arrays.toString(drinkPrice);
    }
}