# Analyzing the Transportation Fare of Commuters in Batangas City
## Project Description 📍
Commuters in Batangas City regularly spend money on public transportation to travel to 
school, work, markets, and other destinations. However, some commuters may find it difficult to 
keep track of their expenses, estimate how much they need for daily or monthly travel, or 
compare the costs of different available transportation  options. Without an organized record, it 
can also be challenging to identify how much of their budget is spent on transportation.
## Problem Being Address  📌
To develop a Java-based transportation fare analysis system that helps commuters and 
jeepney drivers in Batangas City calculate, record, and analyze their public transportation 
expenses. 
## Project Objectives 🎯
**The project aims to:**

● Provide a feature for entering transportation details; including the route or 
destination and passenger category. 

● To calculate estimated transportation expenses based on the fare information and 
number of trips entered by the user. 

● To allow users to record and review their daily transportation expenses. 

● To generate summaries of estimated transportation spending.

## Target Users 📋
**Jeepney Drivers** - They can check estimated fares and help passengers know the correct fare for their selected route.

**Commuters** - They can choose their possible route and see the corresponding fare depending on their destination. 

## Main Features 🌟
**Transportation and Route Selection** - Allows users to select their transportation type and preferred destination.

**Presentation of Route and Fare** - Displays the selected route and its corresponding estimated fare.

**Fare Calculator** - Calculates the total fare based on the selected route and passenger category. 

**Passenger Fare Category** - Allows users to choose between regular, student, senior citizen, and PWD categories.

**Summary of Expenses** - Shows the total transportation expenses based on the recorded trips.

## Technologies Used 💻
**Language:** Java

**Source-code Editor:** Visual Studio Code


## Team Member and Roles 👨‍💻

| Member                      | Role                 |
|-----------------------------|----------------------|
| Comia, Edwin E.             | Lead Programmer      |
| Gantia, Jenny I.            | Documentation Leader |
| Lagrisola, Naliah Shantal E.| Team Leader          |
| Marasigan, Von Ivan B.      | System / Design Lead |

## OOP Concepts Demonstrated 🧩
1. Encapsulation

   Data is kept private inside each class and accessed only through controlled methods, protecting it from unintended changes.

   ```java
    private String jeepneyType;
    private String route;
    private String passengerType;
    ```
2. Abstraction

   ```java
   public Jeepney(String jeepneyType, String route, String passengerType) {
        this.jeepneyType = jeepneyType;
        this.route = route;
        this.passengerType = passengerType;
    }

    public String getJeepneyType() {
        return jeepneyType;
    }

    public String getRoute() {
        return route;
    }

    public String getPassengerType() {
        return passengerType;
    }
   ```

 3. POLYMORPHISM
  
      ```java
      public abstract double calculatefare();

      public void displayInfo() {

        System.out.println("Jeepney Type: " + jeepneyType);
        System.out.println("Route: " + route);
        System.out.println("Passenger Type: " + passengerType);
        System.out.printf("Fare: PHP %.2f%n", calculateFare());
      ```

4. INHERITANCE (BAUAN)

   ```java
   class Bauan extends Jeepney {

    public Bauan(String route, String type) {
        super("Bauan", route, type);
    }

    @Override
    public double calculateFare() {

        if (getRoute().equalsIgnoreCase("Sta. Rita to Batangas") || getRoute().equalsIgnoreCase("Batangas to Sports Complex")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 15.00 : 12.00;
        }
        else if (getRoute().equalsIgnoreCase("Batangas to Bauan")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 21.00 : 18.00;
        }

        return 0;
    }
   ```
   4.1 INHERITANCE (ALANGILAN)

   ```java
   class Alangilan extends Jeepney {

    public Alangilan(String route, String type) {
        super("Alangilan", route, type);
    }

    @Override
    public double calculateFare() {

        if (getRoute().equalsIgnoreCase("Batangas to Grand Terminal")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 17.00 : 14.00;
        }

        else if (getRoute().equalsIgnoreCase("Batangas to SM Hyper")
                || getRoute().equalsIgnoreCase("Batangas to Alangilan")
                || getRoute().equalsIgnoreCase("Batangas City to GCH")
                || getRoute().equalsIgnoreCase("Batangas City to Water District")
                || getRoute().equalsIgnoreCase("Alangilan to Lumang Palengke")
                || getRoute().equalsIgnoreCase("Alangilan to Bagong Palengke")
                || getRoute().equalsIgnoreCase("Alangilan to BSU PB")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 15.00 : 12.00;
        }

        return 0;
    }

   ```
