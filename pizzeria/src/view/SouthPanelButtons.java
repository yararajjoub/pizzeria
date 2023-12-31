package view;

import model.OrderInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanelButtons extends JPanel {

    private int width;
    private int height;
    private OrderInterface model;
    JButton order, specialOrder, btnDelete, btnReset, totalCost;
    private JLabel currentCost, lblTotal;


    public SouthPanelButtons(OrderInterface model, int width, int height) {
        this.model = model;
        this.width = width;
        this.height = height;

        int buttonHeight = height - 14;  //4 = margin
        int buttonWidth = width / 16;
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        JPanel pnlButtons = new JPanel();

        order = new JButton("Order");
        Dimension dim = new Dimension(buttonWidth, buttonHeight);
        order.setSize(dim);

        specialOrder = new JButton("Special Order");
        specialOrder.setSize(dim);

        btnDelete = new JButton("Delete Order");
        specialOrder.setSize(dim);

        btnReset = new JButton("Reset");
        btnReset.setSize(dim);

        //totalCost = new JButton("Receipt");
        //totalCost.setSize(dim);

        currentCost = new JLabel("Cost: ");
        lblTotal = new JLabel("0.0");

        pnlButtons.add(order);
        pnlButtons.add(specialOrder);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnReset);
       // pnlButtons.add(totalCost);
       // pnlButtons.add(currentCost);
       // pnlButtons.add(lblTotal);

        add(pnlButtons);
        addListeners();
    }

    private void addListeners() {
        ActionListener listener = new ButtonActionListeners();
        order.addActionListener(listener);
        specialOrder.addActionListener(listener);
        btnDelete.addActionListener(listener);
        btnReset.addActionListener(listener);
       //totalCost.addActionListener(listener);
    }

    class ButtonActionListeners implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == order) {
                try {
                    model.buttonPressed(ButtonType.Order);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else if (e.getSource() == specialOrder) {
                try {
                    model.buttonPressed(ButtonType.Change);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else if (e.getSource() == btnDelete) {
                try {
                    model.buttonPressed(ButtonType.Delete);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else if (e.getSource() == btnReset) {
                try {
                    model.buttonPressed(ButtonType.Reset);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else if (e.getSource() == totalCost) {
                try {
                    model.buttonPressed(ButtonType.TotalCast);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }


        }
    }

    public void setLblTotal(String text) {
        lblTotal.setText(text);
    }
}
