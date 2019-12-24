package ua.epam.training.piontkovskyi.model.entity;

public class ElectricTaxi extends AbstractTaxi {

    private String batteryType;
    private int chargingTime;
    private int lifetimeBattery;
    public static double ELECTRIC_CAR_COEFFICIENT = 0.25;

    protected ElectricTaxi() {
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public int getChargingTime() {
        return chargingTime;
    }

    public void setChargingTime(int chargingTime) {
        this.chargingTime = chargingTime;
    }

    public int getLifetimeBattery() {
        return lifetimeBattery;
    }

    public void setLifetimeBattery(int lifetimeBattery) {
        this.lifetimeBattery = lifetimeBattery;
    }


    @Override
    public double calcPrice() {
        return getManufacturer().getCarClass().getCoefficient()*distance*ELECTRIC_CAR_COEFFICIENT;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Battery type=" + batteryType +
                ", Charging time=" + chargingTime +
                ", lifetimeBattery=" + lifetimeBattery;
    }

    public static class Builder extends CarBuilder<ElectricTaxi, Builder> {

        public Builder withBatteryType(String batteryType) {
            actualClass.setBatteryType(batteryType);
            return this;
        }

        public Builder withChargingTime(int chargingTime) {
            actualClass.setChargingTime(chargingTime);
            return this;
        }

        public Builder withLifetimeBattery(int lifetimeBattery) {
            actualClass.setLifetimeBattery(lifetimeBattery);
            return this;
        }

        @Override
        protected ElectricTaxi getActual() {
            return new ElectricTaxi();
        }

        @Override
        protected Builder getActualBuilder() {
            return this;
        }

        @Override
        public ElectricTaxi build() {
            return actualClass;
        }
    }
}
