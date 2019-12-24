package ua.epam.training.piontkovskyi.model.entity;

public class GasTaxi extends AbstractTaxi {
    private String fuelType;
    private int fuelTankCapacity;
    private int fuelConsumption;
    public static double GAS_CAR_COEFFICIENT = 0.5;

    protected GasTaxi() {
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
    public double calcPrice() {
        return getManufacturer().getCarClass().getCoefficient()*distance*GAS_CAR_COEFFICIENT;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", fuelType=" + fuelType +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", fuelConsumption=" + fuelConsumption;
    }

    public static class Builder extends CarBuilder<GasTaxi, Builder> {

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
        protected GasTaxi getActual() {
            return new GasTaxi();
        }

        @Override
        protected Builder getActualBuilder() {
            return this;
        }

        @Override
        public GasTaxi build() {
            return actualClass;
        }
    }
}
