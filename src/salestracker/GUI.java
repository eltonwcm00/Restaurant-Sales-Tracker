package salestracker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {

    GUI() {

        super("Restaurant Sales Performance Tracker");

        // GUI layout backbone
        JPanel welcomePanel = new JPanel();
        JPanel centerLeftPanel = new JPanel();
        JPanel centerCenterPanel = new JPanel();
        JPanel centerRightPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        welcomePanel.setBackground(Color.red);
        centerLeftPanel.setBackground(Color.blue);
        centerRightPanel.setBackground(Color.green);
        bottomPanel.setBackground(Color.yellow);
        centerCenterPanel.setBackground(Color.ORANGE);

        this.add(welcomePanel,BorderLayout.PAGE_START);
        this.add(centerLeftPanel, BorderLayout.LINE_START);
        this.add(centerCenterPanel, BorderLayout.CENTER);
        this.add(centerRightPanel, BorderLayout.LINE_END);
        this.add(bottomPanel, BorderLayout.PAGE_END);

        centerRightPanel.setPreferredSize(new Dimension(500, 300));
        this.add(centerCenterPanel, BorderLayout.CENTER);

        //Welcome panel
        JLabel welcomeText = new JLabel("Welcome to Elton Restaurant");
        welcomePanel.add(welcomeText);

        // Item list
        JPanel itemContainer = new JPanel();

        itemContainer.setLayout(new BoxLayout(itemContainer, BoxLayout.Y_AXIS));
        itemContainer.setBorder(BorderFactory.createEmptyBorder(0, 30, 0,100));

        String[] foodDesc = new String[] {"Spicy Nasi Lemak", "Kampung Mi Goreng", "Roti Canai"};
        Integer[] foodPrice = new Integer[] {30, 20, 80};

        ImageIcon[] foodImg = {
                new ImageIcon(getClass().getResource("../foodImg/nasi_lemak.png")),
                new ImageIcon(getClass().getResource("../foodImg/mi_goreng.png")),
                new ImageIcon(getClass().getResource("../foodImg/roti_canai.png")),
        };

        JLabel[] foodName = new JLabel[foodDesc.length];
        JLabel[] foodPricing = new JLabel[foodPrice.length];
        JLabel[] foodImgDisplay = new JLabel[foodImg.length];

        String[] drinkDesc = new String[] {"Sirup Bandung", "Teh Ais", "Kopi Cham"};
        Integer[] drinkPrice = new Integer[] {5, 3, 2};

        ImageIcon[] drinkImg= {
                new ImageIcon(getClass().getResource("../drinkImg/sirup.png")),
                new ImageIcon(getClass().getResource("../drinkImg/teh-ais.png")),
                new ImageIcon(getClass().getResource("../drinkImg/milo-ais.png")),
        };

        JLabel[] drinkName = new JLabel[drinkDesc.length];
        JLabel[] drinkPricing = new JLabel[drinkPrice.length];
        JLabel[] drinkImgDisplay = new JLabel[drinkImg.length];

        // Food
        for(int i=0; i< foodDesc.length; i++){

            foodName[i] = new JLabel(foodDesc[i]);
            foodImgDisplay[i] = new JLabel(foodImg[i]);
            foodPricing[i] = new JLabel("RM " + foodPrice[i]); //String.valueOf()

            foodName[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            foodName[i].setPreferredSize(new Dimension(250, 100));

            itemContainer.add(foodName[i]);
            itemContainer.add(foodImgDisplay[i]);
            itemContainer.add(foodPricing[i]);
            itemContainer.add(Box.createRigidArea(new Dimension(0,40)));
            centerLeftPanel.add(itemContainer);
        }

        // Drink
        for(int i=0; i< foodDesc.length; i++){

            drinkName[i] = new JLabel(drinkDesc[i]);
            drinkImgDisplay[i] = new JLabel(drinkImg[i]);
            drinkPricing[i] = new JLabel("RM " + drinkPrice[i]); //String.valueOf()

            drinkName[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            drinkName[i].setPreferredSize(new Dimension(250, 100));

            itemContainer.add(drinkName[i]);
            itemContainer.add(drinkImgDisplay[i]);
            itemContainer.add(drinkPricing[i]);
            itemContainer.add(Box.createRigidArea(new Dimension(0,40)));
            centerLeftPanel.add(itemContainer);
        }

        // Item Selection
        JPanel foodCheckBoxContainer = new JPanel();
        foodCheckBoxContainer.setLayout(new BoxLayout(foodCheckBoxContainer, BoxLayout.Y_AXIS));

        JCheckBox nasiLemakCheck = new JCheckBox();
        JCheckBox miGorengCheck = new JCheckBox();
        JCheckBox rotiCheck = new JCheckBox();
        JCheckBox sirupCheck = new JCheckBox();
        JCheckBox tehCheck = new JCheckBox();
        JCheckBox miloCheck = new JCheckBox();

        foodCheckBoxContainer.add(nasiLemakCheck);
        foodCheckBoxContainer .add(Box.createRigidArea(new Dimension(0,90)));
        foodCheckBoxContainer.add(miGorengCheck);
        foodCheckBoxContainer .add(Box.createRigidArea(new Dimension(0,100)));
        foodCheckBoxContainer.add(rotiCheck);
        foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));
        foodCheckBoxContainer.add(sirupCheck);
        foodCheckBoxContainer .add(Box.createRigidArea(new Dimension(0,100)));
        foodCheckBoxContainer.add(tehCheck);
        foodCheckBoxContainer .add(Box.createRigidArea(new Dimension(0,100)));
        foodCheckBoxContainer.add(miloCheck);

        centerCenterPanel.add(foodCheckBoxContainer);

        // Checkout and Discount code panel
        JButton checkoutBtn = new JButton("Proceed to Checkout");
        JLabel discountText = new JLabel("Please enter the coupon code (*if applicable):");
        JTextField discountInput = new JTextField(5);
        discountInput.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,100));

        bottomPanel.add(discountText);
        bottomPanel.add(discountInput);
        bottomPanel.add(checkoutBtn);

        // Cart panel
        JPanel cartContainer = new JPanel();
        JLabel cartHeader = new JLabel("<html><u>Cart</u></html>");
        cartHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));

        cartContainer.add(cartHeader);
        centerRightPanel.add(cartContainer);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(990,800);
        this.setVisible(true);
        //this.setLayout(null);
        this.setResizable(false);
        this.setBackground(new Color(255,255,255));
    }

    void print() {
        System.out.println("2nd Class");
    }
}
