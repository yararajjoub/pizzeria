
package model;

import view.*;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class OrderManager implements OrderInterface {


    private Menu menu;
    MainFrame view;
    MenuManager menuManager;
    ReceiptFrame receiptFrame;
    private Pizza pizza;
    private PizzaTopping pizzaTopping;
    private double total;
    private ArrayList<Pizza> list = new ArrayList<Pizza>();

    public OrderManager() throws RemoteException {

        menu = new Menu();
        menuManager = new MenuManager();
        view = new MainFrame(this);
    }

    // make actions when pressing buttons
    public void buttonPressed(ButtonType button) throws Exception {
        //Pizza pizza;
        Pizza newOne = null;
        int index = 0;
        switch (button) {
            case Order:
                pizza = getMenuData();                          // Get info from View
                menuManager.addMenu(pizza);                     // Add the selected object
                view.updateEastPizzaList(menuManager.getInfoStrings());  // Show it in our order list

                view.setLblTotal(String.valueOf(calcTotal()));  // Calling calculate method and show the result after adding an object to our arraylist.
                updateTotal();
                break;

            case Change:
                pizza = getMenuDataFrView();
                menuManager.addMenu(pizza);
                view.updateEastPizzaList(menuManager.getInfoStrings());

                view.setLblTotal(String.valueOf(calcTotal()));  // Calling calculate method and show the result after adding an object to our arraylist.
                updateTotal();
                break;

            case Delete:                                       // to delete an object from the array.
                index = view.getListIndex();
                if (validateIndex(index))
                    menuManager.deleteAt(index);
                break;

            case Reset:
                list.clear();
               // view.setLblTotal(String.valueOf(calcTotal()));  // Calling calculate method and show the result after adding an object to our arraylist.
                updateTotal();
                break;


        }
        updateView();
        int attendance = menuManager.getNumber();
        // view.setNumGuest(Integer.toString(attendance));
        view.updateEastPizzaList(menuManager.getInfoStrings());
        // view.setLblTotal(getPrice());
    }

    @Override
    public Object[] getSize() {
        return Size.values();
    }       // get Enum Size

    @Override // to be implemented if needed
    public void setPizzaSize(Object obj, int index) {

    }

    @Override
    public void pizzaListIndexChanged(int index) {

    }

    private Pizza getMenuDataFrView() {

        Pizza pizza = new Pizza();

        String n = (String) view.getPizzaType();
        pizza.setName(n);

        String s = (String) view.getPizzaSize();
        pizza.setSize(Size.valueOf(s));

        String t = (String) view.getSelected();
        pizza.setToppings(t);

        pizza.setPrice(105);

        String q = (String) view.getString();
        pizza.setQuantity(Integer.parseInt(q));
        list.add(pizza);
        return pizza;
    }

    private Pizza getMenuData() {
        Pizza pizza;

        if (view.getList() instanceof Pizza) {
            // Adds the selected objects from View to arraylist.
            pizza = (Pizza) view.getList();

            Pizza newOne = new Pizza();
            newOne.setQuantity(view.getValue());
            newOne.setPrice((int) pizza.getPrice());
            list.add(newOne);

            String q = (String) view.getString(); // set Quantity
            pizza.setQuantity(Integer.parseInt(q));

        } else {
            JOptionPane.showMessageDialog(null, "Select a pizza!");
            pizza = null;
        }
        return pizza;
    }               // Get the selected element from view and add it to Pizza array

    /*
        public void defineMenu(Item item) {

            if (item instanceof Pizza) menu.define((Pizza) item);
        }       // To define that an object of type Pizza


     */
    @Override
    public Object[] getPizzaType() {
        return PizzaType.values();
    }   // Return Enum

    @Override
    public void setPizzaType(Object obj, int index) {

    }

    public ArrayList<Item> getMenuList() {
        return new ArrayList<>(menu.getPizzas());
    }               // Getting the pizza list we created

    private boolean validateIndex(int index) {
        boolean ok = true;
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Select an item in the list!");
            ok = false;
        }
        return ok;
    }

    public double calcTotal() {
        if (list.size() == 0) {
            total = 0;
        } else {
            for (Pizza pizza : list) {
                if (pizza.getSpecial() == 0) {
                    total += pizza.getPrice() * pizza.getQuantity();
                } else {
                    this.total += pizza.getSpecial();
                }
            }
        }
        return total;
    }           // Method to calculate the total of the order list.

    public void updateTotal() {
        total = 0;
    }         // Update total'


    //Denna metod anropas varje gång någon ändring av modelen sker
    private void updateView() {
        view.showProductInfo(toString());
    }

    @Override
    public String toString() {
        return pizza.getName() + "(" + pizza.getSize() + ", " + pizza.getPrice() + " SEK) \nToppings\n"
                +" "+ pizza.getToppings() + "\nTotal cost: " + calcTotal();
    }


    public String showPizzas() {
        if (menu.getPizzas().size() != 0) {
            StringBuilder s = new StringBuilder();
            for (Pizza p : menu.getPizzas()) {
                s.append(p.toString()).append("\n");
            }
            return s.toString();
        } else return null;

    }
}

//  public Toppings[] getToppingsItems() {
//    return Toppings.values();
// }
