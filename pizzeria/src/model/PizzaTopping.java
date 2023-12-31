
package model;

public class PizzaTopping extends Pizza {

    private String name;
    private double cost;

    public PizzaTopping(String name, double cost) {
        super();
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}


