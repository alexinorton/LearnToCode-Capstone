package org.example;

import java.io.BufferedReader;  // Read files
import java.io.FileReader;      // Write data to a file
import java.time.LocalDate;     // Get current date
import java.util.ArrayList;     // Store list of transactions
import java.util.Scanner;       // Read user input
import java.io.FileWriter;      // Saving to CSV
import java.io.IOException;     // Error control
import java.util.Collections;   // Reverse order

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<LedgerEntry> ledgerEntries = new ArrayList<>();
        boolean running = true;     // Keeps program running the loop


        while (running) {          // Main menu loop
            System.out.println("\n~Welcome to the Ledger App~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\nB) ~> Check Balance");
            System.out.println("D) ~> Make Deposit");
            System.out.println("P) ~> Make Payment");
            System.out.println("L) ~> Ledger");
            System.out.println("X) ~> Exit");

            // Capture use input:
            String choice = scanner.nextLine();


            // Process user input
            switch (choice.toUpperCase()) {
                case "B":   // Check Balance
                    double balance = 0.00;
                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split("\\|");
                            if (parts.length == 5) {
                                String amount = parts[4];
                                String type = parts[2];
                                if (type.equalsIgnoreCase("Deposit")) {
                                    balance += Double.parseDouble(amount);
                                } else if (type.equalsIgnoreCase("Payment")) {
                                    balance -= Double.parseDouble(amount);
                                }
                            }
                        }
                        System.out.printf("Your Balance is: $%.2f%n", balance);
                    } catch (IOException e) {
                        System.out.println("Unable to calculate balance.");
                        e.printStackTrace();
                    }
                    break;
                case "D":   // Deposit function
                    makeDeposit(scanner, ledgerEntries);
                    break;
                case "P":   // Payment function
                    makePayment(scanner, ledgerEntries);
                    break;
                case "L":   // Ledger function
                    ledgerMenu(scanner);
                    break;
                case "X":   // Exit program
                    System.out.println("\n================================");
                    System.out.println(" Thank you for using Ledger App!");
                    System.out.println("      Have a great day  ");
                    System.out.println("================================\n");
                    running = false;   // Stops the loop
                    break;
                default:    // Error clean up
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }


    // Ledger Menu
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
                case "A":     // View All Transactions
                    System.out.println("\nShowing all transactions:");
                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                    System.out.println("----------------------------------------------------------------");

                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        ArrayList<String> lines = new ArrayList<>();

                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }
                        Collections.reverse(lines);

                        for (String reversedLine : lines) {
                            String[] parts = reversedLine.split("\\|");
                            if (parts.length == 5) {
                                String date = parts[0];
                                String time = parts[1];
                                String description = parts[2];
                                String vendor = parts[3];
                                String amount = parts[4];

                                System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", date, time, description, vendor, amount);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to find ledger file.");
                    }
                    break;
                case "D":     // View Deposits
                    System.out.println("\nShowing all deposits:");
                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                    System.out.println("----------------------------------------------------------------");

                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        ArrayList<String> lines = new ArrayList<>();
                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }
                        Collections.reverse(lines);

                        for (String reversedLine : lines) {
                            String[] parts = reversedLine.split("\\|");
                            if (parts.length == 5 && parts[2].equalsIgnoreCase("Deposit")) {
                                String date = parts[0];
                                String time = parts[1];
                                String description = parts[2];
                                String vendor = parts[3];
                                String amount = parts[4];
                                System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", date, time, description, vendor, amount);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                    }
                    break;
                case "P":     // View Payments
                    System.out.println("\nShowing all payments:");
                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                    System.out.println("----------------------------------------------------------------");

                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        ArrayList<String> lines = new ArrayList<>();
                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }
                        Collections.reverse(lines);


                        for (String reversedLine : lines) {
                            String[] parts = reversedLine.split("\\|");
                            if (parts.length == 5 && parts[2].equalsIgnoreCase("Deposit")) {
                                String date = parts[0];
                                String time = parts[1];
                                String description = parts[2];
                                String vendor = parts[3];
                                String amount = parts[4];
                                System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", date, time, description, vendor, amount);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "R":     // View Reports menu
                    reportsMenu(scanner);
                    break;
                case "H":     // Home menu
                    inLedgerMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");


            }
        }
    }




    // New method: Make Deposit
    private static void makeDeposit(Scanner scanner, ArrayList<LedgerEntry> ledgerEntries) {
        System.out.println("Enter deposit amount: ");
        String depositAmount = scanner.nextLine();

        System.out.print("Enter deposit description: ");
        String description = scanner.nextLine();

        System.out.print("Enter deposit vendor: ");
        String vendor = scanner.nextLine();

        LedgerEntry deposit = new LedgerEntry(depositAmount, "Deposit", description);

        System.out.println("You have deposited: $" + depositAmount + " for \"" + description + "\"");

        // CSV Saving
        try (FileWriter writer = new FileWriter("Transactions.csv", true)) {
            String[] timestampParts = deposit.getTimestamp().toString().split("T");
            writer.write(timestampParts[0] + "|" + timestampParts[1] + "|Deposit|" + vendor + "|" + depositAmount + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the deposit.");
            e.printStackTrace();
        }
    }

    // New method: Make Payment
    private static void makePayment(Scanner scanner, ArrayList<LedgerEntry> ledgerEntries) {
        System.out.println("Enter payment amount: ");
        String paymentAmount = scanner.nextLine();

        System.out.print("Enter payment description: ");
        String description = scanner.nextLine();

        System.out.print("Enter payment vendor: ");
        String vendor = scanner.nextLine();

        LedgerEntry payment = new LedgerEntry(paymentAmount, "Payment", description);
        System.out.println("You paid: $" + paymentAmount);

        // CSV Saving
        try (FileWriter writer = new FileWriter("Transactions.csv", true)) {
            String[] timestampParts = payment.getTimestamp().toString().split("T");
            writer.write(timestampParts[0] + "|" + timestampParts[1] + "|Payment|" + vendor + "|" + paymentAmount + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the payment.");
            e.printStackTrace();
        }
    }

    // Reports Menu
    private static void reportsMenu(Scanner scanner) {
        boolean inReportsMenu = true;

        while (inReportsMenu) {
            System.out.println("\n***** Reports Menu *****");
            System.out.println("1) ~> Month To Date");
            System.out.println("2) ~> Previous Month");
            System.out.println("3) ~> Year-To-Date");
            System.out.println("4) ~> Previous Year");
            System.out.println("5) ~> Search by Vendor");
            System.out.println("0) ~> Back To Ledger Menu");
            String reportChoice = scanner.nextLine().toUpperCase();

            switch (reportChoice) {
                case "1":     // Month to date
                    System.out.println("\nMonth to date transactions:");
                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                    System.out.println("----------------------------------------------------------------");

                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        LocalDate today = LocalDate.now();
                        LocalDate firstOfMonth = today.withDayOfMonth(1);

                        ArrayList<String> lines = new ArrayList<>();
                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }
                        Collections.reverse(lines);

                        for (String reversedLine : lines) {
                            String[] parts = reversedLine.split("\\|");
                            if (parts.length == 5) {
                                String dateStr = parts[0];
                                String time = parts[1];
                                String description = parts[2];
                                String vendor = parts[3];
                                String amount = parts[4];

                                LocalDate date = LocalDate.parse(dateStr);
                                if (!date.isBefore(firstOfMonth) && !date.isAfter(today)) {
                                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", dateStr, time, description, vendor, amount);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "2":     // Previous month
                    System.out.println("\nPrevious month transactions:");
                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                    System.out.println("----------------------------------------------------------------");

                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        LocalDate today = LocalDate.now();
                        LocalDate firstOfThisMonth = today.withDayOfMonth(1);
                        LocalDate firstOfLastMonth = firstOfThisMonth.minusMonths(1);
                        LocalDate lastOfLastMonth = firstOfThisMonth.minusDays(1);

                        ArrayList<String> lines = new ArrayList<>();
                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }
                        Collections.reverse(lines);

                        for (String reversedLine : lines) {
                            String[] parts = reversedLine.split("\\|");
                            if (parts.length == 5) {
                                String dateStr = parts[0];
                                String time = parts[1];
                                String description = parts[2];
                                String vendor = parts[3];
                                String amount = parts[4];

                                LocalDate date = LocalDate.parse(dateStr);
                                if (!date.isBefore(firstOfLastMonth) && !date.isAfter(lastOfLastMonth)) {
                                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", dateStr, time, description, vendor, amount);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "3":     // Year to date
                    System.out.println("\nYear to date transactions:");
                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                    System.out.println("----------------------------------------------------------------");

                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        LocalDate today = LocalDate.now();
                        LocalDate firstOfYear = today.withDayOfYear(1);

                        ArrayList<String> lines = new ArrayList<>();
                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }
                        Collections.reverse(lines);

                        for (String reversedLine : lines) {
                            String[] parts = reversedLine.split("\\|");
                            if (parts.length == 5) {
                                String dateStr = parts[0];
                                String time = parts[1];
                                String description = parts[2];
                                String vendor = parts[3];
                                String amount = parts[4];

                                LocalDate date = LocalDate.parse(dateStr);
                                if (!date.isBefore(firstOfYear) && !date.isAfter(today)) {
                                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", dateStr, time, description, vendor, amount);
                                }
                            }
                        }


                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "4":     // Previous year
                    System.out.println("\nPrevious year transactions:");
                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                    System.out.println("----------------------------------------------------------------");

                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        LocalDate today = LocalDate.now();
                        int lastYear = today.getYear() - 1;
                        LocalDate start = LocalDate.of(lastYear, 1, 1);
                        LocalDate end = LocalDate.of(lastYear, 12, 31);

                        ArrayList<String> lines = new ArrayList<>();
                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }
                        Collections.reverse(lines);

                        for (String reversedLine : lines) {
                            String[] parts = reversedLine.split("\\|");
                            if (parts.length == 5) {
                                String dateStr = parts[0];
                                String time = parts[1];
                                String description = parts[2];
                                String vendor = parts[3];
                                String amount = parts[4];

                                LocalDate date = LocalDate.parse(dateStr);
                                if (!date.isBefore(start) && !date.isAfter(end)) {
                                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", dateStr, time, description, vendor, amount);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "5":     // Search by vendor
                    System.out.println("\nSearch by vendor name: ");
                    String vendorSearch = scanner.nextLine().toLowerCase();

                    System.out.println("\nTransactions from vendor: " + vendorSearch);
                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                    System.out.println("----------------------------------------------------------------");

                    try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
                        String line;
                        ArrayList<String> lines = new ArrayList<>();

                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }
                        Collections.reverse(lines);

                        for (String reversedLine : lines) {
                            String[] parts = reversedLine.split("\\|");
                            if (parts.length == 5) {
                                String dateStr = parts[0];
                                String time = parts[1];
                                String description = parts[2];
                                String vendor = parts[3];
                                String amount = parts[4];

                                if (vendor.toLowerCase().contains(vendorSearch)) {
                                    System.out.printf("%-12s %-10s %-20s %-15s $%-10s%n", dateStr, time, description, vendor, amount);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Unable to read ledger file.");
                        e.printStackTrace();
                    }
                    break;
                case "0":     // Returns to Ledger menu
                    inReportsMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");

            }
        }
    }
}























