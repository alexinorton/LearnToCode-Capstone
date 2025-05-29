package com.pluralsight.delicious;

public class Drink implements Item {
    private String name;
    private double price;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String getReceiptText() {
        return "Drink: " + name + " - $" + String.format("%.2f", price);
    }

    @Override
    public String toString() {
        return name + " ($" + String.format("%.2f", price) + ")";
    }
}