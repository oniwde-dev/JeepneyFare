// Inheritance BAUAN 

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



// Inheritance Alangilan

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


// Inheritance Balagtas 

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


// Inheritance Capitolio

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


// Inheritance Lipa

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