import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;     // Keeps program running the loop

        while (running) {          // 1. Main menu loop
            System.out.println("\nWelcome to the Ledger App");
            System.out.println("\n-------------------------");
            System.out.println("\nEnter your choice: ");
            System.out.println("D) Make Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            // Capture use input:
            String choice = scanner.nextLine();

            // Process user input
            switch (choice.toUpperCase()) {
                case "D":
                    System.out.println("You chose Make Deposit.");
                    break;
                case "P":
                    System.out.println("You chose to Make Payment.");
                    break;
                case "L":
                    System.out.println("You chose to view Ledger");
                    break;
                case "X":
                    System.out.println("Exiting program.");
                    running = false;   // Stops the loop
                    break;;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
}