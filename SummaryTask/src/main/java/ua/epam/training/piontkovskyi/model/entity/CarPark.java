package ua.epam.training.piontkovskyi.model.entity;

import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.util.TaxiPoolSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarPark {

    private List<Car> cars;

    public CarPark() {
        cars = TaxiPoolSource.getTaxiPoolData();
    }

    public long calculateCarsCost() {
        long sum = 0;

        for (Car car : cars) {
            sum += car.getPrice();
        }

        return sum;
    }

    public List<Car> searchBySpeed(Manufacturer manufacturer, int min, int max) {
        List<Car> carSelection = new ArrayList<>();

        for (Car car : cars) {

            if (car.getManufacturer().equals(manufacturer) && car.getMaxSpeed() >= min && car.getMaxSpeed() <= max) {
                carSelection.add(car);
            }
        }

        return carSelection;
    }

    public List<Car> sortByFuelEconomy() {
        List<GasCar> gasCars = new ArrayList<>();
        List<ElectricCar> electricCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getClass().equals(ElectricCar.class)) {
                electricCars.add((ElectricCar) car);
            } else if (car.getClass().equals(GasCar.class)) {
                gasCars.add((GasCar) car);
            }
        }

        gasCars.sort(Comparator.comparingInt(GasCar::getFuelConsumption));
        electricCars.sort(Comparator.comparingInt(ElectricCar::getLifetimeBattery));

        List<Car> result = new ArrayList<>();

        result.addAll(electricCars);
        result.addAll(gasCars);

        return result;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}