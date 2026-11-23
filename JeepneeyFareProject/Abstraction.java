
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

    // Abstract method
    public abstract double calculateFare();

    public void displayInfo() {

        System.out.println("Jeepney Type: " + jeepneyType);
        System.out.println("Route: " + route);
        System.out.println("Passenger Type: " + passengerType);
        System.out.printf("Fare: PHP %.2f%n", calculateFare());
    }
}
