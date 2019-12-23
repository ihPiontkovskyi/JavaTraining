package ua.epam.training.piontkovskyi.task2_1.model;

import java.util.Arrays;
import java.util.Comparator;

public class DataStorage {
    private Shape[] shapeList;
    private static final int SIZE = 12;

    public DataStorage() {
        shapeList = new Shape[SIZE];
    }

    public void fillList() {
        try {
            shapeList[0] = new Circle("RED", 4);
            shapeList[1] = new Rectangle("BLUE", 4, 5);
            shapeList[2] = new Triangle("PURPLE", 3, 4, 5);
            shapeList[3] = new Circle("ORANGE", 2);
            shapeList[4] = new Rectangle("GREEN", 1, 13);
            shapeList[5] = new Triangle("BLACK", 1, 2, 2);
            shapeList[6] = new Circle("YELLOW", 1);
            shapeList[7] = new Rectangle("PINK", 2, 2);
            shapeList[8] = new Triangle("BROWN", 6, 8, 10);
            shapeList[9] = new Circle("YELLOW", 2);
            shapeList[10] = new Rectangle("PINK", 4, 2);
            shapeList[11] = new Triangle("BROWN", 2, 4, 4);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public void sortByColor() {
        Arrays.sort(shapeList, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.getShapeColor().compareTo(o2.getShapeColor());
            }
        });
    }

    public void sortByArea() {
        Arrays.sort(shapeList, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return (int) (o1.calcArea() - o2.calcArea());
            }
        });
    }

    public String[] getShapeList() {
        String[] result = new String[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            result[i] = shapeList[i].draw();
        }
        return result;
    }

    public double getSumArea() {
        double result = 0.0;
        for (Shape shape : shapeList) {
            result += shape.calcArea();
        }
        return result;
    }

    public double getSumArea(Class<? extends Shape> type) {
        double result = 0.0;
        for (Shape shape : shapeList) {
            if (shape.getClass().equals(type)) {
                result += shape.calcArea();
            }
        }
        return result;
    }
}