4.2 INHERITANCE (BALAGTAS)

```java
class Balagtas extends Jeepney {

    public Balagtas(String route, String type) {
        super("Balagtas", route, type);
    }

    @Override
    public double calculateFare() {

        if (getRoute().equalsIgnoreCase("Batangas to Balagtas") || getRoute().equalsIgnoreCase("Batangas to Grand Terminal")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 17.00 : 14.00;
        }

        else if (getRoute().equalsIgnoreCase("Batangas to Alangilan") || getRoute().equalsIgnoreCase("Batangas to SM Hyper")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 15.00 : 12.00;
        }

        return 0;
    }
}

```

4.3 INHERITANCE (CAPITOLIO)

```java
class Capitolio extends Jeepney {

    public Capitolio(String route, String type) {
        super("Capitolio", route, type);
    }

    @Override
    public double calculateFare() {

        if (getRoute().equalsIgnoreCase("Capitolio to SM Batangas")
                || getRoute().equalsIgnoreCase("Batangas City to Gulod")
                || getRoute().equalsIgnoreCase("Batangas City to Batangas Medical Center")
                || getRoute().equalsIgnoreCase("Batangas City to Hilltop")
                || getRoute().equalsIgnoreCase("SM Batangas to Lumang Palengke")
                || getRoute().equalsIgnoreCase("SM Batangas to Don Ramos")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 15.00 : 12.00;
        }

        return 0;
    }
}

```

4.4 INHERITANCE (LIPA)

```java
class Lipa extends Jeepney {

    public Lipa(String route, String type) {
        super("Lipa", route, type);
    }

    @Override
    public double calculateFare() {

        if (getRoute().equalsIgnoreCase("SM Lipa to Tambo") || getRoute().equalsIgnoreCase("Batangas City to Diversion Road")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 15.00 : 12.00;
        }

        else if (getRoute().equalsIgnoreCase("SM Lipa to San Jose") || getRoute().equalsIgnoreCase("Batangas City to San Jose")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 30.00 : 24.00;
        }

        else if (getRoute().equalsIgnoreCase("SM Lipa to Bukal")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 20.00 : 16.00;
        }

        else if (getRoute().equalsIgnoreCase("SM Lipa to Alangilan / Balagtas") || getRoute().equalsIgnoreCase("Batangas City to SM Lipa")) {
            return getPassengerType().equalsIgnoreCase("Regular")
                    ? 40.00 : 32.00;
        }

        return 0;
    }
}

```

## Steps to Run 🪜

1. Save the code as JeepneyFare.java in a folder on your computer.
   
2. Open your Folder to VS Code.
   
3. Open a terminal and compile the program.
   
4. Run the Compile program.

5. Use the number-based menu to navigate the system:

``` text
==============================================
     BATANGAS CITY JEEPNEY FARE SYSTEM
==============================================
       DAILY TRAVEL AND EXPENSE TRACKER

==============================================
                 MAIN MENU
==============================================
[1] Calculate and Record a New Trip
[2] View Available Jeepney Routes
[3] View Daily Travel Expense Summary
[4] Set or Update Travel Budget
[5] Exit Program
----------------------------------------------
Total Trips Recorded: 0
==============================================
Enter your choice:
```

