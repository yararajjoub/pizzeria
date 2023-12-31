
package model;

import java.util.ArrayList;

public class Pizza extends Item {
    private OrderManager orderManager;
    private ArrayList<PizzaTopping> tops = new ArrayList<PizzaTopping>();
    private String name;
    private Size size;
    private double price;
    private double special;
    private String toppings;
    private int quantity;

    public Pizza(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public Pizza(String name, Size size, double price, String toppings) {

        this.name = name;
        this.size = size;
        this.special = 0;
        this.price = price;
        this.toppings = toppings;

        this.tops = new ArrayList<PizzaTopping>();
        create();
    }

    public Pizza() {

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public double getSpecial() {
        return special;
    }

    @Override
    public void setSpecial(int special) {
        this.special = special;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void addTopping(PizzaTopping topping) {
        tops.add(topping);
    }

    public double pizzaCost() {
        PizzaTopping base = null;
        assert false;
        double cost = base.getCost();
        for (PizzaTopping topping : tops) {
            cost += topping.getCost();
        }
        return cost;
    }

    /**/
    @Override
    public String toString() {
        return name + " (" + size +", "+  price + " SEK) " + " Toppings: " + toppings;
    }

    public void create() {
        Pizza pizza = new Pizza(orderManager);
        pizza.setName("Ham");
        pizza.addTopping(new PizzaTopping("Tomato Sauce", 10));
        pizza.addTopping(new PizzaTopping("Cheese", 12));
        pizza.addTopping(new PizzaTopping("chicken", 15));
        pizza.addTopping(new PizzaTopping("Kebab", 15));
        pizza.addTopping(new PizzaTopping("Shrimps", 15));
        pizza.addTopping(new PizzaTopping("Bacon", 15));
        pizza.addTopping(new PizzaTopping("Paprika", 10));
        pizza.addTopping(new PizzaTopping("Mushroom", 15));
        pizza.addTopping(new PizzaTopping("Onion", 15));
        pizza.addTopping(new PizzaTopping("Oliver", 15));
        //
    }
}
