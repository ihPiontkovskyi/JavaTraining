package ua.epam.training.piontkovskyi.model.entity;

public class GasCar extends Car implements CargoTransportable, PassengerTransportable {
    private String fuelType;
    private int fuelTankCapacity;
    private int fuelConsumption;

    protected GasCar() {
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(int fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", fuelType=" + fuelType +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", fuelConsumption=" + fuelConsumption;
    }

    public static class Builder extends CarBuilder<GasCar, Builder> {

        public Builder withFuelType(String fuelType) {
            actualClass.setFuelType(fuelType);
            return this;
        }

        public Builder withFuelTankCapacity(int fuelTankCapacity) {
            actualClass.setFuelTankCapacity(fuelTankCapacity);
            return this;
        }

        public Builder withFuelConsumption(int fuelConsumption) {
            actualClass.setFuelConsumption(fuelConsumption);
            return this;
        }

        @Override
        protected GasCar getActual() {
            return new GasCar();
        }

        @Override
        protected Builder getActualBuilder() {
            return this;
        }

        @Override
        public GasCar build() {
            return actualClass;
        }
    }
}
