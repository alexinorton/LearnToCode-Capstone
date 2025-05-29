package com.pluralsight.delicious;

public class Main {
    private static final double TAX_RATE = 0.10;

    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        Order order = orderManager.createOrder();

        double subtotal = order.calculateSubtotal();
        double taxAmount = subtotal * TAX_RATE;
        double total = subtotal + taxAmount;

        System.out.println("\n================== RECEIPT ==================");
        for (Item item : order.getItems()) {
            System.out.println("- " + item.getReceiptText());
        }

        System.out.println("---------------------------------------------");
        System.out.printf("%-35s $%6.2f%n", "Subtotal:", subtotal);
        System.out.printf("%-35s $%6.2f%n", "Tax (10%):", taxAmount);
        System.out.printf("%-35s $%6.2f%n", "Total:", total);

        System.out.println("\nThank you for choosing DELI-cious Sandwiches!");
        System.out.println("=============================================");

        ReceiptManager receiptManager = new ReceiptManager();
        receiptManager.saveReceipts(order.getItems(), subtotal, taxAmount, total);
    }
}