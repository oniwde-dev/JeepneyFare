
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("hh:mm a");

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
