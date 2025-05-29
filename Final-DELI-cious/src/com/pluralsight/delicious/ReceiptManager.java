package com.pluralsight.delicious;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManager {

    public void saveReceipts(List<Item> items, double subtotal, double tax, double total) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String filename = "receipt_" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("===== DELI-cious Receipt =====\n");
            writer.write("Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            for (Item item : items) {
                writer.write(item.getReceiptText() + "\n");
            }

            writer.write(String.format("Subtotal: $%.2f%n", subtotal));
            writer.write(String.format("Tax: $%.2f%n", tax));
            writer.write(String.format("Total: $%.2f%n", total));

            System.out.println("Receipt saved as " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
