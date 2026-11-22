import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// ==========================================
// ABSTRACTION AND ENCAPSULATION
// ==========================================

abstract class Jeepney {

    private String jeepneyType;
    private String route;
    private String passengerType;

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

    // POLYMORPHISM
    public abstract double calculateFare();

    public void displayInfo() {

        System.out.println("Jeepney Type: " + jeepneyType);
        System.out.println("Route: " + route);
        System.out.println("Passenger Type: " + passengerType);
        System.out.printf("Fare: PHP %.2f%n", calculateFare());
    }
}

// ==========================================
// INHERITANCE: BAUAN
// ==========================================

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
}

// ==========================================
// INHERITANCE: ALANGILAN
// ==========================================

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
}

// ==========================================
// INHERITANCE: BALAGTAS
// ==========================================

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

// ==========================================
// INHERITANCE: CAPITOLIO
// ==========================================

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

// ==========================================
// INHERITANCE: LIPA
// ==========================================

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

// ==========================================
// TRIP RECORD CLASS
// ==========================================

class TripRecord {

    private String jeepneyType;
    private String route;
    private String passengerType;
    private double fare;
    private double amountPaid;
    private double change;
    private String dateTime;

    public TripRecord(Jeepney jeepney, double amountPaid) {

        this.jeepneyType = jeepney.getJeepneyType();
        this.route = jeepney.getRoute();
        this.passengerType = jeepney.getPassengerType();
        this.fare = jeepney.calculateFare();
        this.amountPaid = amountPaid;
        this.change = amountPaid - fare;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        this.dateTime = LocalDateTime.now().format(formatter);
    }

    public double getFare() {
        return fare;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getChange() {
        return change;
    }

    public void displayRecord(int number) {

        System.out.println("\n==============================================");
        System.out.println("             TRANSACTION #" + number);
        System.out.println("==============================================");

        System.out.println("Time: " + dateTime);
        System.out.println("Jeepney Type: " + jeepneyType);
        System.out.println("Route: " + route);
        System.out.println("Passenger Type: " + passengerType);

        System.out.println("----------------------------------------------");

        System.out.printf("Required Fare : PHP %.2f%n", fare);
        System.out.printf("Amount Paid   : PHP %.2f%n", amountPaid);
        System.out.printf("Change        : PHP %.2f%n", change);

        System.out.println("----------------------------------------------");

        System.out.println("Payment Status: PAID");
        System.out.println("Transaction Status: SUCCESSFUL");

        System.out.println("==============================================");
    }
}

// ==========================================
// MAIN CLASS
// ==========================================

public class JeepneyFare {

    static Scanner input = new Scanner(System.in);

    static ArrayList<TripRecord> tripRecords = new ArrayList<>();

    static double travelBudget = 0;

    public static void main(String[] args) {

        int choice;

        System.out.println("\n==============================================");
        System.out.println("     BATANGAS CITY JEEPNEY FARE SYSTEM");
        System.out.println("==============================================");
        System.out.println("       DAILY TRAVEL AND EXPENSE TRACKER");

        do {

            displayMainMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    calculateAndRecordTrip();
                    break;
                case 2:
                    viewAvailableRoutes();
                    break;
                case 3:
                    displayExpenseSummary();
                    break;
                case 4:
                    setTravelBudget();
                    break;
                case 5:
                    System.out.println("\nThank you for using the system!");
                    System.out.println("Have a safe trip!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please select 1-5.");
            }
        } while (choice != 5);

        input.close();
    }

    // ==========================================
    // MAIN MENU
    // ==========================================

    public static void displayMainMenu() {

        System.out.println("\n==============================================");
        System.out.println("                 MAIN MENU");
        System.out.println("==============================================");

        System.out.println("[1] Calculate and Record a New Trip");
        System.out.println("[2] View Available Jeepney Routes");
        System.out.println("[3] View Daily Travel Expense Summary");
        System.out.println("[4] Set or Update Travel Budget");
        System.out.println("[5] Exit Program");

        System.out.println("----------------------------------------------");

        System.out.printf("Total Trips Recorded: %d%n", tripRecords.size());

        System.out.println("==============================================");
    }

