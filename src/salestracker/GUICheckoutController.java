package salestracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICheckoutController extends GUI implements ActionListener {

    GUICheckoutController() {
        nasiLemakCheck.addActionListener(this); miGorengCheck.addActionListener(this);rotiCheck.addActionListener(this);
        sirupCheck.addActionListener(this); tehCheck.addActionListener(this); miloCheck.addActionListener(this);
    }

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
