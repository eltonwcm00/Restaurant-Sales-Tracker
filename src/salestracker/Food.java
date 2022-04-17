package salestracker;

import java.util.Arrays;

public class Food {

    private String[] foodName;
    private Double[] foodPrice;

    private Food(FoodBuilder foodBuild) {
        this.foodName = foodBuild.foodName;
        this.foodPrice = foodBuild.foodPrice;
    }

    public String[] getFoodName() {
        return foodName;
    }
    public Double[] getLastName() {
        return foodPrice;
    }

    @Override
    public String toString() {
        return Arrays.toString(foodName) + Arrays.toString(foodPrice);
    }

    public static class FoodBuilder {

        private String[] foodName = new String[] {"Spicy Nasi Lemak", "Kampung Mi Goreng", "Roti Canai", "Roti Planta"};
        private Double[] foodPrice = new Double[] {5.50, 3.30, 4.50, 9.0};

        public FoodBuilder foodName (String[] foodNameArr) {
            this.foodName = foodNameArr;
            return this;
        }

        public FoodBuilder foodPrice (Double[] foodPriceArr) {
            this.foodPrice = foodPriceArr;
            return this;
        }

        public Food buildFood() {
            Food foodObj =  new Food(this);
            return foodObj;
        }
    }

    public static void main(String[] args)
    {

        Food foodObRead = new FoodBuilder().buildFood();
        Food foodOb = new FoodBuilder().foodName(foodObRead.getFoodName()).foodPrice(foodObRead.getLastName()).buildFood();

        System.out.println(foodOb+"\n");

        for(int x=0; x<foodOb.getFoodName().length; x++) {
            System.out.println(foodOb.getFoodName()[x]);
        }

        for(int x=0; x<foodOb.getLastName().length; x++) {
            System.out.println(foodOb.getLastName()[x]);
        }
    }

}