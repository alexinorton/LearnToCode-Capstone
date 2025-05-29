package com.pluralsight.delicious;

public class Drink implements Item {
    private String type;
    private String size;

    public Drink(String type, String size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 1.50;
            case "medium":
                return 2.00;
            case "large":
                return 2.50;
            default:
                return 0.00;
        }
    }

    @Override
    public String getReceiptText() {
        return size + " " + type + " - $" + String.format("%.2f", getPrice()) + "\n";
    }
}