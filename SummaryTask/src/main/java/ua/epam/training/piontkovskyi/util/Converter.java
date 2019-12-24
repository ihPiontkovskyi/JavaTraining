package ua.epam.training.piontkovskyi.util;

import ua.epam.training.piontkovskyi.model.entity.Car;

import java.util.List;

public class Converter {
    private Converter(){
        //ignore
    }
    public static String convertListOfCars(List<? extends Car> list) {
        StringBuilder result = new StringBuilder();

        for (Car elem : list) {
            result.append(elem.toString()).append("\n");
        }

        return result.toString();
    }
}