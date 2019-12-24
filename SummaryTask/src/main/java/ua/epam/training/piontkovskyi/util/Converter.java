package ua.epam.training.piontkovskyi.util;

import ua.epam.training.piontkovskyi.model.entity.AbstractTaxi;

import java.util.List;

public class Converter {
    private Converter(){
        //ignore
    }
    public static String convertListOfCars(List<? extends AbstractTaxi> list) {
        StringBuilder result = new StringBuilder();
        int index = 1;
        for (AbstractTaxi elem : list) {
            result.append(index++).append(".").append(elem.toString()).append("\n");
        }

        return result.toString();
    }
}