## Sample Output 📋

The team expects to produce a functional, menu-driven Java application that focuses 
exclusively on jeepney transportation in Batangas City. The completed system will allow users to 
view general jeepney routes, select a route to see its available destinations or drop-off points and 
corresponding fares, choose a passenger category, and calculate the fare for a single trip or 
multiple trips. Users will also be able to save fare calculations as expense records and view a 
summary showing their recorded transactions, total number of trips, and accumulated 
transportation expenses. The application will demonstrate the appropriate use of Java 
programming and object-oriented programming concepts through separate classes, methods, data 
handling, and input validation.

``` text
==============================================
     BATANGAS CITY JEEPNEY FARE SYSTEM
==============================================
       DAILY TRAVEL AND EXPENSE TRACKER

==============================================
                 MAIN MENU
==============================================
[1] Calculate and Record a New Trip
[2] View Available Jeepney Routes
[3] View Daily Travel Expense Summary
[4] Set or Update Travel Budget
[5] Exit Program
----------------------------------------------
Total Trips Recorded: 0
==============================================
Enter your choice:
```

### Once you select the Option 1. It will proceed to the Jeepney selection
 ```text
==============================================
           NEW TRIP REGISTRATION
==============================================

AVAILABLE JEEPNEYS:
[1] Bauan
[2] Alangilan
[3] Balagtas
[4] Capitolio
[5] Lipa
[0] Return to Main Menu

```
## Next Step is the Route

```text
========== BAUAN JEEPNEY ROUTES ==========
[1] Sta. Rita to Batangas
[2] Batangas to Bauan
[3] Batangas to Sports Complex
[0] Cancel and Return to Main Menu
```

## Next one is select the Passenger type 

```text
========== PASSENGER TYPE ==========
[1] Regular
[2] Student/PWD
Select Passenger Type: 2

```
## Next one is to view the destination and fare amount based on the selected route

```text
==============================================
                 FARE DETAILS
==============================================
Jeepney Type: Bauan
Route: Sta. Rita to Batangas
Passenger Type: Student/PWD
Fare: PHP 12.00

==============================================
                 FARE PAYMENT
==============================================
Required Fare: PHP 12.00
Enter Amount Paid: PHP 15

```

## Lastly, it displays the completed transaction.

```text
==============================================
             PAYMENT DETAILS
==============================================
Required Fare : PHP 12.00
Amount Paid   : PHP 15.00
Change        : PHP 3.00
Payment Status: PAID
Transaction Status: SUCCESSFUL
==============================================

Trip successfully recorded!

```
## Once you select the Option 2, it displays the available routes and their corresponding fares.

