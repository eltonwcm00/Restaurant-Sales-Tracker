package salestracker;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Main {

    public static void main(String[] args) {

        GUI gObj = new GUI();

        gObj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gObj.setSize(990,800);
        gObj.setVisible(true);
        gObj.setResizable(false);
        gObj.setBackground(new Color(255,255,255));
    }
}