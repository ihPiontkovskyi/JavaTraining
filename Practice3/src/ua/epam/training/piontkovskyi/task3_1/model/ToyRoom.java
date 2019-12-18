package ua.epam.training.piontkovskyi.task3_1.model;

import ua.epam.training.piontkovskyi.task3_1.model.toys.Lego;
import ua.epam.training.piontkovskyi.task3_1.model.toys.Puzzle;
import ua.epam.training.piontkovskyi.task3_1.model.toys.Toy;

import java.util.*;

public class ToyRoom<T extends Toy> {

    List<Toy> toysList = new ArrayList<>();

    public Double getTotalCost() {
        double total = 0;
        for (ua.epam.training.piontkovskyi.task3_1.model.toys.Toy toy : toysList) {
            total += toy.getPrice();
        }
        return total;
    }

    public List<? extends Toy> sort(Criterion criterion) {
        List<Toy> copiedList = new ArrayList<>();
        Collections.copy(toysList, copiedList);
        switch (criterion) {
            case PRICE:
                copiedList.sort(Comparator.comparing(Toy::getPrice));
                break;
            case COUNTRY:
                copiedList.sort(Comparator.comparing(Toy::getCountry));
                break;
            case MATERIAL:
                copiedList.sort(Comparator.comparing(Toy::getMaterial));
                break;
            case AGE_LIMIT:
                copiedList.sort(Comparator.comparing(Toy::getAgeLimit));
                break;
            case NAME:
                copiedList.sort(Comparator.comparing(Toy::getName));
                break;
        }
        return copiedList;
    }

    public List<? extends Toy> getToysList() {
        return toysList;
    }

    public void addToy(Toy toy) {
        toysList.add(toy);
    }

    public List<? extends Toy> getSubList(Map<Criterion, String> filters) {
        List<Toy> result = new ArrayList<>();
        for (Criterion criterion : filters.keySet()) {
            if (!filters.get(criterion).equals("")) {
                result = getByCriteria(toysList, criterion, filters.get(criterion));
            }
        }
        return result;
    }

    private List<Toy> getByCriteria(List<? extends Toy> list, Criterion criterion, String value) {
        List<Toy> result = new ArrayList<>();
        switch (criterion) {
            case NAME:
                for (Toy toy : list) {
                    if (toy.getName().equals(value)) {
                        result.add(toy);
                    }
                }
                break;
            case MATERIAL:
                for (Toy toy : list) {
                    if (toy.getMaterial().equals(value)) {
                        result.add(toy);
                    }
                }
                break;
            case COUNTRY:
                for (Toy toy : list) {
                    if (toy.getCountry().equals(value)) {
                        result.add(toy);
                    }
                }
                break;
            case NUMBER_OF_PARTS:
            case NUMBER_OF_PUZZLES:
            case AGE_LIMIT:
            case PRICE:
                String[] values = value.split(" ");
                double n = Double.parseDouble(values[0]);
                if (values.length == 1) {
                    result = getByCriteria(list, criterion, n);
                } else {
                    double end = Double.parseDouble(values[1]);
                    result = getByCriteria(list, criterion, n, end);
                }
                break;
        }
        return result;
    }

    private List<Toy> getByCriteria(List<? extends Toy> list, Criterion criterion, Double value) {
        List<Toy> result = new ArrayList<>();
        switch (criterion) {
            case NUMBER_OF_PUZZLES:
                for (Toy toy : list) {
                    if (((Puzzle) toy).getNumberOfPuzzles() == (value)) {
                        result.add(toy);
                    }
                }
                break;
            case NUMBER_OF_PARTS:
                for (Toy toy : list) {
                    if (((Lego) toy).getNumberOfParts() == (value)) {
                        result.add(toy);
                    }
                }
                break;
            case AGE_LIMIT:
                for (Toy toy : list) {
                    if ((toy.getAgeLimit() == value)) {
                        result.add(toy);
                    }
                }
                break;
            case PRICE:
                for (Toy toy : list) {
                    if (toy.getPrice().equals(value)) {
                        result.add(toy);
                    }
                }
                break;
        }
        return result;
    }

    private List<Toy> getByCriteria(List<? extends Toy> list, Criterion criterion, Double start, Double end) {
        List<Toy> result = new ArrayList<>();
        switch (criterion) {
            case NUMBER_OF_PUZZLES:
                for (Toy toy : list) {
                    if (((Puzzle) toy).getNumberOfPuzzles() > start && ((Puzzle) toy).getNumberOfPuzzles() < end) {
                        result.add(toy);
                    }
                }
                break;
            case NUMBER_OF_PARTS:
                for (Toy toy : list) {
                    if (((Lego) toy).getNumberOfParts() > start && ((Lego) toy).getNumberOfParts() < end) {
                        result.add(toy);
                    }
                }
                break;
            case AGE_LIMIT:
                for (Toy toy : list) {
                    if ((toy.getAgeLimit() > start && toy.getAgeLimit() < end)) {
                        result.add(toy);
                    }
                }
                break;
            case PRICE:
                for (Toy toy : list) {
                    if (toy.getPrice() > start && toy.getPrice() < end) {
                        result.add(toy);
                    }
                }
                break;
        }
        return result;
    }
}