```text

==============================================
          AVAILABLE JEEPNEY ROUTES
==============================================

BAUAN JEEPNEY
1. Sta. Rita to Batangas (and vice versa)       PHP 15 / PHP 12
2. Batangas to Bauan (and vice versa)           PHP 21 / PHP 18
3. Batangas to Sports Complex (and vice versa)  PHP 15 / PHP 12

ALANGILAN JEEPNEY
1. Batangas to SM Hyper (and vice versa)        PHP 15 / PHP 12
2. Batangas to Alangilan (and vice versa)       PHP 15 / PHP 12
3. Batangas City to Grand Terminal (and vice versa) PHP 17 / PHP 14
4. Batangas City to GCH (and vice versa)        PHP 15 / PHP 12
5. Batangas City to Water District (and vice versa) PHP 15 / PHP 12
6. Alangilan to Lumang Palengke (and vice versa) PHP 15 / PHP 12
7. Alangilan to Bagong Palengke (and vice versa) PHP 15 / PHP 12
8. Alangilan to BSU PB (and vice versa)         PHP 15 / PHP 12

BALAGTAS JEEPNEY
1. Batangas to SM Hyper (and vice versa)        PHP 15 / PHP 12
2. Batangas to Grand Terminal (and vice versa)  PHP 17 / PHP 14
3. Batangas to Balagtas (and vice versa)        PHP 17 / PHP 14
4. Batangas to Alangilan (and vice versa)       PHP 15 / PHP 12

CAPITOLIO JEEPNEY
1. Capitolio to SM Batangas (and vice versa)    PHP 15 / PHP 12
2. Batangas City to Gulod (and vice versa)      PHP 15 / PHP 12
3. Batangas City to Batangas Medical Center (and vice versa) PHP 15 / PHP 12
4. Batangas City to Hilltop (and vice versa)    PHP 15 / PHP 12
5. SM Batangas to Lumang Palengke (and vice versa) PHP 15 / PHP 12
6. SM Batangas to Don Ramos (and vice versa)    PHP 15 / PHP 12

LIPA JEEPNEY
1. SM Lipa to Tambo (and vice versa)            PHP 15 / PHP 12
2. SM Lipa to San Jose (and vice versa)         PHP 30 / PHP 24
3. SM Lipa to Bukal (and vice versa)            PHP 20 / PHP 16
4. SM Lipa to Alangilan / Balagtas (and vice versa) PHP 40 / PHP 32
5. Batangas City to Diversion Road (and vice versa) PHP 15 / PHP 12
6. Batangas City to San Jose (and vice versa)   PHP 30 / PHP 24
7. Batangas City to SM Lipa (and vice versa)    PHP 40 / PHP 32
----------------------------------------------
Fare format: Regular / Student-PWD

```

## Option 3 Daily Travel Expense Summary

```text

==============================================
          DAILY TRAVEL EXPENSE SUMMARY
==============================================

RECORDED TRANSACTIONS

==============================================
             TRANSACTION #1
==============================================
Time: 12:11 PM
Jeepney Type: Bauan
Route: Sta. Rita to Batangas
Passenger Type: Student/PWD
----------------------------------------------
Required Fare : PHP 12.00
Amount Paid   : PHP 15.00
Change        : PHP 3.00
----------------------------------------------
Payment Status: PAID
Transaction Status: SUCCESSFUL
==============================================

==============================================
             DAILY EXPENSE BREAKDOWN
==============================================
Total Transactions: 1
Total Fare Expenses : PHP 12.00
Total Amount Paid   : PHP 15.00
Total Change        : PHP 3.00
----------------------------------------------
Allocated Budget: Not yet set.
Set a travel budget to monitor your expenses.
==============================================

```
## Option 4 Travel Budget Allocation

```text
==============================================
          TRAVEL BUDGET ALLOCATION
==============================================

Enter your daily travel budget: PHP 100

Travel budget successfully updated!
Allocated Budget: PHP 100.00

========== TRAVEL BUDGET STATUS ==========
Allocated Budget: PHP 100.00
Total Spent: PHP 12.00
Remaining Budget: PHP 88.00
Budget Utilization: 12.00%
==========================================
```

## Project Limitations ⚠️

● The system will cover jeepney transportation only. It will not include tricycles, buses, vans, trains, or other modes of transportation.

● The system will include only the general jeepney routes, destinations, and drop-off points encoded by the project team.

● Fare amounts will be based on information manually entered and maintained by the team. The system will not automatically retrieve, verify, or update official fare rates. 

● The accuracy of fare calculations depends on the accuracy and completeness of the route and fare information entered into the program. 

● Passenger discounts will only be calculated according to the discount rates and rules configured in the system. The program will not independently verify a  passenger’s eligibility or identification. 

● The expense summary will only reflect transactions saved by the user in the available records. It will not automatically track every actual jeepney ride.


## Project Contributor 👥
Name: [COMIA,EDWIN E.] Role: LEAD PROGRAMMER Project: Analyzing the Transportation Fare of Commuters in Batangas City

Contact

GitHub: 

E-mail: comiaedwin18@gmail.com


