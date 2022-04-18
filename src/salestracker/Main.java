package salestracker;

class Main {

    public static void main(String[] args)
    {
        new GUI();

        Item itemObRead = new ItemBuilder().buildItem();

        new ItemBuilder().foodName(itemObRead.getFoodName()).foodPrice(itemObRead.getFoodPrice()).buildItem();
        new ItemBuilder().drinkName(itemObRead.getDrinkName()).drinkPrice(itemObRead.getDrinkPrice()).buildItem();

        System.out.println(itemObRead+"\n");

        for(int x=0; x<itemObRead.getFoodName().length; x++) {
            System.out.println(itemObRead.getFoodName()[x]);
        }

        for(int x = 0; x<itemObRead.getFoodPrice().length; x++) {
            System.out.println(itemObRead.getFoodPrice()[x]);
        }

        for(int x=0; x<itemObRead.getDrinkName().length; x++) {
            System.out.println(itemObRead.getDrinkName()[x]);
        }

        for(int x = 0; x<itemObRead.getDrinkPrice().length; x++) {
            System.out.println(itemObRead.getDrinkPrice()[x]);
        }
    }
}