package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.rmi.RemoteException;

import model.OrderInterface;

public class WestPnlPizzaList extends JPanel {

    private JList<Object> list;

    private OrderInterface model;

    public WestPnlPizzaList(OrderInterface model, int width, int height, int margin) {
        this.model = model;

        setBorder(BorderFactory.createTitledBorder("Pizza List"));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        setBorder(new CompoundBorder(border, emptyBorder));

        list = new JList();

        try {
            list = new JList<>(model.getMenuList().toArray());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JScrollPane s = new JScrollPane(list);
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(width - margin, height - 2 * margin));

        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        add(s);

    }

    public int getListIndex() {
        return list.getSelectedIndex();
    }

    public void updatePizzaList(String[] stringList) {
        list.setListData(stringList);
    }

    public Object getList() {
        return list.getSelectedValue();
    }

}
    





