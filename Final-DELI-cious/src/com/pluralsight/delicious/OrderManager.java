package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager {
    public static final double TAX_RATE = 0.10;
    private Scanner scanner = new Scanner(System.in);

    public Order startOrder() {
        Order order = new Order();

        boolean addingItems = true;
        while (addingItems) {
            System.out.println("\nChoose an item to add:");
            System.out.println("1. Sandwich");
            System.out.println("2. Drink");
            System.out.println("3. Chips");
            System.out.println("4. Finish Order");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Sandwich sandwich = buildSandwich();
                    order.addItem(sandwich);
                    break;
                case "2":
                    Drink drink = buildDrink();
                    order.addItem(drink);
                    break;
                case "3":
                    Chip chip = buildChip();
                    order.addItem(chip);
                    break;
                case "4":
                    addingItems = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        return order;
    }

    private Sandwich buildSandwich() {
        System.out.println("\n=== Build Your Sandwich ===");

        String size = prompt("Size (4\", 8\", 12\"): ", new String[]{"4", "8", "12"});
        String bread = prompt("Bread (White, Wheat, Rye, Wrap): ", new String[]{"White", "Wheat", "Rye", "Wrap"});
        String meat = prompt("Meat (Steak, Ham, Turkey, Chicken, Roast Beef): ");
        boolean extraMeat = yesNo("Extra meat? (yes/no): ");
        String cheese = prompt("Cheese (American, Provolone, Cheddar, Swiss): ");
        boolean extraCheese = yesNo("Extra cheese? (yes/no): ");

        ArrayList<String> toppings = new ArrayList<>();
        System.out.println("Add regular toppings (Lettuce, Tomato, Onion, Pickles, Peppers, Cucumbers, Olives, Spinach). Type 'done' to finish:");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            toppings.add(topping);
        }

        boolean wantsExtraToppings = yesNo("Do you want premium toppings? (yes/no): ");
        if (wantsExtraToppings) {
            System.out.println("Available premium toppings: Bacon, Avocado, Jalapenos, Mushrooms");
            System.out.println("Type each topping and press Enter. Type 'done' to finish:");
            while (true) {
                String extraTopping = scanner.nextLine();
                if (extraTopping.equalsIgnoreCase("done")) break;
                toppings.add(extraTopping + " (premium)");
            }
        }

        ArrayList<String> sauces = new ArrayList<>();
        System.out.println("Add sauces (Mayo, Mustard, Ketchup, Oil, Vinegar, Ranch, Thousand Island). Type 'done' to finish:");
        while (true) {
            String sauce = scanner.nextLine();
            if (sauce.equalsIgnoreCase("done")) break;
            sauces.add(sauce);
        }

        return new Sandwich(size, bread, meat, extraMeat, cheese, extraCheese, toppings, sauces);
    }

    private Drink buildDrink() {
        System.out.println("\n=== Choose Your Drink ===");

        String type = prompt("Type (Soda, Water, Coffee, Apple Juice): ", new String[]{"Soda", "Water", "Coffee", "Apple Juice"});
        String size = prompt("Size (Small, Medium, Large): ", new String[]{"Small", "Medium", "Large"});

        return new Drink(type, size);
    }

    private Chip buildChip() {
        System.out.println("\n=== Choose Your Chips ===");

        String type = prompt("Type (Doritos, Lays, Sun Chips): ", new String[]{"Doritos", "Lays", "Sun Chips"});
        return new Chip(type);
    }

    private String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private String prompt(String message, String[] validOptions) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine();
            for (String option : validOptions) {
                if (option.equalsIgnoreCase(input)) return input;
            }
            System.out.println("Invalid option. Try again.");
        }
    }

    private boolean yesNo(String message) {
        System.out.print(message);
        String input = scanner.nextLine().toLowerCase();
        return input.startsWith("y");
    }
}