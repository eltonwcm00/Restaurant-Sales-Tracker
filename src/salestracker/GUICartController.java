package salestracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GUICartController extends GUI implements ActionListener, ItemListener {

    Item itemObRead = new ItemBuilder().buildItem();

    GUICartController() {

        nasiLemakCheck.addActionListener(this); miGorengCheck.addActionListener(this);rotiCheck.addActionListener(this);
        sirupCheck.addActionListener(this); tehCheck.addActionListener(this); miloCheck.addActionListener(this);
        discountSelection.addItemListener(this);

          discount10Disp.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {

                  JRadioButton button = (JRadioButton) event.getSource();

                  if(button.isSelected()) {
                      if(button ==  discount10Disp) {
                          discountAmount = itemObRead.getDiscountAmt()[0];
                          discount10JDisp.setText(String.valueOf(discountAmount));
                          //System.out.println(discountAmount);
                          discount10 = true;
                          discount20 = false;
                      }
                  }
              }
          });

          discount20Disp.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent event) {

                   JRadioButton button = (JRadioButton) event.getSource();

                   if(button.isSelected()) {
                       if(button ==  discount20Disp) {
                           discountAmount = itemObRead.getDiscountAmt()[1];
                           discount20JDisp.setText(String.valueOf(discountAmount));
                           //System.out.println(discountAmount);
                           discount10 = false;
                           discount20 = true;
                       }
                   }
               }
          });

          applyBtn.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  if(e.getSource() == applyBtn) {

                      if(discount10&&!discount20) {
                          discountAmount = itemObRead.getDiscountAmt()[0];
                      }
                      else if(!discount10&&discount20) {
                          discountAmount = itemObRead.getDiscountAmt()[1];
                      }

                      System.out.println(discountAmount);
                  }
              }
          });
    }

    @Override
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

        if(event.getSource() == discount20Disp) {
            JRadioButton button = (JRadioButton) event.getSource();

                    if(button.isSelected()) {
                        if(button ==  discount20Disp) {
                            System.out.print("cc");
                        }
                    }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == discountSelection) {

            if(discountSelection.getSelectedItem()!= "Food & Drink") {
                JOptionPane.showMessageDialog(null,
                                        "Discount option is unavailable for now",
                                            "Unavailable", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog( null,
                                        discountSelection.getSelectedItem() +
                                                " type voucher is selected !");

                System.out.println("Radio Button is unlocked");

                discountTypeValid = true;
                discount10Disp.setEnabled(true);
                discount20Disp.setEnabled(true);
            }
        }
        else {
            discountTypeValid = false;
        }

//        if (discountTypeValid) {
//
//            if (e.getSource() == discount10Disp) {
//                discountAmtValid = true;
//
//                System.out.print("f");
//
//                if(discount10Disp.isSelected()) {
//                    discountAmount = itemObRead.getDiscountAmt()[0];
//                }
//                else if(discount20Disp.isSelected()) {
//                    discountAmount = itemObRead.getDiscountAmt()[1];
//                }
//                System.out.println(discountAmount);
//            }
//            else {
//                System.out.print("fb");
//                discountAmtValid = false;
//            }
//        }

        if(discountAmtValid) {
            discountInput.setEditable(true);
        }
    }
}