    // ==========================================
    // INPUT VALIDATION: INTEGER
    // ==========================================

    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {

                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    // ==========================================
    // INPUT VALIDATION: DOUBLE
    // ==========================================

    public static double readDouble(String message) {

        while (true) {

            System.out.print(message);

            try {

                double value = Double.parseDouble(input.nextLine().trim());

                if (Double.isNaN(value) || Double.isInfinite(value) || value < 0) {
                    System.out.println("Please enter a valid positive amount.");
                } else {
                    return value;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid amount! Please enter a number.");
            }
        }
    }

    // ==========================================
    // FEATURE 1: RECORD A NEW TRIP
    // ==========================================

    public static void calculateAndRecordTrip() {

        String jeepney = "";
        String route = "";
        String passengerType = "";

        int routeChoice;

        System.out.println("\n==============================================");
        System.out.println("           NEW TRIP REGISTRATION");
        System.out.println("==============================================");

        // JEEPNEY SELECTION

        while (true) {

            System.out.println("\nAVAILABLE JEEPNEYS:");
            System.out.println("[1] Bauan");
            System.out.println("[2] Alangilan");
            System.out.println("[3] Balagtas");
            System.out.println("[4] Capitolio");
            System.out.println("[5] Lipa");
            System.out.println("[0] Return to Main Menu");

            int choice = readInt("\nSelect Jeepney Type: ");

            switch (choice) {
                case 1:
                    jeepney = "Bauan";
                    break;
                case 2:
                    jeepney = "Alangilan";
                    break;
                case 3:
                    jeepney = "Balagtas";
                    break;
                case 4:
                    jeepney = "Capitolio";
                    break;
                case 5:
                    jeepney = "Lipa";
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid selection! Try again.");
                    continue;
            }

            break;
        }

        // ROUTE SELECTION

        while (true) {

            System.out.println("\n========== " + jeepney.toUpperCase()
                    + " JEEPNEY ROUTES ==========");

            if (jeepney.equals("Bauan")) {
                System.out.println("[1] Sta. Rita to Batangas");
                System.out.println("[2] Batangas to Bauan");
                System.out.println("[3] Batangas to Sports Complex");
            }
            else if (jeepney.equals("Alangilan")) {
                System.out.println("[1] Batangas to SM Hyper");
                System.out.println("[2] Batangas to Alangilan");
                System.out.println("[3] Batangas City to Grand Terminal");
                System.out.println("[4] Batangas City to GCH");
                System.out.println("[5] Batangas City to Water District");
                System.out.println("[6] Alangilan to Lumang Palengke");
                System.out.println("[7] Alangilan to Bagong Palengke");
                System.out.println("[8] Alangilan to BSU PB");
            }
            else if (jeepney.equals("Balagtas")) {
                System.out.println("[1] Batangas to SM Hyper");
                System.out.println("[2] Batangas to Grand Terminal");
                System.out.println("[3] Batangas to Balagtas");
                System.out.println("[4] Batangas to Alangilan");
            }
            else if (jeepney.equals("Capitolio")) {
                System.out.println("[1] Capitolio to SM Batangas");
                System.out.println("[2] Batangas City to Gulod");
                System.out.println("[3] Batangas City to Batangas Medical Center");
                System.out.println("[4] Batangas City to Hilltop");
                System.out.println("[5] SM Batangas to Lumang Palengke");
                System.out.println("[6] SM Batangas to Don Ramos");
            }
            else if (jeepney.equals("Lipa")) {
                System.out.println("[1] SM Lipa to Tambo");
                System.out.println("[2] SM Lipa to San Jose");
                System.out.println("[3] SM Lipa to Bukal");
                System.out.println("[4] SM Lipa to Alangilan / Balagtas");
                System.out.println("[5] Batangas City to Diversion Road");
                System.out.println("[6] Batangas City to San Jose");
                System.out.println("[7] Batangas City to SM Lipa");
            }

            System.out.println("[0] Cancel and Return to Main Menu");

            routeChoice = readInt("\nSelect Route: ");

            if (routeChoice == 0) {
                System.out.println("Trip registration cancelled.");
                return;
            }

            if (jeepney.equals("Bauan")) {
                switch (routeChoice) {
                    case 1:
                        route = "Sta. Rita to Batangas";
                        break;
                    case 2:
                        route = "Batangas to Bauan";
                        break;
                    case 3:
                        route = "Batangas to Sports Complex";
                        break;
                    default:
                        System.out.println("Invalid route number!");
                        continue;
                }
            }
            else if (jeepney.equals("Alangilan")) {
                switch (routeChoice) {
                    case 1:
                        route = "Batangas to SM Hyper";
                        break;
                    case 2:
                        route = "Batangas to Alangilan";
                        break;
                    case 3:
                        route = "Batangas to Grand Terminal";
                        break;
                    case 4:
                        route = "Batangas City to GCH";
                        break;
                    case 5:
                        route = "Batangas City to Water District";
                        break;
                    case 6:
                        route = "Alangilan to Lumang Palengke";
                        break;
                    case 7:
                        route = "Alangilan to Bagong Palengke";
                        break;
                    case 8:
                        route = "Alangilan to BSU PB";
                        break;
                    default:
                        System.out.println("Invalid route number!");
                        continue;
                }
            }
            else if (jeepney.equals("Balagtas")) {
                switch (routeChoice) {
                    case 1:
                        route = "Batangas to SM Hyper";
                        break;
                    case 2:
                        route = "Batangas to Grand Terminal";
                        break;
                    case 3:
                        route = "Batangas to Balagtas";
                        break;
                    case 4:
                        route = "Batangas to Alangilan";
                        break;
                    default:
                        System.out.println("Invalid route number!");
                        continue;
                }
            }
            else if (jeepney.equals("Capitolio")) {
                switch (routeChoice) {
                    case 1:
                        route = "Capitolio to SM Batangas";
                        break;
                    case 2:
                        route = "Batangas City to Gulod";
                        break;
                    case 3:
                        route = "Batangas City to Batangas Medical Center";
                        break;
                    case 4:
                        route = "Batangas City to Hilltop";
                        break;
                    case 5:
                        route = "SM Batangas to Lumang Palengke";
                        break;
                    case 6:
                        route = "SM Batangas to Don Ramos";
                        break;
                    default:
                        System.out.println("Invalid route number!");
                        continue;
                }
            }
            else if (jeepney.equals("Lipa")) {
                switch (routeChoice) {
                    case 1:
                        route = "SM Lipa to Tambo";
                        break;
                    case 2:
                        route = "SM Lipa to San Jose";
                        break;
                    case 3:
                        route = "SM Lipa to Bukal";
                        break;
                    case 4:
                        route = "SM Lipa to Alangilan / Balagtas";
                        break;
                    case 5:
                        route = "Batangas City to Diversion Road";
                        break;
                    case 6:
                        route = "Batangas City to San Jose";
                        break;
                    case 7:
                        route = "Batangas City to SM Lipa";
                        break;
                    default:
                        System.out.println("Invalid route number!");
                        continue;
                }
            }

            break;
        }

        // PASSENGER TYPE

        while (true) {

            System.out.println("\n========== PASSENGER TYPE ==========");
            System.out.println("[1] Regular");
            System.out.println("[2] Student/PWD");

            int choice = readInt("Select Passenger Type: ");

            if (choice == 1) {
                passengerType = "Regular";
                break;
            }
            else if (choice == 2) {
                passengerType = "Student/PWD";
                break;
            }
            else {
                System.out.println("Invalid selection! Try again.");
            }
        }

        // CREATE APPROPRIATE JEEPNEY OBJECT

        Jeepney selectedJeepney;

        if (jeepney.equals("Bauan")) {
            selectedJeepney = new Bauan(route, passengerType);
        }
        else if (jeepney.equals("Alangilan")) {
            selectedJeepney = new Alangilan(route, passengerType);
        }
        else if (jeepney.equals("Balagtas")) {
            selectedJeepney = new Balagtas(route, passengerType);
        }
        else if (jeepney.equals("Capitolio")) {
            selectedJeepney = new Capitolio(route, passengerType);
        }
        else {
            selectedJeepney = new Lipa(route, passengerType);
        }

        // FARE CALCULATION

        double fare = selectedJeepney.calculateFare();

        System.out.println("\n==============================================");
        System.out.println("                 FARE DETAILS");
        System.out.println("==============================================");

        selectedJeepney.displayInfo();

        if (fare <= 0) {
            System.out.println("Fare information is unavailable.");
            return;
        }

        // PAYMENT

        double amountPaid;

        while (true) {
            System.out.println("\n==============================================");
            System.out.println("                 FARE PAYMENT");
            System.out.println("==============================================");

            System.out.printf("Required Fare: PHP %.2f%n", fare);

            amountPaid = readDouble("Enter Amount Paid: PHP ");

            if (amountPaid < fare) {
                System.out.println("\nInsufficient payment!");
                System.out.printf("Please pay at least PHP %.2f%n", fare);
            } else {
                break;
            }
        }

        double change = amountPaid - fare;

        System.out.println("\n==============================================");
        System.out.println("             PAYMENT DETAILS");
        System.out.println("==============================================");

        System.out.printf("Required Fare : PHP %.2f%n", fare);
        System.out.printf("Amount Paid   : PHP %.2f%n", amountPaid);
        System.out.printf("Change        : PHP %.2f%n", change);

        System.out.println("Payment Status: PAID");
        System.out.println("Transaction Status: SUCCESSFUL");

        System.out.println("==============================================");

        // SAVE TRIP RECORD

        TripRecord newRecord = new TripRecord(selectedJeepney, amountPaid);

        tripRecords.add(newRecord);

        System.out.println("\nTrip successfully recorded!");

        displayBudgetStatus();

        System.out.println("\nReturning to Main Menu...");
    }

    // ==========================================
    // FEATURE 2: VIEW AVAILABLE ROUTES
    // ==========================================

    public static void viewAvailableRoutes() {

        System.out.println("\n==============================================");
        System.out.println("          AVAILABLE JEEPNEY ROUTES");
        System.out.println("==============================================");

        System.out.println("\nBAUAN JEEPNEY");
        System.out.println("1. Sta. Rita to Batangas (and vice versa)       PHP 15 / PHP 12");
        System.out.println("2. Batangas to Bauan (and vice versa)           PHP 21 / PHP 18");
        System.out.println("3. Batangas to Sports Complex (and vice versa)  PHP 15 / PHP 12");

        System.out.println("\nALANGILAN JEEPNEY");
        System.out.println("1. Batangas to SM Hyper (and vice versa)        PHP 15 / PHP 12");
        System.out.println("2. Batangas to Alangilan (and vice versa)       PHP 15 / PHP 12");
        System.out.println("3. Batangas City to Grand Terminal (and vice versa) PHP 17 / PHP 14");
        System.out.println("4. Batangas City to GCH (and vice versa)        PHP 15 / PHP 12");
        System.out.println("5. Batangas City to Water District (and vice versa) PHP 15 / PHP 12");
        System.out.println("6. Alangilan to Lumang Palengke (and vice versa) PHP 15 / PHP 12");
        System.out.println("7. Alangilan to Bagong Palengke (and vice versa) PHP 15 / PHP 12");
        System.out.println("8. Alangilan to BSU PB (and vice versa)         PHP 15 / PHP 12");

        System.out.println("\nBALAGTAS JEEPNEY");
        System.out.println("1. Batangas to SM Hyper (and vice versa)        PHP 15 / PHP 12");
        System.out.println("2. Batangas to Grand Terminal (and vice versa)  PHP 17 / PHP 14");
        System.out.println("3. Batangas to Balagtas (and vice versa)        PHP 17 / PHP 14");
        System.out.println("4. Batangas to Alangilan (and vice versa)       PHP 15 / PHP 12");

        System.out.println("\nCAPITOLIO JEEPNEY");
        System.out.println("1. Capitolio to SM Batangas (and vice versa)    PHP 15 / PHP 12");
        System.out.println("2. Batangas City to Gulod (and vice versa)      PHP 15 / PHP 12");
        System.out.println("3. Batangas City to Batangas Medical Center (and vice versa) PHP 15 / PHP 12");
        System.out.println("4. Batangas City to Hilltop (and vice versa)    PHP 15 / PHP 12");
        System.out.println("5. SM Batangas to Lumang Palengke (and vice versa) PHP 15 / PHP 12");
        System.out.println("6. SM Batangas to Don Ramos (and vice versa)    PHP 15 / PHP 12");

        System.out.println("\nLIPA JEEPNEY");
        System.out.println("1. SM Lipa to Tambo (and vice versa)            PHP 15 / PHP 12");
        System.out.println("2. SM Lipa to San Jose (and vice versa)         PHP 30 / PHP 24");
        System.out.println("3. SM Lipa to Bukal (and vice versa)            PHP 20 / PHP 16");
        System.out.println("4. SM Lipa to Alangilan / Balagtas (and vice versa) PHP 40 / PHP 32");
        System.out.println("5. Batangas City to Diversion Road (and vice versa) PHP 15 / PHP 12");
        System.out.println("6. Batangas City to San Jose (and vice versa)   PHP 30 / PHP 24");
        System.out.println("7. Batangas City to SM Lipa (and vice versa)    PHP 40 / PHP 32");

        System.out.println("----------------------------------------------");
        System.out.println("Fare format: Regular / Student-PWD");
        System.out.println("==============================================");
    }

    // ==========================================
    // FEATURE 3: DAILY EXPENSE SUMMARY
    // ==========================================

    public static void displayExpenseSummary() {

        System.out.println("\n==============================================");
        System.out.println("          DAILY TRAVEL EXPENSE SUMMARY");
        System.out.println("==============================================");

        if (tripRecords.isEmpty()) {
            System.out.println("\nNo transactions have been recorded yet.");
            if (travelBudget > 0) {
                System.out.printf("Allocated Travel Budget: PHP %.2f%n",
                        travelBudget);
                System.out.printf("Remaining Budget: PHP %.2f%n",
                        travelBudget);
            }

            return;
        }

        double totalExpenses = 0;
        double totalPaid = 0;
        double totalChange = 0;

        // DISPLAY EACH COMPLETE TRANSACTION

        System.out.println("\nRECORDED TRANSACTIONS");

        for (int i = 0; i < tripRecords.size(); i++) {
            TripRecord record = tripRecords.get(i);

            record.displayRecord(i + 1);

            totalExpenses += record.getFare();
            totalPaid += record.getAmountPaid();
            totalChange += record.getChange();
        }

        // DAILY EXPENSE BREAKDOWN

        System.out.println("\n==============================================");
        System.out.println("             DAILY EXPENSE BREAKDOWN");
        System.out.println("==============================================");

        System.out.println("Total Transactions: " + tripRecords.size());

        System.out.printf("Total Fare Expenses : PHP %.2f%n",
                totalExpenses);
        System.out.printf("Total Amount Paid   : PHP %.2f%n",
                totalPaid);
        System.out.printf("Total Change        : PHP %.2f%n",
                totalChange);
        System.out.println("----------------------------------------------");

        // BUDGET ALLOCATION AND UTILIZATION

        if (travelBudget > 0) {

            double remaining = travelBudget - totalExpenses;
            double percentage = (totalExpenses / travelBudget) * 100;

            System.out.printf("Allocated Budget    : PHP %.2f%n",
                    travelBudget);
            System.out.printf("Total Spent         : PHP %.2f%n",
                    totalExpenses);

            if (remaining >= 0) {
                System.out.printf("Remaining Budget    : PHP %.2f%n",
                        remaining);
            } else {
                System.out.printf("Budget Exceeded     : PHP %.2f%n",
                        Math.abs(remaining));
            }
            System.out.printf("Budget Utilization  : %.2f%%%n",
                    percentage);
        } else {
            System.out.println("Allocated Budget: Not yet set.");
            System.out.println("Set a travel budget to monitor your expenses.");
        }

        System.out.println("==============================================");
    }

    // ==========================================
    // FEATURE 4: SET OR UPDATE TRAVEL BUDGET
    // ==========================================

    public static void setTravelBudget() {

        System.out.println("\n==============================================");
        System.out.println("          TRAVEL BUDGET ALLOCATION");
        System.out.println("==============================================");

        if (travelBudget > 0) {
            System.out.printf("Current Travel Budget: PHP %.2f%n",
                    travelBudget);
        }

        double newBudget = readDouble(
                "\nEnter your daily travel budget: PHP ");
        if (newBudget == 0) {
            System.out.println("Budget must be greater than zero.");
            return;
        }

        travelBudget = newBudget;

        System.out.println("\nTravel budget successfully updated!");

        System.out.printf("Allocated Budget: PHP %.2f%n", travelBudget);

        displayBudgetStatus();
    }

    // ==========================================
    // BUDGET STATUS
    // ==========================================

    public static void displayBudgetStatus() {

        double totalExpenses = 0;

        for (TripRecord record : tripRecords) {
            totalExpenses += record.getFare();
        }

        System.out.println("\n========== TRAVEL BUDGET STATUS ==========");

        if (travelBudget <= 0) {
            System.out.println("No travel budget has been allocated.");
        } else {
            double remaining = travelBudget - totalExpenses;
            System.out.printf("Allocated Budget: PHP %.2f%n", travelBudget);
            System.out.printf("Total Spent: PHP %.2f%n", totalExpenses);
            if (remaining >= 0) {
                System.out.printf("Remaining Budget: PHP %.2f%n",
                        remaining);
            } else {
                System.out.printf("Amount Exceeded: PHP %.2f%n",
                        Math.abs(remaining));
                System.out.println("WARNING: You have exceeded your budget!");
            }

            double percentage = (totalExpenses / travelBudget) * 100;

            System.out.printf("Budget Utilization: %.2f%%%n", percentage);
        }

        System.out.println("==========================================");
    }
}
