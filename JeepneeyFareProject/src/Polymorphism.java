
// Polymorphism

class JeepneyFactory {

    public static Jeepney createJeepney(
            String jeepney, String route, String passengerType) {

        if (jeepney.equals("Bauan")) {
            return new Bauan(route, passengerType);
        }
        else if (jeepney.equals("Alangilan")) {
            return new Alangilan(route, passengerType);
        }
        else if (jeepney.equals("Balagtas")) {
            return new Balagtas(route, passengerType);
        }
        else if (jeepney.equals("Capitolio")) {
            return new Capitolio(route, passengerType);
        }
        else if (jeepney.equals("Lipa")) {
            return new Lipa(route, passengerType);
        }

        return null;
    }
}
