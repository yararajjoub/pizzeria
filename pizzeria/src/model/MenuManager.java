
package model;

public class MenuManager {

    private Pizza[] pizzas;
    private int number;

    public MenuManager() {
        pizzas = new Pizza[20000];
    }

    public void addMenu(Pizza pizza) {
        try{
            pizzas[number] = new Pizza();
            pizzas[number].setName(pizza.getName());
            pizzas[number].setSize(pizza.getSize());
            pizzas[number].setPrice((int) pizza.getPrice());
            pizzas[number].setToppings(pizza.getToppings());
            pizzas[number].setQuantity(pizza.getQuantity());
            number++;
        } catch (Exception e){


        }

    }

    /*public void changeAt(int index, Pizza pizzaIn) {
        pizzas[index] = pizzaIn;
    }*/

    public void deleteAt(int index) {

        if ((index >= 0) && (index < pizzas.length) && (pizzas[index] != null)) {
            number--;
            moveElementsToLeft(index);
        }
    }

    private void moveElementsToLeft(int index) {
        Pizza[] array = pizzas;
        for (int i = index + 1; i < array.length; i++) {
            array[i - 1] = array[i];
            array[i] = null;
        }
    }

    public String[] getInfoStrings() {
        String[] infoStrings = new String[this.number];

        for (int i = 0; i < number; i++) {
            infoStrings[i] = pizzas[i].toString();
        }
        return infoStrings;
    }

    public int getNumber() {
        return number;
    }

    /*
    public Pizza getMenuAt(int index) {
        return pizzas[index];
    } */

}

