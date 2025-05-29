package com.pluralsight.delicious;

public class Chip implements Item {
    private String type;

    public Chip(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return 1.25;
    }

    @Override
    public String getReceiptText() {
        return type + " Chips - $" + String.format("%.2f", getPrice()) + "\n";
    }
}