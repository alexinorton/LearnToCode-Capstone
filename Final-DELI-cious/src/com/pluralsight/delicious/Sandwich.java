package com.pluralsight.delicious;

import java.util.List;

public class Sandwich implements Item {
    private int size;
    private String meat;
    private String cheese;
    private List<String> toppings;
    private List<String> extraToppings;
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

    @Override
    public String getName() {
        return size + "\" " + meat + " Sandwich";
    }

    @Override
    public String getReceiptText() {
        StringBuilder text = new StringBuilder();
        text.append(size).append("\" Sandwich: ").append(meat).append(", ").append(cheese);
        text.append(", Toppings: ").append(toppings);

        if (!extraToppings.isEmpty()) {
            text.append(", Extra Toppings: ").append(extraToppings);
        }
        if (extraMeat) {
            text.append(" + extra meat");
        }
        if (extraCheese) {
            text.append(" + extra cheese");
        }
        if (toasted) {
            text.append(", toasted");
        }

        text.append(String.format(" - $%.2f", price));
        return text.toString();
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}