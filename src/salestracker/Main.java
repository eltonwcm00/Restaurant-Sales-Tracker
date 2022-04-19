package salestracker;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Main {
    public static void main(String[] args) {
        GUIController gObj = new GUIController();

        gObj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gObj.setSize(990,800);
        gObj.setVisible(true);
        gObj.setResizable(false);
        gObj.setBackground(new Color(255,255,255));

        JOptionPane.showMessageDialog(null,
                "Welcome to Elton Restaurant" +
                        "\n============================\n" +
                        "*Please take note that : \n" +
                        "1. The discount code for 10% off is OFF10 \n" +
                        "2. The discount code for 20% off is OFF20 \n" +
                        "3. Food&Drink is a type of discount code that is only available at the moment \n" +
                        "4. Discount amount can only be chosen once the type of discount is specified \n" +
                        "5. Please click the button 'Apply' to redeem the voucher before click 'Checkout' button ",
                "Notice", JOptionPane.INFORMATION_MESSAGE);


    }
}