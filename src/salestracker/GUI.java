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
    JLabel discountTypeText =  new JLabel("Discount Type:");
    JLabel discountAmountText =  new JLabel("Discount Amount:");
    JLabel discountCodeText = new JLabel("Coupon code:");
    ButtonGroup discountGroup = new ButtonGroup();
    JRadioButton discount20Disp;
    JRadioButton discount10Disp;
    JComboBox discountSelection;
    JTextField discountInput = new JTextField(7);
    JButton checkoutBtn = new JButton("Checkout");

    // Cart panel
    JPanel cartItemContainer = new JPanel();
    JPanel cartHeaderContainer = new JPanel();
    JPanel cartPriceContainer = new JPanel();
    JLabel cartHeader = new JLabel("<html><u>Cart Log</u></html>");
    JLabel cartPrice = new JLabel();

    Double sum = 0.0, priceUnit = 0.0, discountAmount = 0.0, sumAfterDis = 0.0;
    String itemLabel;
    String discountName;
    String[] discountType;
    String discountCodeDesc;
    Boolean discountTypeValid = false, discountAmtValid = false,
            discount10 = false, discount20 = false,
            discount10Check = false, discount20Check = false,
            discountApplied = false;

    GUI() {

        super("Restaurant Sales Performance Tracker");

        welcomePanel.setBackground(Color.red);
        centerLeftPanel.setBackground(Color.blue);
        centerRightPanel.setBackground(Color.green);
        bottomPanel.setBackground(Color.PINK);
        bottomLeftPanel.setBackground(Color.PINK);
        bottomRightPanel.setBackground(Color.PINK);
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
        new ItemBuilder().discountAmount(itemObRead.getDiscountAmt()).discountType(itemObRead.getDiscountType()).discountCode(itemObRead.getDiscountCode()).buildItem();

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

        foodCheckBoxContainer.setBackground(Color.ORANGE);

        foodCheckBoxContainer.add(nasiLemakCheck);foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,90)));nasiLemakCheck.setOpaque(true);
        nasiLemakCheck.setBackground(Color.ORANGE);
        foodCheckBoxContainer.add(miGorengCheck); foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));miGorengCheck.setOpaque(true);
        miGorengCheck.setBackground(Color.ORANGE);
        foodCheckBoxContainer.add(rotiCheck); foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));rotiCheck.setOpaque(true);
        rotiCheck.setBackground(Color.ORANGE);
        foodCheckBoxContainer.add(sirupCheck); foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));sirupCheck.setOpaque(true);
        sirupCheck.setBackground(Color.ORANGE);
        foodCheckBoxContainer.add(tehCheck);foodCheckBoxContainer.add(Box.createRigidArea(new Dimension(0,100)));tehCheck.setOpaque(true);
        tehCheck.setBackground(Color.ORANGE);
        foodCheckBoxContainer.add(miloCheck);miloCheck.setOpaque(true);
        miloCheck.setBackground(Color.ORANGE);

        centerCenterPanel.add(foodCheckBoxContainer);

        // Checkout and Discount code panel
        bottomLeftPanel.setBackground(Color.PINK);
        bottomRightPanel.setBackground(Color.PINK);

        bottomLeftPanel.add(discountTypeText);
        discountType = itemObRead.getDiscountType();
        discountSelection = new JComboBox(discountType);
        discountSelection.setSelectedIndex(-1);

        bottomLeftPanel.add(discountSelection);
        bottomLeftPanel.add(discountAmountText);

//        discount10 = itemObRead.getDiscountAmt()[0];
//        discount20 = itemObRead.getDiscountAmt()[1];
        discount10Disp = new JRadioButton("10%");
        discount20Disp = new JRadioButton("20%");
        discountGroup.add(discount10Disp); discountGroup.add(discount20Disp);
        discount10Disp.setEnabled(false); discount20Disp.setEnabled(false);

        discount10Disp.setOpaque(true);
        discount10Disp.setBackground(Color.PINK);
        discount20Disp.setOpaque(true);
        discount20Disp.setBackground(Color.PINK);

        bottomLeftPanel.add(discount10Disp);
        bottomLeftPanel.add(discount20Disp);

        bottomLeftPanel.add(discountCodeText);
        bottomLeftPanel.add(discountInput);
        //discountInput.setEditable(false);

        bottomLeftPanel.add(applyBtn);

        bottomRightPanel.add(checkoutBtn);

       // discountInput.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,0));

        bottomPanel.add(bottomLeftPanel, BorderLayout.WEST);
        bottomPanel.add(bottomRightPanel, BorderLayout.EAST);

        // Cart panel
        centerRightPanel.add(cartHeaderContainer, BorderLayout.NORTH);
        cartHeaderContainer.setBackground(Color.yellow);
        cartHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cartHeaderContainer.add(cartHeader);
    }

    class GUIDiscountController implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }
}

