package com.pluralsight.delicious;

import java.util.ArrayList;

public class Sandwich implements Item {
    private String size;
    private String bread;
    private String meat;
    private boolean extraMeat;
    private String cheese;
    private boolean extraCheese;
    private ArrayList<String> toppings;
    private ArrayList<String> sauces;

    public Sandwich(String size, String bread, String meat, boolean extraMeat, String cheese,
                    boolean extraCheese, ArrayList<String> toppings, ArrayList<String> sauces) {
        this.size = size;
        this.bread = bread;
        this.meat = meat;
        this.extraMeat = extraMeat;
        this.cheese = cheese;
        this.extraCheese = extraCheese;
        this.toppings = toppings;
        this.sauces = sauces;
    }

    @Override
    public double getPrice() {
        double basePrice;
        switch (size) {
            case "4":
                basePrice = 5.50;
                break;
            case "8":
                basePrice = 7.00;
                break;
            case "12":
                basePrice = 8.50;
                break;
            default:
                basePrice = 0;
        }

        if (extraMeat) {
            switch (size) {
                case "4":
                    basePrice += 1.00;
                    break;
                case "8":
                    basePrice += 2.00;
                    break;
                case "12":
                    basePrice += 3.00;
                    break;
            }
        }

        if (extraCheese) {
            switch (size) {
                case "4":
                    basePrice += 0.75;
                    break;
                case "8":
                    basePrice += 1.50;
                    break;
                case "12":
                    basePrice += 2.25;
                    break;
            }
        }

        return basePrice;
    }

    @Override
    public String getReceiptText() {
        StringBuilder receipt = new StringBuilder();
        receipt.append(size).append("\" ").append(meat).append(" Sandwich on ").append(bread).append("\n");
        receipt.append("Cheese: ").append(cheese).append(extraCheese ? " (extra)" : "").append("\n");
        if (extraMeat) {
            receipt.append("Extra meat added\n");
        }
        if (!toppings.isEmpty()) {
            receipt.append("Toppings: ").append(String.join(", ", toppings)).append("\n");
        }
        if (!sauces.isEmpty()) {
            receipt.append("Sauces: ").append(String.join(", ", sauces)).append("\n");
        }
        receipt.append(String.format("Price: $%.2f\n", getPrice()));
        return receipt.toString();
    }
}
