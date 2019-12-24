package ua.epam.training.piontkovskyi.model.entity;

import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.util.TaxiPoolSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiPark {

    private List<AbstractTaxi> cars;

    public TaxiPark() {
        cars = TaxiPoolSource.getTaxiPoolData();
    }

    public long calculateCarsCost() {
        long sum = 0;

        for (AbstractTaxi car : cars) {
            sum += car.getPrice();
        }

        return sum;
    }

    public List<AbstractTaxi> searchBySpeed(Manufacturer manufacturer, int min, int max) {
        List<AbstractTaxi> abstractTaxiSelection = new ArrayList<>();

        for (AbstractTaxi car : cars) {

            if (car.getManufacturer().equals(manufacturer) && car.getMaxSpeed() >= min && car.getMaxSpeed() <= max) {
                abstractTaxiSelection.add(car);
            }
        }

        return abstractTaxiSelection;
    }

    public List<AbstractTaxi> sortByFuelEconomy() {
        List<GasTaxi> gasCars = new ArrayList<>();
        List<ElectricTaxi> electricCars = new ArrayList<>();

        for (AbstractTaxi car : cars) {
            if (car.getClass().equals(ElectricTaxi.class)) {
                electricCars.add((ElectricTaxi) car);
            } else if (car.getClass().equals(GasTaxi.class)) {
                gasCars.add((GasTaxi) car);
            }
        }

        gasCars.sort(Comparator.comparingInt(GasTaxi::getFuelConsumption));
        electricCars.sort(Comparator.comparingInt(ElectricTaxi::getLifetimeBattery));

        List<AbstractTaxi> result = new ArrayList<>();

        result.addAll(electricCars);
        result.addAll(gasCars);

        return result;
    }

    public List<AbstractTaxi> getCars() {
        return cars;
    }

    public void setCars(List<AbstractTaxi> cars) {
        this.cars = cars;
    }
}