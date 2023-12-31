
package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import model.Pizza;
import model.OrderInterface;

public class EastPnlPizzaList extends JPanel
{

    private JList<String> list,listS;
    private OrderInterface model;
    DefaultListModel listModel;
    DefaultListModel<Pizza> listModel1 = new DefaultListModel<>();


    public EastPnlPizzaList(OrderInterface model, int width, int height, int margin)
    {
        this.model = model;

        setBorder(BorderFactory.createTitledBorder("Orders List"));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        setBorder(new CompoundBorder(border, emptyBorder));
        list = new JList();

       // JList<Item> list = new JList<Item>();
      //  list = model.getItems(Pizza);
      //  Item item=new Item();
      //  list = new JList(model.getItems(items).toArray(new String[0]));

       // JList<String> list = new JList<>(listModel1);

        JScrollPane s = new JScrollPane(list);
        //extra saker
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(width-margin, height-2*margin));

        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        addListener();
        add(s);

    }

    public int getListIndex()
    {
        return list.getSelectedIndex();
    }

    public void updatePizzaList(String [] stringList)
    {
        list.setListData(stringList);
    }




    public void addListener()
    {
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evt)
            {
                //int index = evt.getFirstIndex();
                int index = list.getSelectedIndex();
                if ( index > -1)
                {
                    model.pizzaListIndexChanged(index);
                }
            }});
    }



}
