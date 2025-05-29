package com.pluralsight.delicious;

public class Drink implements Item {
    private String name;
    private double price;

    public Drink(String name, String size) {
        this.name = name;

        switch (size) {
            case "Small":
                this.price = 1.50;
                break;
            case "Medium":
                this.price = 2.00;
                break;
            case "Large":
                this.price = 2.50;
                break;
            default:
                System.out.println("Invalid size. Defaulting to Medium.");
                this.price = 2.00;
        }
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
        return name + " - $" + String.format("%.2f", price);
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}