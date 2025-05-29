package com.pluralsight.delicious;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        ReceiptManager receiptManager = new ReceiptManager();      // Git test

        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("   WELCOME TO DELI-cious");
            System.out.println("===================================");
            System.out.println("1. Start New Order");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Order order = orderManager.startOrder();
                    double subtotal = order.calculateSubtotal();
                    double taxAmount = subtotal * OrderManager.TAX_RATE;
                    double total = subtotal + taxAmount;

                    receiptManager.saveReceipts(order.getItems(), subtotal, taxAmount, total);

                    System.out.printf("Subtotal: $%.2f\n", subtotal);
                    System.out.printf("Tax (%.1f%%): $%.2f\n", OrderManager.TAX_RATE * 100, taxAmount);
                    System.out.printf("Total: $%.2f\n", total);
                    System.out.println("Thank you for your order!\n");
                    break;
                case "2":
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}