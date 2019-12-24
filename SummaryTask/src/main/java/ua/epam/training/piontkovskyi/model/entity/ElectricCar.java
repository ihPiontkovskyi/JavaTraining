package ua.epam.training.piontkovskyi.model.entity;

public class ElectricCar extends Car {

    private String batteryType;
    private int chargingTime;
    private int lifetimeBattery;

    protected ElectricCar() {
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
    public String toString() {
        return super.toString() +
                ", Battery type=" + batteryType +
                ", Charging time=" + chargingTime +
                ", lifetimeBattery=" + lifetimeBattery;
    }

    public static class Builder extends CarBuilder<ElectricCar, Builder> {

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
        protected ElectricCar getActual() {
            return new ElectricCar();
        }

        @Override
        protected Builder getActualBuilder() {
            return this;
        }

        @Override
        public ElectricCar build() {
            return actualClass;
        }
    }
}
