package ua.epam.training.piontkovskyi.util;

import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.model.data.Type;
import ua.epam.training.piontkovskyi.model.entity.AbstractTaxi;
import ua.epam.training.piontkovskyi.model.entity.ElectricTaxi;
import ua.epam.training.piontkovskyi.model.entity.GasTaxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiPoolSource {
    public static List<AbstractTaxi> getTaxiPoolData() {
        List<AbstractTaxi> list = new ArrayList<>();
        list.add(
                new GasTaxi.Builder()
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
                new ElectricTaxi.Builder()
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
        list.add(
                new ElectricTaxi.Builder()
                        .withBatteryType("Lithium ion")
                        .withType(Type.COUPE)
                        .withAirConditioning(true)
                        .withPrice(40000)
                        .withManufacturer(Manufacturer.NISSAN)
                        .withChargingTime(6)
                        .withLifetimeBattery(400)
                        .withMaxSpeed(160)
                        .withModel("Leaf")
                        .build()
        );
        list.add(
                new ElectricTaxi.Builder()
                        .withBatteryType("Lithium ion")
                        .withType(Type.ROADSTER)
                        .withAirConditioning(true)
                        .withPrice(120000)
                        .withManufacturer(Manufacturer.TESLA)
                        .withChargingTime(6)
                        .withLifetimeBattery(900)
                        .withMaxSpeed(320)
                        .withModel("Roadster")
                        .build()
        );
        list.add(
                new ElectricTaxi.Builder()
                        .withBatteryType("Lithium ion")
                        .withType(Type.SEDAN)
                        .withAirConditioning(true)
                        .withPrice(65000)
                        .withManufacturer(Manufacturer.BMW)
                        .withChargingTime(4)
                        .withLifetimeBattery(600)
                        .withMaxSpeed(240)
                        .withModel("i8")
                        .build()
        );
        list.add(
                new GasTaxi.Builder()
                        .withFuelType("Disel")
                        .withType(Type.HATCHBACK)
                        .withAirConditioning(true)
                        .withPrice(30000)
                        .withManufacturer(Manufacturer.VOLKSWAGEN)
                        .withFuelConsumption(8)
                        .withFuelTankCapacity(60)
                        .withMaxSpeed(240)
                        .withModel("Golf")
                        .build()
        );
        list.add(
                new GasTaxi.Builder()
                        .withFuelType("Disel")
                        .withType(Type.HATCHBACK)
                        .withAirConditioning(true)
                        .withPrice(30000)
                        .withManufacturer(Manufacturer.VOLKSWAGEN)
                        .withFuelConsumption(8)
                        .withFuelTankCapacity(60)
                        .withMaxSpeed(240)
                        .withModel("Golf")
                        .build()
        );
        return list;
    }
}
