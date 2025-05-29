package com.pluralsight.delicious;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManager {
    public void saveReceipts(List<Item> items, double subtotal, double tax, double total) {
        try {
            // Create timestamped filename
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String filename = "receipts/receipt_" + timestamp + ".txt";

            FileWriter writer = new FileWriter(filename);

            writer.write("================== RECEIPT ==================\n");
            for (Item item : items) {
                writer.write("- " + item.getReceiptText() + "\n");
            }
            writer.write("---------------------------------------------\n");
            writer.write(String.format("%-35s $%6.2f%n", "Subtotal:", subtotal));
            writer.write(String.format("%-35s $%6.2f%n", "Tax (10%):", tax));
            writer.write(String.format("%-35s $%6.2f%n", "Total:", total));
            writer.write("=============================================\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
