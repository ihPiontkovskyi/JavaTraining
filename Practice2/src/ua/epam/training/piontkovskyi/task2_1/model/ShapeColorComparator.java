package ua.epam.training.piontkovskyi.task2_1.model;

import java.util.Comparator;

public class ShapeColorComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getShapeColor().compareTo(o2.getShapeColor());
    }
}
