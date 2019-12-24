package ua.epam.training.piontkovskyi.model.data;

public enum Type {
    ROADSTER(2, 200),
    COUPE(4, 200),
    HATCHBACK(4, 250),
    SEDAN(4, 300),
    SUV(7, 400),
    VAN(7, 1200);

    private int seatsNumber;
    private int payloadWeight;

    Type(int seatsNumber, int payloadWeight) {
        this.payloadWeight = payloadWeight;
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public int getPayloadWeight() {
        return payloadWeight;
    }

}