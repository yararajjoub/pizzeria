package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.rmi.RemoteException;


import model.OrderInterface;

public class MainPanel extends JPanel {
    OrderInterface model;
    private int width;
    private int height;
    private CenterPanel pnlCenter;
    private SouthPanelButtons pnlSouth;
    //JTextArea txtAreaInfo;
    BorderLayout layout;
    EastPnlPizzaList pnlEast;
    WestPnlPizzaList pnlWest;


    public MainPanel(OrderInterface model, int width, int height) throws RemoteException {
        this.model = model;
        this.width = width;
        this.height = height;
        setupPanel();
    }


    private void setupPanel() throws RemoteException {
        layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(6, 6, 6, 6);
        setBorder(new CompoundBorder(border, margin));

        pnlCenter = new CenterPanel(model, 4 * width / 10, 8 * height / 10, 6);  //labels and textboxes

        //Buttons at south
        pnlSouth = new SouthPanelButtons(model, width, 2 * height / 10);
        add(pnlSouth, layout.SOUTH);

        pnlEast = new EastPnlPizzaList(model, 6 * width / 10, 8 * height / 10, 6);
        add(pnlCenter, layout.CENTER);
        //getPnlCenter().createInfoTextArea();

        pnlWest = new WestPnlPizzaList(model, 6 * width / 10, 8 * height / 10, 6);

        add(pnlWest, BorderLayout.WEST);
        add(pnlEast, BorderLayout.EAST);

    }


    public CenterPanel getPnlCenter() {
        return pnlCenter;
    }

    public SouthPanelButtons getPnlSouth() {
        return pnlSouth;
    }

    public EastPnlPizzaList getPnlEast() {
        return pnlEast;
    }

    public WestPnlPizzaList getPnlWest() {
        return pnlWest;
    }

    public int getListIndex() {
        return pnlWest.getListIndex();
    }

}

