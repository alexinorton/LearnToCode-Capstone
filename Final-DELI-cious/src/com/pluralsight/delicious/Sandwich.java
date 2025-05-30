package com.pluralsight.delicious;

import java.util.List;

public class Sandwich implements Item {
    private int size;
    private String meat;
    private String cheese;
    private List<String> toppings;
    private List<String> extraToppings;
    private String sauce;
    private double price;
    private boolean extraMeat;
    private boolean extraCheese;
    private boolean toasted;

    public Sandwich(int size, String meat, String cheese, List<String> toppings, double price) {
        this.size = size;
        this.meat = meat;
        this.cheese = cheese;
        this.toppings = toppings;
        this.price = price;
        this.extraToppings = new java.util.ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public String getMeat() {
        return meat;
    }

    public String getCheese() {
        return cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<String> getExtraToppings() {
        return extraToppings;
    }

    public void setExtraToppings(List<String> extraToppings) {
        this.extraToppings = extraToppings;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasExtraMeat() {
        return extraMeat;
    }

    public boolean hasExtraCheese() {
        return extraCheese;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public String getName() {
        return size + "\" " + meat + " Sandwich";
    }

    @Override
    public String getReceiptText() {
        StringBuilder text = new StringBuilder();
        text.append(size).append("\" Sandwich: ").append(meat).append(", ").append(cheese);
        text.append("\n  Toppings: ").append(toppings);

        if (extraToppings.size() > 0) {
            text.append("\n  Extra Toppings: ").append(extraToppings);
        }

        if (sauce != null && !sauce.isEmpty()) {
            text.append("\n  Sauce: ").append(sauce);
        }

        if (extraMeat) {
            double extraMeatCost = 0.0;
            if (size == 4) {
                extraMeatCost = 0.50;
            } else if (size == 8) {
                extraMeatCost = 1.00;
            } else if (size == 12) {
                extraMeatCost = 1.50;
            }
            text.append(String.format("\n  + Extra Meat ($%.2f)", extraMeatCost));
        }

        if (extraCheese) {
            double extraCheeseCost = 0.0;
            if (size == 4) {
                extraCheeseCost = 0.30;
            } else if (size == 8) {
                extraCheeseCost = 0.60;
            } else if (size == 12) {
                extraCheeseCost = 0.90;
            }
            text.append(String.format("\n  + Extra Cheese ($%.2f)", extraCheeseCost));
        }

        if (toasted) {
            text.append("\n  + Toasted");
        }

        text.append(String.format("\n  Total: $%.2f", price));
        return text.toString();
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}