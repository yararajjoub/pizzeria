
package model;

import view.ButtonType;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Menu implements OrderInterface {

    private ArrayList<Pizza> pizzas;
    private ArrayList<Toppings> toppings;

    public Menu(){

        pizzas = new ArrayList<>();
        toppings = new ArrayList<>();
        createPizza();
    }

    public void createPizza(){

        define(new Pizza("Kebab pizza", Size.medium, 90,
                "Tomato_sauce, Cheese, Meat, Paprika "));
        define(new Pizza("Chicken pizza", Size.medium, 80,
                "Tomato_sauce, Cheese, Chicken fillet, Mushroom "));
        define(new Pizza("Margarita", Size.medium, 70,
                "Tomato_sauce, Cheese "));
        define(new Pizza("Hawaii pizza", Size.medium, 100,
                "Tomato_sauce, Cheese, Bacon "));
        define(new Pizza("Veggie pizza", Size.medium, 70,
                "Tomato, Pepper, Onion, Mozzarella "));

    }

    public void define(Item item){
        if(item instanceof Pizza) pizzas.add((Pizza)item);
    }

    /*public void remove(Item item){
        if(item instanceof Pizza) pizzas.remove((Pizza)item);
    }



    public ArrayList<Toppings> getToppings(){
        return toppings;
    }
*/
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }


    @Override
    public ArrayList<Item> getMenuList() throws RemoteException {
        return null;
    }

    @Override
    public Object[] getPizzaType() {
        return new Object[0];
    }

    @Override
    public void setPizzaType(Object obj, int index) {

    }

    @Override
    public void buttonPressed(ButtonType button) {

    }

    @Override
    public Object[] getSize() {
        return new Object[0];
    }

    @Override
    public void setPizzaSize(Object obj, int index) {

    }

    @Override
    public void pizzaListIndexChanged(int index) {

    }

}
