package salestracker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {

    // GUI layout backbone
    JPanel welcomePanel = new JPanel();
    JPanel centerLeftPanel = new JPanel();
    JPanel centerCenterPanel = new JPanel();
    JPanel centerRightPanel = new JPanel(new BorderLayout());
    JPanel bottomPanel = new JPanel(new BorderLayout());

    //Welcome panel
    JLabel welcomeText = new JLabel("Welcome to Elton Restaurant");

    // Item list
    JPanel itemContainer = new JPanel();

    // Item Selection
    JPanel foodCheckBoxContainer = new JPanel();
    JCheckBox nasiLemakCheck = new JCheckBox();
    JCheckBox miGorengCheck = new JCheckBox();
    JCheckBox rotiCheck = new JCheckBox();
    JCheckBox sirupCheck = new JCheckBox();
    JCheckBox tehCheck = new JCheckBox();
    JCheckBox miloCheck = new JCheckBox();

    // Checkout and Discount code panel
    JPanel bottomLeftPanel = new JPanel();
    JPanel bottomRightPanel = new JPanel();
    JButton applyBtn = new JButton("Apply");
    JLabel discountText = new JLabel("Please enter the coupon code (*if applicable):");
    JTextField discountInput = new JTextField(5);
    JButton checkoutBtn = new JButton("Checkout");

    // Cart panel
    JPanel cartItemContainer = new JPanel();
    JPanel cartHeaderContainer = new JPanel();
    JPanel cartPriceContainer = new JPanel();
    JLabel cartHeader = new JLabel("<html><u>Cart Log</u></html>");
    JLabel cartPrice = new JLabel();

    Double sum = 0.0, priceUnit = 0.0;
    String itemLabel;

    GUI() {

        super("Restaurant Sales Performance Tracker");

        welcomePanel.setBackground(Color.red);
        centerLeftPanel.setBackground(Color.blue);
        centerRightPanel.setBackground(Color.green);
        bottomPanel.setBackground(Color.PINK);
        centerCenterPanel.setBackground(Color.ORANGE);

        this.add(welcomePanel,BorderLayout.PAGE_START);
        this.add(centerLeftPanel, BorderLayout.LINE_START);
        this.add(centerCenterPanel, BorderLayout.CENTER);
        this.add(centerRightPanel, BorderLayout.LINE_END);
        this.add(bottomPanel, BorderLayout.PAGE_END);

        centerRightPanel.setPreferredSize(new Dimension(500, 300));

        this.add(centerCenterPanel, BorderLayout.CENTER);

        welcomePanel.add(welcomeText);

        itemContainer.setLayout(new BoxLayout(itemContainer, BoxLayout.Y_AXIS));
        itemContainer.setBorder(BorderFactory.createEmptyBorder(0, 30, 0,100));

        Item itemObRead = new ItemBuilder().buildItem();

        new ItemBuilder().foodImg(itemObRead.getFoodImg()).foodName(itemObRead.getFoodName()).foodPrice(itemObRead.getFoodPrice()).buildItem();
        new ItemBuilder().drinkImg(itemObRead.getDrinkImg()).drinkName(itemObRead.getDrinkName()).drinkPrice(itemObRead.getDrinkPrice()).buildItem();

        JLabel[] foodName = new JLabel[itemObRead.getFoodName().length];
        JLabel[] foodPricing = new JLabel[itemObRead.getFoodPrice().length];
        JLabel[] foodImgDisplay = new JLabel[itemObRead.getFoodImg().length];

        JLabel[] drinkName = new JLabel[itemObRead.getDrinkName().length];
        JLabel[] drinkPricing = new JLabel[itemObRead.getDrinkPrice().length];
        JLabel[] drinkImgDisplay = new JLabel[itemObRead.getDrinkImg().length];

        // Food
        for(int i=0; i<itemObRead.getFoodName().length; i++){

            foodName[i] = new JLabel(itemObRead.getFoodName()[i]);
            foodImgDisplay[i] = new JLabel(itemObRead.getFoodImg()[i]);
            foodPricing[i] = new JLabel("RM " + itemObRead.getFoodPrice()[i]); //String.valueOf()

            foodName[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            foodName[i].setPreferredSize(new Dimension(250, 100));

            itemContainer.add(foodName[i]);
            itemContainer.add(foodImgDisplay[i]);
            itemContainer.add(foodPricing[i]);
            itemContainer.add(Box.createRigidArea(new Dimension(0,40)));
            centerLeftPanel.add(itemContainer);
        }

        // Drink
        for(int i=0; i<itemObRead.getDrinkName().length; i++){

            drinkName[i] = new JLabel(itemObRead.getDrinkName()[i]);
            drinkImgDisplay[i] = new JLabel(itemObRead.getDrinkImg()[i]);
            drinkPricing[i] = new JLabel("RM " + itemObRead.getDrinkPrice()[i]); //String.valueOf()

            drinkName[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            drinkName[i].setPreferredSize(new Dimension(250, 100));

            itemContainer.add(drinkName[i]);
            itemContainer.add(drinkImgDisplay[i]);
            itemContainer.add(drinkPricing[i]);
            itemContainer.add(Box.createRigidArea(new Dimension(0,40)));
            centerLeftPanel.add(itemContainer);
        }

        // Item Selection
        foodCheckBoxContainer.setLayout(new BoxLayout(foodCheckBoxContainer, BoxLayout.Y_AXIS));

        foodCheckBoxContainer.add(nasiLemakCheck); foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,90)));
        foodCheckBoxContainer.add(miGorengCheck); foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));
        foodCheckBoxContainer.add(rotiCheck); foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));
        foodCheckBoxContainer.add(sirupCheck); foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));
        foodCheckBoxContainer.add(tehCheck);foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));
        foodCheckBoxContainer.add(miloCheck);

        centerCenterPanel.add(foodCheckBoxContainer);

        // Checkout and Discount code panel
        bottomLeftPanel.setBackground(Color.PINK);
        bottomRightPanel.setBackground(Color.PINK);

        bottomLeftPanel.add(discountText);
        bottomLeftPanel.add(discountInput);
        bottomLeftPanel.add(applyBtn);
        bottomRightPanel.add(checkoutBtn);

        discountInput.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,100));

        bottomPanel.add(bottomLeftPanel, BorderLayout.WEST);
        bottomPanel.add(bottomRightPanel, BorderLayout.EAST);

        // Cart panel
        centerRightPanel.add(cartHeaderContainer, BorderLayout.NORTH);
        cartHeaderContainer.setBackground(Color.yellow);
        cartHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cartHeaderContainer.add(cartHeader);

        /* =======================================================================Logic Handler======================================================================= */

        GUIBackend gB = new GUIBackend();

        nasiLemakCheck.addActionListener(gB); miGorengCheck.addActionListener(gB);rotiCheck.addActionListener(gB);
        sirupCheck.addActionListener(gB); tehCheck.addActionListener(gB); miloCheck.addActionListener(gB);
    }

    class GUIBackend implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            JCheckBox cbGroup = (JCheckBox) event.getSource();
            JLabel itemNameJLabel = new JLabel();
            JLabel itemPriceJLabel = new JLabel();

            Item itemObRead = new ItemBuilder().buildItem();

            if (cbGroup.isSelected()) {

                if (cbGroup == nasiLemakCheck) {
                    sum += itemObRead.getFoodPrice()[0];
                    priceUnit = itemObRead.getFoodPrice()[0];
                    itemLabel = itemObRead.getFoodName()[0];
                } else if (cbGroup == miGorengCheck) {
                    sum += itemObRead.getFoodPrice()[1];
                    priceUnit = itemObRead.getFoodPrice()[1];
                    itemLabel = itemObRead.getFoodName()[1];
                } else if (cbGroup == rotiCheck) {
                    sum += itemObRead.getFoodPrice()[2];
                    priceUnit = itemObRead.getFoodPrice()[2];
                    itemLabel = itemObRead.getFoodName()[2];
                } else if (cbGroup == sirupCheck) {
                    sum += itemObRead.getDrinkPrice()[0];
                    priceUnit = itemObRead.getDrinkPrice()[0];
                    itemLabel = itemObRead.getDrinkName()[0];
                } else if (cbGroup == tehCheck) {
                    sum += itemObRead.getDrinkPrice()[1];
                    priceUnit = itemObRead.getDrinkPrice()[1];
                    itemLabel = itemObRead.getDrinkName()[1];
                } else if (cbGroup == miloCheck) {
                    sum += itemObRead.getDrinkPrice()[2];
                    priceUnit = itemObRead.getDrinkPrice()[2];
                    itemLabel = itemObRead.getDrinkName()[2];
                }

                itemNameJLabel.setText(itemLabel);
                itemPriceJLabel.setText("RM " + priceUnit);

            } else {

                if (cbGroup == nasiLemakCheck) {
                    sum -= itemObRead.getFoodPrice()[0];
                    itemLabel = "<html><s>" + itemObRead.getFoodName()[0] + " RM " + itemObRead.getFoodPrice()[0] + "</s></html>";
                } else if (cbGroup == miGorengCheck) {
                    sum -= itemObRead.getFoodPrice()[1];
                    itemLabel = "<html><s>" + itemObRead.getFoodName()[1] + " RM " + itemObRead.getFoodPrice()[1] + "</s></html>";
                } else if (cbGroup == rotiCheck) {
                    sum -= itemObRead.getFoodPrice()[2];
                    itemLabel = "<html><s>" + itemObRead.getFoodName()[2] + " RM " + itemObRead.getFoodPrice()[2] + "</s></html>";
                } else if (cbGroup == sirupCheck) {
                    sum -= itemObRead.getDrinkPrice()[0];
                    itemLabel = "<html><s>" + itemObRead.getDrinkName()[0] + " RM " + itemObRead.getDrinkPrice()[0] + "</s></html>";
                } else if (cbGroup == tehCheck) {
                    sum -= itemObRead.getDrinkPrice()[1];
                    itemLabel = "<html><s>" + itemObRead.getDrinkName()[1] + " RM " + itemObRead.getDrinkPrice()[1] + "</s></html>";
                } else if (cbGroup == miloCheck) {
                    sum -= itemObRead.getDrinkPrice()[2];
                    itemLabel = "<html><s>" + itemObRead.getDrinkName()[2] + " RM " + itemObRead.getDrinkPrice()[2] + "</s></html>";
                }

                itemNameJLabel.setText(itemLabel);
            }

            JPanel cartItemListContainer = new JPanel();
            cartItemContainer.setLayout(new BoxLayout(cartItemContainer, BoxLayout.Y_AXIS));
            centerRightPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
            cartItemContainer.setOpaque(true);
            cartItemListContainer.add(itemNameJLabel);
            cartItemListContainer.add(itemPriceJLabel);

            cartItemContainer.add(cartItemListContainer);
            centerRightPanel.add(cartItemContainer, BorderLayout.PAGE_START);
            cartItemListContainer.setBackground(Color.MAGENTA);

            cartItemListContainer.revalidate();

            cartPrice.setText(String.format("Total Price : RM %.2f",sum));

            centerRightPanel.add(cartPriceContainer, BorderLayout.SOUTH);
            cartPriceContainer.setBackground(Color.CYAN);
            cartPriceContainer.add(cartPrice);
        }
    }
}

