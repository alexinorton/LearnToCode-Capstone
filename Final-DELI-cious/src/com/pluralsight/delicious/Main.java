package com.pluralsight.delicious;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        Order order = orderManager.createOrder();

        // Calculate subtotal
        List<Item> items = order.getItems();
        double subtotal = 0;
        for (Item item : items) {
            subtotal += item.getPrice();
        }

        // Calculate tax and total
        double taxRate = 0.10; // 10%
        double taxAmount = subtotal * taxRate;
        double total = subtotal + taxAmount;

        // Print receipt to screen
        System.out.println("\n================ RECEIPT ================");
        for (Item item : items) {
            System.out.println("- " + item.getReceiptText());
        }
        System.out.println("-----------------------------------------");
        System.out.printf("Subtotal:%29s $%.2f%n", "", subtotal);
        System.out.printf("Tax (10%%):%28s $%.2f%n", "", taxAmount);
        System.out.printf("Total:%32s $%.2f%n", "", total);
        System.out.println("\nThank you for choosing DELI-cious Sandwiches!");
        System.out.println("===========================================");

        // Save receipt to file
        ReceiptManager receiptManager = new ReceiptManager();
        receiptManager.saveReceipt(order.getItems(), subtotal, taxAmount, total);
    }
}