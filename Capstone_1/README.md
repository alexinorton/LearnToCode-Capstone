Ledger App

This is an accounting ledger built in Java as part of my Capstone 1 project at Year Up.  
The app allows you to manage financial transactions by recording deposits, payments, and reports all saved in an organized CSV file.

---

## Features

- Add deposits and payments
- View all transactions
- Filter by deposits or payments
- Check balance
- Reports:
    - Month to date
    - Previous month
    - Year to date
    - Previous year
    - Search by vendor

---

## File Format
All transactions are saved in a CSV file using this format: 
```
date|time|description|vendor|amount
```

## Interesting Code
A piece of interesting code would be reversing the order of the transactions to display newest first:

```
ArrayList<String> lines = new ArrayList<>();
while ((line = reader.readLine()) != null) {
lines.add(line);
}
Collections.reverse(lines);
```

## Screenshots of Application
![img.png](/Capstone%20images/img.png)

![img_1.png](/Capstone%20images/img_1.png)

![img_2.png](/Capstone%20images/img_2.png)


## Resources Used
Java (Standard Edition)
IntelliJ 
File I/O (BufferedReader, FileWriter)
Java Date/Time API
Git & GitHub

Developed by Alexi Norton for the Year Up Java Development Capstone 1 Project.
