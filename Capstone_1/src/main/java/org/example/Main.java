package org.example;

import org.example.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;     // Saving to CSV
import java.io.IOException;    // Error control

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();
        boolean running = true;     // Keeps program running the loop

        while (running) {          // 1. Main menu loop
            System.out.println("\n~Welcome to the Ledger App~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\nB) ~> Check Balance");
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
                    break;
                case "D":   // 5. Deposit function
                    makeDeposit(scanner, transactions);
                    break;
                case "P":   // 6. Payment function
                    makePayment(scanner, transactions);
                    break;
                case "L":   // 7. Ledger function
                    ledgerMenu(scanner);
                    break;
                case "X":   // 8. Exit program
                    System.out.println("\n================================");
                    System.out.println(" Thank you for using Ledger App!");
                    System.out.println("      Have a great day  ");
                    System.out.println("================================\n");
                    running = false;   // Stops the loop
                    break;
                default:    // 9. Error clean up
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    // 10. Ledger Menu
    private static void ledgerMenu(Scanner scanner) {
        boolean inLedgerMenu = true;

        while (inLedgerMenu) {
            System.out.println("\n***** Ledger Menu *****");
            System.out.println("A) ~> View All Transactions");
            System.out.println("D) ~> View Deposits");
            System.out.println("P) ~> View Payments");
            System.out.println("R) ~> View Reports");
            System.out.println("H) ~> Main Menu");
            String ledgerChoice = scanner.nextLine().toUpperCase();

            switch (ledgerChoice) {
                case "A":
                    System.out.println("\nShowing all transactions:");     // CSV Entries
                    try (BufferedReader reader = new BufferedReader(new FileReader("ledger.csv"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 4) {
                                String amount = parts[0];
                                String type = parts[1];
                                String description = parts[2];
                                String timestamp = parts[3];
                                System.out.println(type + ": $" + amount + " for \"" + description + "\" at " + timestamp);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to find ledger file.");
                    }
                    break;
                case "D":
                    System.out.println("\nShowing all deposits:");
                    try (BufferedReader reader = new BufferedReader(new FileReader("ledger.csv"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 4 && parts[1].equalsIgnoreCase("Deposit")) {
                                String amount = parts[0];
                                String type = parts[1];

                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                    }
                    break;
                case "P":
                    System.out.println("\nShowing only payments:");
                    try (BufferedReader reader = new BufferedReader(new FileReader("ledger.csv"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 4 && parts[1].equalsIgnoreCase("Payment")) {
                                String amount = parts[0];
                                String type = parts[1];
                                String description = parts[2];
                                String timestamp = parts[3];
                                System.out.println(type + ": $" + amount + " for \"" + description + "\" at " + timestamp);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "R":
                    reportsMenu(scanner);
                    break;
                case "H":
                    inLedgerMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");


            }
        }
    }

    // 11. New method: Make Deposit
    private static void makeDeposit(Scanner scanner, ArrayList<Transaction> transactions) {
        System.out.println("Enter deposit amount: ");
        String depositAmount = scanner.nextLine();

        System.out.print("Enter deposit description/vendor: ");
        String description = scanner.nextLine();

        Transaction deposit = new Transaction(depositAmount, "Deposit", description);
        transactions.add(deposit);

        System.out.println("You have deposited: $" + depositAmount + " for \"" + description + "\"");

        // CSV Saving
        try (FileWriter writer = new FileWriter("ledger.csv", true)) {
            writer.write(depositAmount + ",Deposit," + description + deposit.getTimestamp() + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the deposit.");
            e.printStackTrace();
        }
    }

    // 12. New method: Make Payment
    private static void makePayment(Scanner scanner, ArrayList<Transaction> transactions) {
        System.out.println("Enter payment amount: ");
        String paymentAmount = scanner.nextLine();

        System.out.print("Enter payment description/vendor: ");
        String description = scanner.nextLine();

        Transaction payment = new Transaction(paymentAmount, "Payment", description);
        transactions.add(payment);
        System.out.println("You paid: $" + paymentAmount);

        // CSV Saving
        try (FileWriter writer = new FileWriter("ledger.csv", true)) {
            writer.write(paymentAmount + ",Payment," + description + payment.getTimestamp() +  "," + description + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the payment.");
            e.printStackTrace();
        }
    }

    // 13. Reports Menu
    private static void reportsMenu(Scanner scanner) {
        boolean inReportsMenu = true;

        while (inReportsMenu) {
            System.out.println("\n***** Reports Menu *****");
            System.out.println("1) ~> Month To Date");
            System.out.println("2) ~> Previous Month");
            System.out.println("3) ~> Yea-To-Date");
            System.out.println("4) ~> Previous Year");
            System.out.println("5) ~> Search by Vendor");
            System.out.println("0) ~> Back To Ledger Menu");
            String reportChoice = scanner.nextLine();

            switch (reportChoice) {
                case "1":
                    System.out.println("\nMonth to date transactions: ");
                    try (BufferedReader reader = new BufferedReader(new FileReader("ledger.csv"))) {
                        String line;
                        LocalDate today = LocalDate.now();
                        LocalDate firstOfMonth = today.withDayOfMonth(1);

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 3) {
                                String amount = parts[0];
                                String type = parts[1];
                                String timestamp = parts[2];

                                LocalDate date = LocalDate.parse(timestamp.substring(0,10));
                                if (!date.isBefore(firstOfMonth) && !date.isAfter(today)) {
                                    System.out.println(type + ": $" + amount + " at " + timestamp);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("\nPrevious month transactions:");
                    try (BufferedReader reader = new BufferedReader(new FileReader("ledger.csv"))) {
                        String line;
                        LocalDate today = LocalDate.now();
                        LocalDate firstOfThisMonth = today.withDayOfMonth(1);
                        LocalDate firstOfLastMonth = firstOfThisMonth.minusMonths(1);
                        LocalDate lastOfLastMonth = firstOfThisMonth.minusDays(1);

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 3) {
                                String amount = parts[0];
                                String type = parts[1];
                                String timestamp = parts[2];

                                LocalDate date = LocalDate.parse(timestamp.substring(0, 10));
                                if (!date.isBefore(firstOfLastMonth) && !date.isAfter(lastOfLastMonth)) {
                                    System.out.println(type + ": $" + amount + " at " + timestamp);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("\nYear to date Transactions: ");
                    try (BufferedReader reader = new BufferedReader(new FileReader("ledger.csv"))) {
                        String line;
                        LocalDate today = LocalDate.now();
                        LocalDate firstOfYear = today.withDayOfYear(1);

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 3) {
                                String amount = parts[0];
                                String type = parts[1];
                                String timestamp = parts[2];

                                LocalDate date = LocalDate.parse(timestamp.substring(0, 10));
                                if (!date.isBefore(firstOfYear) && !date.isAfter(today)) {
                                    System.out.println(type + ": $" + amount + " at " + timestamp);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("\nPrevious year transactions: ");
                    try (BufferedReader reader = new BufferedReader(new FileReader("ledger.csv"))) {
                        String line;
                        LocalDate today = LocalDate.now();
                        int lastYear = today.getYear() - 1;
                        LocalDate start = LocalDate.of(lastYear, 1, 1);
                        LocalDate end = LocalDate.of(lastYear, 12, 31);

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 3) {
                                String amount = parts[0];
                                String type = parts[1];
                                String timestamp = parts[2];

                                LocalDate date = LocalDate.parse(timestamp.substring(0, 10));
                                if (!date.isBefore(start) && !date.isAfter(end)) {
                                    System.out.println(type + ": $" + amount + " at " + timestamp);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    System.out.println("\nSearch by vendor name: ");
                    String vendorSearch = scanner.nextLine().toLowerCase();

                    System.out.println("\nTransactions from vendor: " + vendorSearch);

                    try (BufferedReader reader = new BufferedReader(new FileReader("ledger.csv"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 3) {
                                String amount = parts[0];
                                String type = parts[1];
                                String timestamp = parts[2];

                                if (type.toLowerCase().contains(vendorSearch)) {
                                    System.out.println(type + ": $" + amount + " at " + timestamp);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "0":
                    inReportsMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");

            }
        }
    }
}























