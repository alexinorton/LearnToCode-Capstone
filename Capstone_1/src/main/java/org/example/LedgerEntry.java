package org.example;

import java.time.LocalDateTime;

public class LedgerEntry {
    // 1. Variables
    private final String amount;
    private final String type;
    private final LocalDateTime timestamp;
    private final String description;

    // 2. Constructor
    public LedgerEntry(String amount, String type, String description) {
        this.amount = amount;
        this.type = type;
        this.description = description;
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

    // 6. Getter for description
    public String getDescription() {
        return description;
    }
}
