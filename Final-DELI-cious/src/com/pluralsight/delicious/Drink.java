package com.pluralsight.delicious;
public class Drink implements Item {
    private String name;
    private String size;
    private double price;

    public Drink(String name, String size) {
        this.name = name;
        this.size = size;

        if (size.equals("Small")) {
            this.price = 1.50;
        } else if (size.equals("Medium")) {
            this.price = 2.00;
        } else if (size.equals("Large")) {
            this.price = 2.50;
        } else {
            System.out.println("Invalid drink size: " + size);
            this.price = 0.0; // Just in case, so app doesn't crash
        }
    }





    @Override
    public String getName() {
        return name + " (" + size + ")";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getReceiptText() {
        return "Drink: " + name + " (" + size + ") - $" + String.format("%.2f", price);
    }

    @Override
    public String toString() {
        return getReceiptText();
    }
}