package ua.epam.training.piontkovskyi;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.model.data.Type;
import ua.epam.training.piontkovskyi.model.entity.AbstractTaxi;
import ua.epam.training.piontkovskyi.model.entity.TaxiPark;
import ua.epam.training.piontkovskyi.model.entity.ElectricTaxi;
import ua.epam.training.piontkovskyi.model.entity.GasTaxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaxiParkTest {
    private static TaxiPark taxiPark;

    @BeforeClass
    public static void setData() {
        ElectricTaxi electricCar = new ElectricTaxi.Builder()
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
        GasTaxi gasCar = new GasTaxi.Builder()
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
        taxiPark = new TaxiPark();
        List<AbstractTaxi> abstractTaxis = new ArrayList<>();
        abstractTaxis.add(electricCar);
        abstractTaxis.add(gasCar);
        taxiPark.setCars(abstractTaxis);
    }

    @Test
    public void checkNotNull() {
        Assert.assertNotNull(taxiPark);
    }

    @Test
    public void checkList() {
        int expected = 2;
        Assert.assertEquals(expected, taxiPark.getCars().size());
    }

    @Test
    public void calculateCarsCostTest() {
        int expected = 120000;
        Assert.assertEquals(expected, taxiPark.calculateCarsCost());
    }

    @Test
    public void searchBySpeedTest() {
        List<AbstractTaxi> expected = new ArrayList<>();
        expected.add(new ElectricTaxi.Builder()
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
        List<AbstractTaxi> actual = taxiPark.searchBySpeed(Manufacturer.TESLA, 0, 1000);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void searchBySpeedNullTest() {
        Assert.assertEquals(Collections.EMPTY_LIST, taxiPark.searchBySpeed(Manufacturer.AUDI, 1000, 200));
    }

    @Test
    public void sortByFuelEconomyTest1() { //It`s actually in correct order
        List<AbstractTaxi> expected = taxiPark.getCars();
        Assert.assertEquals(expected, taxiPark.sortByFuelEconomy());
    }
    @Test
    public void sortByFuelEconomyTest2() {
        List<AbstractTaxi> expected = taxiPark.getCars();
        List<AbstractTaxi> abstractTaxis = new ArrayList<>();
        abstractTaxis.add(expected.get(1));
        abstractTaxis.add(expected.get(0));
        taxiPark.setCars(abstractTaxis);
        Assert.assertEquals(expected, taxiPark.sortByFuelEconomy());
    }

}
