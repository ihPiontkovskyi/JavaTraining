package ua.epam.training.piontkovskyi.util;

import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.model.data.Type;
import ua.epam.training.piontkovskyi.model.entity.Car;
import ua.epam.training.piontkovskyi.model.entity.ElectricCar;
import ua.epam.training.piontkovskyi.model.entity.GasCar;

import java.util.ArrayList;
import java.util.List;

public class TaxiPoolSource {
    public static List<Car> getTaxiPoolData() {
        List<Car> list = new ArrayList<>();
        list.add(
                new GasCar.Builder()
                        .withFuelType("Petrol")
                        .withType(Type.SUV)
                        .withAirConditioning(true)
                        .withPrice(40000)
                        .withManufacturer(Manufacturer.JEEP)
                        .withFuelConsumption(12)
                        .withFuelTankCapacity(75)
                        .withMaxSpeed(120)
                        .withModel("Grand Cherokee")
                        .build()
        );
        list.add(
                new ElectricCar.Builder()
                        .withBatteryType("Lithium ion")
                        .withType(Type.SEDAN)
                        .withAirConditioning(true)
                        .withPrice(80000)
                        .withManufacturer(Manufacturer.TESLA)
                        .withChargingTime(4)
                        .withLifetimeBattery(600)
                        .withMaxSpeed(240)
                        .withModel("Model S")
                        .build()
        );
        return list;
    }
}
