package view;

import javax.swing.*;

import model.OrderInterface;
import java.rmi.RemoteException;

public class MainFrame extends JFrame {
    private int width = 800;
    private int height = 450;
    OrderInterface model;
    MainPanel panel;
    ReceiptFrame receiptFrame;

    public MainFrame(OrderInterface model) throws RemoteException {
        this.model = model;
        setupFrame();
        receiptFrame = new ReceiptFrame();
    }

    public void setupFrame() throws RemoteException {
        final int offsetX = width / 40;
        final int offsetY = height / 5;

        setSize(width, height);
        setTitle("Pizzeria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(offsetX, offsetY);

        panel = new MainPanel(model, width, height);
        setContentPane(panel);
        setResizable(true);
        pack();
        setVisible(true);
    }

    /*       public void errMessage(String message)
            {
                JOptionPane.showMessageDialog(null, message);
            }

            public void updatePizzaList(String [] stringList)
            {
                panel.getPnlWest().updatePizzaList(stringList);
            }

     */
    public int getListIndex() {
        return panel.getPnlEast().getListIndex();
    }

    public Object getPizzaType() {
        return panel.getPnlCenter().getPizzaType();
    }

    public Object getPizzaSize() {
        return panel.getPnlCenter().getPizzaSize();
    }

    public Object getSelected() {
        return panel.getPnlCenter().getSelected();
    }

    public Object getList() {
        return panel.getPnlWest().getList();
    }

    public void updateEastPizzaList(String[] stringList) {
        panel.getPnlEast().updatePizzaList(stringList);
    }


    public int getValue() {
        return panel.getPnlCenter().getQuantity();
    }

    public Object getString() {
        return panel.getPnlCenter().getString(getValue());
    }

    public void setLblTotal(String str) {
        panel.getPnlSouth().setLblTotal(str);
    }


    public void showProductInfo(String str) {
        receiptFrame.setTxtAreaInfo(str);
    }

}


