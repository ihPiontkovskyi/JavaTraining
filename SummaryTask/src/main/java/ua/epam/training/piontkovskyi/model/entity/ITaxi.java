package ua.epam.training.piontkovskyi.model.entity;

public interface ITaxi extends CargoTransportable, PassengerTransportable {
    boolean isBusy();
    double calcPrice();
    void makeOrder(int distance);
}
