package com.pluralsight.delicious;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManager {
    public void saveReceipt(List<Item> items, double subtotal, double taxAmount, double total) {
        try {
            // Format timestamp
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String timestamp = LocalDateTime.now().format(formatter);

            // Set file path
            String fileName = "receipts/receipt_" + timestamp + ".txt";

            // Create file writer
            FileWriter writer = new FileWriter(fileName);

            // Write header
            writer.write("============== RECEIPT ==============\n");

            // Write each item
            for (Item item : items) {
                writer.write("- " + item.getReceiptText() + "\n");
            }

            // Write totals
            writer.write("-------------------------------------\n");
            writer.write(String.format("Subtotal:%29s $%.2f%n", "", subtotal));
            writer.write(String.format("Tax (10%%):%28s $%.2f%n", "", taxAmount));
            writer.write(String.format("Total:%32s $%.2f%n", "", total));


            writer.write("\nThank you for choosing DELI-cious Sandwiches!\n");
            writer.write("============================================\n");


            writer.close();
            System.out.println("Receipt saved: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
