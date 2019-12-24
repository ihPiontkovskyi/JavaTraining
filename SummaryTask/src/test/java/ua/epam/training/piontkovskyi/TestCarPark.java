package ua.epam.training.piontkovskyi;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.model.data.Type;
import ua.epam.training.piontkovskyi.model.entity.Car;
import ua.epam.training.piontkovskyi.model.entity.CarPark;
import ua.epam.training.piontkovskyi.model.entity.ElectricCar;
import ua.epam.training.piontkovskyi.model.entity.GasCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCarPark {
    private static CarPark carPark;

    @BeforeClass
    public static void setData() {
        ElectricCar electricCar = new ElectricCar.Builder()
                .withBatteryType("Lithium ion")
                .withType(Type.SEDAN)
                .withAirConditioning(true)
                .withPrice(80000)
                .withManufacturer(Manufacturer.TESLA)
                .withChargingTime(4)
                .withLifetimeBattery(600)
                .withMaxSpeed(240)
                .withModel("Model S")
                .build();
        GasCar gasCar = new GasCar.Builder()
                .withFuelType("Petrol")
                .withType(Type.SUV)
                .withAirConditioning(true)
                .withPrice(40000)
                .withManufacturer(Manufacturer.JEEP)
                .withFuelConsumption(12)
                .withFuelTankCapacity(75)
                .withMaxSpeed(120)
                .withModel("Grand Cherokee")
                .build();
        carPark = new CarPark();
        List<Car> cars = new ArrayList<>();
        cars.add(electricCar);
        cars.add(gasCar);
        carPark.setCars(cars);
    }

    @Test
    public void checkNotNull() {
        Assert.assertNotNull(carPark);
    }

    @Test
    public void checkList() {
        int expected = 2;
        Assert.assertEquals(expected, carPark.getCars().size());
    }

    @Test
    public void calculateCarsCostTest() {
        int expected = 120000;
        Assert.assertEquals(expected, carPark.calculateCarsCost());
    }

    @Test
    public void searchBySpeedTest() {
        List<Car> expected = new ArrayList<>();
        expected.add(new ElectricCar.Builder()
                .withBatteryType("Lithium ion")
                .withType(Type.SEDAN)
                .withAirConditioning(true)
                .withPrice(80000)
                .withManufacturer(Manufacturer.TESLA)
                .withChargingTime(4)
                .withLifetimeBattery(600)
                .withMaxSpeed(240)
                .withModel("Model S")
                .build());
        List<Car> actual = carPark.searchBySpeed(Manufacturer.TESLA, 0, 1000);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void searchBySpeedNullTest() {
        Assert.assertEquals(Collections.EMPTY_LIST, carPark.searchBySpeed(Manufacturer.AUDI, 1000, 200));
    }

    @Test
    public void sortByFuelEconomyTest1() { //It`s actually in correct order
        List<Car> expected = carPark.getCars();
        Assert.assertEquals(expected, carPark.sortByFuelEconomy());
    }
    @Test
    public void sortByFuelEconomyTest2() {
        List<Car> expected = carPark.getCars();
        List<Car> cars = new ArrayList<>();
        cars.add(expected.get(1));
        cars.add(expected.get(0));
        carPark.setCars(cars);
        Assert.assertEquals(expected, carPark.sortByFuelEconomy());
    }

}
