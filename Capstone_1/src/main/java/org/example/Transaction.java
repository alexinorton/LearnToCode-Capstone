package org.example;

import java.time.LocalDateTime;

public class Transaction {
    // 1. Variables
    private final String amount;
    private final String type;
    private final LocalDateTime timestamp;

    // 2. Constructor
    public Transaction(String amount, String type) {
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    // 3. Getter for amount
    public String getAmount() {
        return amount;
    }

    // 4. Getter for type
    public String getType() {
        return type;
    }

    // 5. Getter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
