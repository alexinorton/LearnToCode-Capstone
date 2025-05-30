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
                case "1":
                    order.addItem(buildSandwich());
                    break;
                case "2":
                    order.addItem(buildDrink());
                    break;
                case "3":
                    order.addItem(buildChips());
                    break;
                case "4":
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        return order;
    }

    private Sandwich buildSandwich() {
        int size = 8;
        boolean validSize = false;

        while (!validSize) {
            System.out.println("\nChoose your sandwich size:");
            System.out.println("1) 4 inch");
            System.out.println("2) 8 inch");
            System.out.println("3) 12 inch");
            System.out.print("Enter your choice: ");
            String sizeChoice = scanner.nextLine();

            if (sizeChoice.equals("1")) {
                size = 4;
                validSize = true;
            } else if (sizeChoice.equals("2")) {
                size = 8;
                validSize = true;
            } else if (sizeChoice.equals("3")) {
                size = 12;
                validSize = true;
            } else {
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
        boolean validMeat = false;
        while (!validMeat) {
            System.out.println("\nChoose your meat:");
            System.out.println("1) Ham");
            System.out.println("2) Turkey");
            System.out.println("3) Roast Beef");
            System.out.println("4) Bacon");
            System.out.println("5) Chicken");
            System.out.println("6) Pastrami");
            System.out.print("Enter your choice: ");
            String meatChoice = scanner.nextLine();

            switch (meatChoice) {
                case "1" -> {
                    meat = "Ham";
                    validMeat = true;
                }
                case "2" -> {
                    meat = "Turkey";
                    validMeat = true;
                }
                case "3" -> {
                    meat = "Roast Beef";
                    validMeat = true;
                }
                case "4" -> {
                    meat = "Bacon";
                    validMeat = true;
                }
                case "5" -> {
                    meat = "Chicken";
                    validMeat = true;
                }
                case "6" -> {
                    meat = "Pastrami";
                    validMeat = true;
                }
                default -> System.out.println("Invalid choice. Please enter 1–6.");
            }
        }

        System.out.print("Would you like extra meat? (yes/no): ");
        String extraMeatInput = scanner.nextLine();
        boolean extraMeat = extraMeatInput.equalsIgnoreCase("yes");

        double extraMeatCost = 0.0;
        if (extraMeat) {
            switch (size) {
                case 4 -> extraMeatCost = 0.50;
                case 8 -> extraMeatCost = 1.00;
                case 12 -> extraMeatCost = 1.50;
            }
        }

        String cheese = "";
        boolean validCheese = false;
        while (!validCheese) {
            System.out.println("\nChoose your cheese:");
            System.out.println("1) American");
            System.out.println("2) Provolone");
            System.out.println("3) Cheddar");
            System.out.println("4) Swiss");
            System.out.println("5) Pepper Jack");
            System.out.print("Enter your choice: ");
            String cheeseChoice = scanner.nextLine();

            switch (cheeseChoice) {
                case "1" -> {
                    cheese = "American";
                    validCheese = true;
                }
                case "2" -> {
                    cheese = "Provolone";
                    validCheese = true;
                }
                case "3" -> {
                    cheese = "Cheddar";
                    validCheese = true;
                }
                case "4" -> {
                    cheese = "Swiss";
                    validCheese = true;
                }
                case "5" -> {
                    cheese = "Pepper Jack";
                    validCheese = true;
                }
                default -> System.out.println("Invalid choice. Please enter 1–5.");
            }
        }

        System.out.print("Would you like extra cheese? (yes/no): ");
        String extraCheeseInput = scanner.nextLine();
        boolean extraCheese = extraCheeseInput.equalsIgnoreCase("yes");

        double extraCheeseCost = 0.0;
        if (extraCheese) {
            switch (size) {
                case 4 -> extraCheeseCost = 0.30;
                case 8 -> extraCheeseCost = 0.60;
                case 12 -> extraCheeseCost = 0.90;
            }
        }

        ArrayList<String> toppings = new ArrayList<>();
        System.out.println("\nAdd your regular toppings (lettuce, spinach, tomato, pickles, onion, peppers, jalapenos):");
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

        // Sauce selection
        String sauce = "";
        boolean validSauce = false;
        while (!validSauce) {
            System.out.println("\nChoose your sauce:");
            System.out.println("1) Mayo");
            System.out.println("2) Mustard");
            System.out.println("3) Ketchup");
            System.out.println("4) Ranch");
            System.out.println("5) Thousand Islands");
            System.out.println("6) Vinaigrette");
            System.out.print("Enter your choice: ");
            String sauceChoice = scanner.nextLine();

            switch (sauceChoice) {
                case "1" -> {
                    sauce = "Mayo";
                    validSauce = true;
                }
                case "2" -> {
                    sauce = "Mustard";
                    validSauce = true;
                }
                case "3" -> {
                    sauce = "Ketchup";
                    validSauce = true;
                }
                case "4" -> {
                    sauce = "Ranch";
                    validSauce = true;
                }
                case "5" -> {
                    sauce = "Thousand Islands";
                    validSauce = true;
                }
                case "6" -> {
                    sauce = "Vinaigrette";
                    validSauce = true;
                }
                default -> System.out.println("Invalid choice. Please enter 1–6.");
            }
        }

        double totalPrice = basePrice + extraMeatCost + extraCheeseCost;

        Sandwich sandwich = new Sandwich(size, meat, cheese, toppings, totalPrice);
        sandwich.setExtraMeat(extraMeat);
        sandwich.setExtraCheese(extraCheese);
        sandwich.setExtraToppings(extraToppings);
        sandwich.setSauce(sauce);

        System.out.print("Would you like your sandwich toasted? (yes/no): ");
        String toastInput = scanner.nextLine();
        boolean toasted = toastInput.equalsIgnoreCase("yes");
        sandwich.setToasted(toasted);

        return sandwich;
    }

    private Drink buildDrink() {
        String name = "";
        boolean validDrink = false;
        while (!validDrink) {
            System.out.println("\nChoose a drink:");
            System.out.println("1) Coffee");
            System.out.println("2) Apple Juice");
            System.out.println("3) Water");
            System.out.println("4) Soda");
            System.out.print("Enter your drink choice: ");
            String drinkType = scanner.nextLine();

            switch (drinkType) {
                case "1" -> {
                    name = "Coffee";
                    validDrink = true;
                }
                case "2" -> {
                    name = "Apple Juice";
                    validDrink = true;
                }
                case "3" -> {
                    name = "Water";
                    validDrink = true;
                }
                case "4" -> {
                    name = "Soda";
                    validDrink = true;
                }
                default -> System.out.println("Invalid choice. Please enter 1–4.");
            }
        }

        String size = "";
        boolean validSize = false;
        while (!validSize) {
            System.out.println("Choose a size:");
            System.out.println("1) Small - $1.50");
            System.out.println("2) Medium - $2.00");
            System.out.println("3) Large - $2.50");
            System.out.print("Enter your size choice: ");
            String sizeChoice = scanner.nextLine();

            switch (sizeChoice) {
                case "1" -> {
                    size = "Small";
                    validSize = true;
                }
                case "2" -> {
                    size = "Medium";
                    validSize = true;
                }
                case "3" -> {
                    size = "Large";
                    validSize = true;
                }
                default -> System.out.println("Invalid size. Please enter 1–3.");
            }
        }

        return new Drink(name, size);
    }

    private Chip buildChips() {
        String chipType = "";
        boolean validChip = false;
        while (!validChip) {
            System.out.println("\nChoose a chip:");
            System.out.println("1) Doritos");
            System.out.println("2) Lays");
            System.out.println("3) Sun Chips");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    chipType = "Doritos";
                    validChip = true;
                }
                case "2" -> {
                    chipType = "Lays";
                    validChip = true;
                }
                case "3" -> {
                    chipType = "Sun Chips";
                    validChip = true;
                }
                default -> System.out.println("Invalid choice. Please enter 1–3.");
            }
        }

        return new Chip(chipType, 1.50);
    }
}