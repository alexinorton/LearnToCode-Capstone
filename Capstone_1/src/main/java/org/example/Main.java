package org.example;

import org.example.Transaction;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;     // Keeps program running the loop
        ArrayList<Transaction> transactions = new ArrayList<>();

        while (running) {          // 1. org.example.Main menu loop
            System.out.println("\n~Welcome to the Ledger App~");
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\n Enter your choice: ");
            System.out.println("B) ~> Check Balance");
            System.out.println("D) ~> Make Deposit");
            System.out.println("P) ~> Make Payment");
            System.out.println("L) ~> Ledger");
            System.out.println("X) ~> Exit");

            // 2. Capture use input:
            String choice = scanner.nextLine();

            // 3. Process user input
            switch (choice.toUpperCase()) {
                case "B":   // 4. Check Balance
                    double balance = 0.00;
                    for (Transaction t : transactions) {
                        if (t.getType().equalsIgnoreCase("Deposit")) {
                            balance += Double.parseDouble(t.getAmount());
                        } else if (t.getType().equalsIgnoreCase("Payment")) {
                            balance -= Double.parseDouble(t.getAmount());
                        }
                    }
                    System.out.printf("Your Balance is: $%.2f%n", balance);
                    scanner.nextLine();
                case "D":   // 5. Deposit function
                    System.out.println("Enter deposit amount: ");
                    String depositAmount = scanner.nextLine();
                    Transaction deposit = new Transaction(depositAmount, "Deposit");
                    transactions.add(deposit);
                    System.out.println("You have deposited: $" + depositAmount);
                    break;
                case "P":   // 6. Payment function
                    System.out.println("Enter payment amount: " );
                    String paymentAmount = scanner.nextLine();
                    Transaction payment = new Transaction(paymentAmount, "Payment");
                    transactions.add(payment);
                    System.out.println("You paid: $" + paymentAmount);
                    break;
                case "L":   // 7. Ledger function
                    System.out.println("\n***** Ledger *****");
                    for (Transaction t : transactions) {
                        System.out.println(t.getType() + ": $" + t.getAmount() + " at " + t.getTimestamp());
                    }
                    break;
                case "X":   // 8. Exit program
                    System.out.println("Exiting program.");
                    running = false;   // Stops the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
}