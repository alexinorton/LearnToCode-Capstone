### DELI-cious Sandwich Shop

A Java-based point-of-sale console application for a custom sandwich shop.

This project was created as part of my final capstone at Year Up. It allows customers to build sandwiches with full customization, add drinks and chips, and generates receipts.

 Features

## - Building sandwiches:
  - Size: 4", 8", 12"
  - Meats: Ham, Turkey, Roast Beef, Bacon, Chicken, Pastrami
  - Cheeses: American, Provolone, Cheddar, Swiss, Pepper Jack
  - Toppings:
  - Extra meat and cheese pricing based on size
  - Toast option

## - Add drinks with size and price:
  - Small ($2.00), Medium ($2.50), Large ($3.00)
  - Coffee, Apple Juice, Water, Soda

## - Add chips:
  - Doritos, Lays, Sun Chips ($1.50)

## - Tax and receipt system:
  - Subtotal, tax, total
  - Receipts saved to `/receipts` folder as `.txt` files

---

### 🖼️ Screenshots

Main Menu  
![Main screen](https://github.com/user-attachments/assets/09dc7deb-d753-4faf-b37c-d4d67f0b8bed)


Sandwich Builder  
![Sandwich screen](https://github.com/user-attachments/assets/75ac1955-9a47-41d3-a6a2-8676f9b4bcfd)


Example Receipt  
![Receipt output](https://github.com/user-attachments/assets/2a2c82e5-4efe-4d12-8696-87df019ff71d)

Mermaid Chart
![Mermaid chart](https://github.com/user-attachments/assets/de090b45-e286-4164-9592-c17e6d17cd59)


---

💻 Interesting Code Snippet
Unit testing is a useful way to prove that your code works the way it’s supposed to. In this project I used a unit test to automatically check if parts of my program are doing their job correctly. This is a very powerful tool that can save alot of time fixing code that could've been handled with a unit test.

@Test
    public void testGetTotalPrice_withExtras() {
        Sandwich sandwich = new Sandwich("Wheat", 8, "Turkey", "Swiss");
        sandwich.setExtraMeat(true);
        sandwich.setExtraCheese(true);

        double expected = sandwich.calculateBasePrice() + sandwich.getExtraMeatPrice() + sandwich.getExtraCheesePrice();
        double actual = sandwich.getTotalPrice();

        assertEquals(expected, actual, 0.01);
    }
}
