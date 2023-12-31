package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

import model.PizzaType;
import model.OrderInterface;


public class CenterPanel extends JPanel implements ActionListener {
    private int width;
    private int height;

    private JComboBox<Object> cmbPizzaType;
    private JComboBox cmbSize;
    private JSpinner Quantity;
    private JCheckBox chickenCheckBox;
    private JCheckBox kebabCheckBox;
    private JCheckBox paprikaCheckBox;
    private JCheckBox MushroomCheckBox;
    PizzaType pizzaType;


    private JPanel pnlLeft;  //for labels at left
    private JPanel pnlRight; //for boxes at right

    private OrderInterface model;

    public CenterPanel(OrderInterface model, int width, int height, int margin) {
        this.model = model;
        this.width = width;
        this.height = height;

        setBorder(BorderFactory.createTitledBorder("Pizza Information"));

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        setBorder(new CompoundBorder(border, emptyBorder));

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(width, height));
        createComponentsOnLeftPanel();
        createComponentsOnRightPanel();
    }



    private void createComponentsOnLeftPanel() {
        JLabel lblPizzaType = new JLabel("Pizza Type");
        JLabel lblPizzaSize = new JLabel("Pizza Size");
        JLabel lblQuantity = new JLabel("Quantity");
        JLabel lblToppings = new JLabel("Toppings");


        GridLayout layoutLeft = new GridLayout(10, 1, 2, 2);
        Dimension dim = new Dimension(4 * width / 20, height);

        pnlLeft = new JPanel(layoutLeft);
        pnlLeft.setPreferredSize(dim);
        pnlLeft.add(lblPizzaType);
        pnlLeft.add(lblPizzaSize);
        pnlLeft.add(lblQuantity);
        pnlLeft.add(lblToppings);

        add(pnlLeft, BorderLayout.WEST);
    }


    private void createComponentsOnRightPanel() {

        GridLayout layoutRight = new GridLayout(10, 1, 20, 20);
        pnlRight = new JPanel(layoutRight);
        Dimension dim = new Dimension(6 * width / 20, height);

        pnlRight.setPreferredSize(dim);
        add(pnlRight, BorderLayout.CENTER);

        cmbPizzaType = new JComboBox<>(model.getPizzaType());
        cmbPizzaType.setSelectedIndex(0);
        pnlRight.add(cmbPizzaType);
        cmbPizzaType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object obj = cmbPizzaType.getSelectedItem();
                int index = cmbPizzaType.getSelectedIndex();
                model.setPizzaType(obj, index);
            }
        });

        cmbSize = new JComboBox(model.getSize());
        cmbSize.setSelectedIndex(0);
        pnlRight.add(cmbSize);
        cmbSize.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object obj = cmbSize.getSelectedItem();
                int index = cmbSize.getSelectedIndex();
                model.setPizzaSize(obj, index);
            }
        });

        Quantity = new JSpinner();
        Quantity.setPreferredSize(dim);


        pnlRight.add(Quantity);

        chickenCheckBox = new JCheckBox("Chicken");
        chickenCheckBox.setPreferredSize(dim);


        kebabCheckBox = new JCheckBox("Kebab");
        kebabCheckBox.setPreferredSize(dim);


        paprikaCheckBox = new JCheckBox("Paprika");
        paprikaCheckBox.setPreferredSize(dim);

        MushroomCheckBox = new JCheckBox("Mushroom");
        MushroomCheckBox.setPreferredSize(dim);


        add(pnlRight, BorderLayout.CENTER);
        pnlRight.add(chickenCheckBox);
        pnlRight.add(kebabCheckBox);
        pnlRight.add(paprikaCheckBox);
        pnlRight.add(MushroomCheckBox);
    }

    public Object getPizzaType() {
        return Objects.requireNonNull(cmbPizzaType.getSelectedItem()).toString();
    }

    public Object getPizzaSize() {
        return Objects.requireNonNull(cmbSize.getSelectedItem()).toString();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public int getQuantity() {
        return (int) Quantity.getValue();
    }

    public Object getString(Object object) {

        return Quantity.getValue().toString();
    }

    public Object getSelected() {
        StringBuilder tops = new StringBuilder();
        for (Component c : pnlRight.getComponents()) {
            if (c instanceof JCheckBox)
                if (((JCheckBox) c).isSelected())
                    tops.append(((JCheckBox) c).getText()).append(", ");
        }
        return tops.toString();
    }

}





