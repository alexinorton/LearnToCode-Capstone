package com.pluralsight.delicious;

public class Chip implements Item {
    private String name;
    private double price;

    public Chip(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getReceiptText() {
        return "Chips: " + name + " - $" + String.format("%.2f", price);
    }

    @Override
    public String toString() {
        return name + " ($" + String.format("%.2f", price) + ")";
    }
}