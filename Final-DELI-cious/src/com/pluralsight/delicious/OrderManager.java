package com.pluralsight.delicious;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
    private Scanner scanner = new Scanner(System.in);

    public Order createOrder() {
        Order order = new Order();

        System.out.println("=====================================");
        System.out.println("     WELCOME TO DELI-cious SANDWICHES");
        System.out.println("=====================================");

        boolean ordering = true;

        while (ordering) {
            System.out.println("\nWhat would you like to add?");
            System.out.println("1) Sandwich");
            System.out.println("2) Drink");
            System.out.println("3) Chips");
            System.out.println("4) Finish Order");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> order.addItem(buildSandwich());
                case "2" -> order.addItem(buildDrink());
                case "3" -> order.addItem(buildChips());
                case "4" -> ordering = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        return order;
    }

    private Sandwich buildSandwich() {
        int size = 8;
        while (true) {
            try {
                System.out.println("\nChoose your sandwich size:");
                System.out.println("1) 4 inch");
                System.out.println("2) 8 inch");
                System.out.println("3) 12 inch");
                System.out.print("Enter your choice: ");
                String sizeChoice = scanner.nextLine();

                size = switch (sizeChoice) {
                    case "1" -> 4;
                    case "2" -> 8;
                    case "3" -> 12;
                    default -> throw new IllegalArgumentException("Invalid size.");
                };
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        }

        double basePrice = switch (size) {
            case 4 -> 5.00;
            case 8 -> 7.00;
            case 12 -> 9.00;
            default -> 7.00;
        };

        String meat = "";
        while (true) {
            System.out.println("\nChoose your meat:");
            System.out.println("1) Ham");
            System.out.println("2) Turkey");
            System.out.println("3) Roast Beef");
            System.out.println("4) Bacon");
            System.out.println("5) Chicken");
            System.out.println("6) Pastrami");
            System.out.print("Enter your choice: ");
            String meatChoice = scanner.nextLine();
            meat = switch (meatChoice) {
                case "1" -> "Ham";
                case "2" -> "Turkey";
                case "3" -> "Roast Beef";
                case "4" -> "Bacon";
                case "5" -> "Chicken";
                case "6" -> "Pastrami";
                default -> null;
            };
            if (meat != null) break;
            System.out.println("Invalid choice. Please enter 1–6.");
        }

        System.out.print("Would you like extra meat? (yes/no): ");
        String extraMeatInput = scanner.nextLine();
        boolean extraMeat = extraMeatInput.equalsIgnoreCase("yes");

        double extraMeatCost = switch (size) {
            case 4 -> extraMeat ? 0.50 : 0.00;
            case 8 -> extraMeat ? 1.00 : 0.00;
            case 12 -> extraMeat ? 1.50 : 0.00;
            default -> 0.00;
        };

        String cheese = "";
        while (true) {
            System.out.println("\nChoose your cheese:");
            System.out.println("1) American");
            System.out.println("2) Provolone");
            System.out.println("3) Cheddar");
            System.out.println("4) Swiss");
            System.out.println("5) Pepper Jack");
            System.out.print("Enter your choice: ");
            String cheeseChoice = scanner.nextLine();
            cheese = switch (cheeseChoice) {
                case "1" -> "American";
                case "2" -> "Provolone";
                case "3" -> "Cheddar";
                case "4" -> "Swiss";
                case "5" -> "Pepper Jack";
                default -> null;
            };
            if (cheese != null) break;
            System.out.println("Invalid choice. Please enter 1–5.");
        }

        System.out.print("Would you like extra cheese? (yes/no): ");
        String extraCheeseInput = scanner.nextLine();
        boolean extraCheese = extraCheeseInput.equalsIgnoreCase("yes");

        double extraCheeseCost = switch (size) {
            case 4 -> extraCheese ? 0.30 : 0.00;
            case 8 -> extraCheese ? 0.60 : 0.00;
            case 12 -> extraCheese ? 0.90 : 0.00;
            default -> 0.00;
        };

        ArrayList<String> toppings = new ArrayList<>();
        System.out.println("\nAdd your regular toppings (lettuce, tomato, pickles, etc.):");
        System.out.println("Type 'done' when finished:");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            toppings.add(topping);
        }

        List<String> extraToppings = new ArrayList<>();
        System.out.print("Would you like to add extra toppings? (yes/no): ");
        String extraToppingAnswer = scanner.nextLine();
        if (extraToppingAnswer.equalsIgnoreCase("yes")) {
            System.out.println("Enter each extra topping. Type 'done' when finished:");
            while (true) {
                String extra = scanner.nextLine();
                if (extra.equalsIgnoreCase("done")) break;
                extraToppings.add(extra);
            }
        }

        double totalPrice = basePrice + extraMeatCost + extraCheeseCost;

        Sandwich sandwich = new Sandwich(size, meat, cheese, toppings, totalPrice);
        sandwich.setExtraMeat(extraMeat);
        sandwich.setExtraCheese(extraCheese);
        sandwich.setExtraToppings(extraToppings);

        System.out.print("Would you like your sandwich toasted? (yes/no): ");
        String toastInput = scanner.nextLine();
        boolean toasted = toastInput.equalsIgnoreCase("yes");
        sandwich.setToasted(toasted);

        return sandwich;
    }

    private Drink buildDrink() {
        System.out.println("\nChoose a drink:");
        System.out.println("1) Coffee");
        System.out.println("2) Apple Juice");
        System.out.println("3) Water");
        System.out.println("4) Soda");
        System.out.print("Enter your drink choice: ");
        String drinkType = scanner.nextLine();

        String name = switch (drinkType) {
            case "1" -> "Coffee";
            case "2" -> "Apple Juice";
            case "3" -> "Water";
            case "4" -> "Soda";
            default -> {
                System.out.println("Invalid choice. Defaulting to Water.");
                yield "Water";
            }
        };

        System.out.println("Choose a size:");
        System.out.println("1) Small - $2.00");
        System.out.println("2) Medium - $2.50");
        System.out.println("3) Large - $3.00");
        System.out.print("Enter your size choice: ");
        String sizeChoice = scanner.nextLine();

        double price = switch (sizeChoice) {
            case "1" -> 2.00;
            case "2" -> 2.50;
            case "3" -> 3.00;
            default -> {
                System.out.println("Invalid size. Defaulting to Medium.");
                yield 2.50;
            }
        };

        return new Drink(name, price);
    }

    private Chip buildChips() {
        System.out.println("\nChoose a chip:");
        System.out.println("1) Doritos");
        System.out.println("2) Lays");
        System.out.println("3) Sun Chips");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        return switch (choice) {
            case "1" -> new Chip("Doritos", 1.50);
            case "2" -> new Chip("Lays", 1.50);
            case "3" -> new Chip("Sun Chips", 1.50);
            default -> {
                System.out.println("Invalid choice. Defaulting to Lays.");
                yield new Chip("Lays", 1.50);
            }
        };
    }
}