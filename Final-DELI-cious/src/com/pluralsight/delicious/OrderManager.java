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
        String sizeChoice;
        boolean validSize = false;
        do {
            System.out.println("\nChoose your sandwich size:");
            System.out.println("1) 4 inch");
            System.out.println("2) 8 inch");
            System.out.println("3) 12 inch");
            System.out.print("Enter your choice: ");
            sizeChoice = scanner.nextLine();
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
        } while (!validSize);
        double basePrice = switch (size) {
            case 4 -> 5.00;
            case 8 -> 7.00;
            case 12 -> 9.00;
            default -> 7.00;
        };
        String meat = "";
        boolean validMeat = false;
        String meatChoice;
        do {
            System.out.println("\nChoose your meat:");
            System.out.println("1) Ham");
            System.out.println("2) Turkey");
            System.out.println("3) Roast Beef");
            System.out.println("4) Bacon");
            System.out.println("5) Chicken");
            System.out.println("6) Pastrami");
            System.out.print("Enter your choice: ");
            meatChoice = scanner.nextLine();

            if (meatChoice.equals("1")) {
                meat = "Ham";
                validMeat = true;
            } else if (meatChoice.equals("2")) {
                meat = "Turkey";
                validMeat = true;
            } else if (meatChoice.equals("3")) {
                meat = "Roast Beef";
                validMeat = true;
            } else if (meatChoice.equals("4")) {
                meat = "Bacon";
                validMeat = true;
            } else if (meatChoice.equals("5")) {
                meat = "Chicken";
                validMeat = true;
            } else if (meatChoice.equals("6")) {
                meat = "Pastrami";
                validMeat = true;
            } else {
                System.out.println("Invalid choice. Please enter 1–6.");
            }
        } while (!validMeat);

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
        String cheeseChoice;
        do {
            System.out.println("\nChoose your cheese:");
            System.out.println("1) American");
            System.out.println("2) Provolone");
            System.out.println("3) Cheddar");
            System.out.println("4) Swiss");
            System.out.println("5) Pepper Jack");
            System.out.print("Enter your choice: ");
            cheeseChoice = scanner.nextLine();

            if (cheeseChoice.equals("1")) {
                cheese = "American";
                validCheese = true;
            } else if (cheeseChoice.equals("2")) {
                cheese = "Provolone";
                validCheese = true;
            } else if (cheeseChoice.equals("3")) {
                cheese = "Cheddar";
                validCheese = true;
            } else if (cheeseChoice.equals("4")) {
                cheese = "Swiss";
                validCheese = true;
            } else if (cheeseChoice.equals("5")) {
                cheese = "Pepper Jack";
                validCheese = true;
            } else {
                System.out.println("Invalid choice. Please enter 1–5.");
            }
        } while (!validCheese);

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

        String sauce = "";
        String sauceChoice;
        boolean validSauce = false;
        do {
            System.out.println("\nChoose your sauce:");
            System.out.println("1) Mayo");
            System.out.println("2) Mustard");
            System.out.println("3) Ketchup");
            System.out.println("4) Ranch");
            System.out.println("5) Thousand Islands");
            System.out.println("6) Vinaigrette");
            System.out.print("Enter your choice: ");
            sauceChoice = scanner.nextLine();

            if (sauceChoice.equals("1")) {
                sauce = "Mayo";
                validSauce = true;
            } else if (sauceChoice.equals("2")) {
                sauce = "Mustard";
                validSauce = true;
            } else if (sauceChoice.equals("3")) {
                sauce = "Ketchup";
                validSauce = true;
            } else if (sauceChoice.equals("4")) {
                sauce = "Ranch";
                validSauce = true;
            } else if (sauceChoice.equals("5")) {
                sauce = "Thousand Islands";
                validSauce = true;
            } else if (sauceChoice.equals("6")) {
                sauce = "Vinaigrette";
                validSauce = true;
            } else {
                System.out.println("Invalid choice. Please enter 1–6.");
            }
        } while (!validSauce);

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
        String drinkType;
        do {
            System.out.println("\nChoose a drink:");
            System.out.println("1) Coffee");
            System.out.println("2) Apple Juice");
            System.out.println("3) Water");
            System.out.println("4) Soda");
            System.out.print("Enter your drink choice: ");
            drinkType = scanner.nextLine();

            if (drinkType.equals("1")) {
                name = "Coffee";
                validDrink = true;
            } else if (drinkType.equals("2")) {
                name = "Apple Juice";
                validDrink = true;
            } else if (drinkType.equals("3")) {
                name = "Water";
                validDrink = true;
            } else if (drinkType.equals("4")) {
                name = "Soda";
                validDrink = true;
            } else {
                System.out.println("Invalid choice. Please enter 1–4.");
            }
        } while (!validDrink);


        String size = "";
        boolean validSize = false;
        String sizeChoice;
        do {
            System.out.println("Choose a size:");
            System.out.println("1) Small - $1.50");
            System.out.println("2) Medium - $2.00");
            System.out.println("3) Large - $2.50");
            System.out.print("Enter your size choice: ");
            sizeChoice = scanner.nextLine();

            if (sizeChoice.equals("1")) {
                size = "Small";
                validSize = true;
            } else if (sizeChoice.equals("2")) {
                size = "Medium";
                validSize = true;
            } else if (sizeChoice.equals("3")) {
                size = "Large";
                validSize = true;
            } else {
                System.out.println("Invalid size. Please enter 1–3.");
            }
        } while (!validSize);

        return new Drink(name, size);
    }




    private Chip buildChips() {
        String chipType = "";
        boolean validChip = false;
        String choice;
        do {
            System.out.println("\nChoose a chip:");
            System.out.println("1) Doritos");
            System.out.println("2) Lays");
            System.out.println("3) Sun Chips");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                chipType = "Doritos";
                validChip = true;
            } else if (choice.equals("2")) {
                chipType = "Lays";
                validChip = true;
            } else if (choice.equals("3")) {
                chipType = "Sun Chips";
                validChip = true;
            } else {
                System.out.println("Invalid choice. Please enter 1–3.");
            }
        } while (!validChip);
        return new Chip(chipType, 1.50);
    }
}
