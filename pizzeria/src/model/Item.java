
package model;


import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Item {

    private String name;
    private Size size;
    private double price, special;


    public Item() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public String getName() {
        return this.name;
    }

    public Enum<Size> getSize() {
        return this.size;
    }

    public double getPrice() {
        return this.price;
    }

    public double getSpecial() {
        return special;
    }


    public String toString() {
        DecimalFormat df2 = new DecimalFormat(".##");
        df2.setRoundingMode(RoundingMode.DOWN);
        if (special == 0) return name + "(" + size + ") " + "  " + df2.format(price) + "\t SEK";
        else return name + "(" + size + ") " + "  " + df2.format(special) + "\t SEK";
    }

}
