public class Transaction {
    // 1. Variables
    private String amount;
    private String type;

    // 2. Constructor
    public Transaction(String amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    // 3. Method for amount
    public String getAmount() {
        return amount;
    }

    // 4. Method for type
    public String getType() {
        return type;
    }
}
