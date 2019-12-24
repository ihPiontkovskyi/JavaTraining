package ua.epam.training.piontkovskyi.model.entity;


import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.model.data.Type;

public abstract class Car implements CargoTransportable, PassengerTransportable {

    private Manufacturer manufacturer;
    private Type type;
    private String model;
    private int payloadWeight;
    private int price;
    private int maxSpeed;
    private int seatsNumber;
    private boolean airConditioning;
    private int passenger = 0;
    private int cargoWeight = 0;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(String.format(": Manufacturer=%s", manufacturer));
        stringBuilder.append(String.format(", Type=%s", type));
        stringBuilder.append(String.format(", Model=%s", model));
        stringBuilder.append(String.format(", Price=%s", price));
        stringBuilder.append(String.format(", MaxSpeed=%s", maxSpeed));
        stringBuilder.append(String.format(", Seats number=%s", seatsNumber));
        stringBuilder.append(String.format(", Payload Weight=%s", payloadWeight));
        stringBuilder.append(airConditioning ? ", Has air conditioning" : ", Has air conditioning");

        return stringBuilder.toString();
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public int getPayloadWeight() {
        return payloadWeight;
    }

    public void setPayloadWeight(int payloadWeight) {
        this.payloadWeight = payloadWeight;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    @Override
    public boolean addPassenger() {
        if (passenger < seatsNumber) {
            passenger++;
            return true;
        }
        return false;
    }

    @Override
    public int getPassengerCount() {
        return passenger;
    }

    @Override
    public boolean addCargo(int weight) {
        if (cargoWeight + weight < payloadWeight) {
            cargoWeight += weight;
            return true;
        }
        return false;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }

    protected static abstract class CarBuilder<U extends Car, V extends CarBuilder> {
        protected U actualClass;
        protected V actualBuilder;

        protected abstract U getActual();

        protected abstract V getActualBuilder();

        protected CarBuilder() {
            actualClass = getActual();
            actualBuilder = getActualBuilder();
        }

        public V withManufacturer(Manufacturer manufacturer) {
            actualClass.setManufacturer(manufacturer);
            return actualBuilder;
        }

        public V withType(Type type) {
            actualClass.setType(type);
            actualClass.setPayloadWeight(type.getPayloadWeight());
            actualClass.setSeatsNumber(type.getSeatsNumber());
            return actualBuilder;
        }

        public V withModel(String model) {
            actualClass.setModel(model);
            return actualBuilder;
        }

        public V withPrice(int price) {
            actualClass.setPrice(price);
            return actualBuilder;
        }

        public V withMaxSpeed(int maxSpeed) {
            actualClass.setMaxSpeed(maxSpeed);
            return actualBuilder;
        }

        public V withAirConditioning(boolean airConditioning) {
            actualClass.setAirConditioning(airConditioning);
            return actualBuilder;
        }

        public abstract U build();
    }
}
