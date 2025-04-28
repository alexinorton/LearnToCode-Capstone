import org.example.Transaction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;     // Keeps program running the loop
        ArrayList<Transaction> transactions = new ArrayList<>();

        while (running) {          // 1. Main menu loop
            System.out.println("\nWelcome to the Ledger App");
            System.out.println("\n-------------------------");
            System.out.println("\nEnter your choice: ");
            System.out.println("D) Make Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            // 2. Capture use input:
            String choice = scanner.nextLine();

            // 3. Process user input
            switch (choice.toUpperCase()) {
                case "D":   // 4. Deposit function
                    System.out.println("Enter deposit amount: ");
                    String depositAmount = scanner.nextLine();
                    Transaction deposit = new Transaction(depositAmount, "Deposit");
                    transactions.add(deposit);
                    System.out.println("You deposited: $" + depositAmount);
                    break;
                case "P":   // 5. Payment function
                    System.out.println("Enter payment amount: " );
                    String paymentAmount = scanner.nextLine();
                    Transaction payment = new Transaction(paymentAmount, "Payment");
                    transactions.add(payment);
                    System.out.println("You paid: $" + paymentAmount);
                    break;
                case "L":   // 6. Ledger function
                    System.out.println("\n***** Ledger *****");
                    for (Transaction t : transactions) {
                        System.out.println(t.getType() + ": $" + t.getAmount());
                    }
                    break;
                case "X":   // 7. Exit program
                    System.out.println("Exiting program.");
                    running = false;   // Stops the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
}