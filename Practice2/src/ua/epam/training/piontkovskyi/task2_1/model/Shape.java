package ua.epam.training.piontkovskyi.task2_1.model;

public abstract class Shape implements Drawable {
    private String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    public String getShapeColor() {
        return shapeColor;
    }

    @Override
    public String draw() {
        return String.format("%s; area=%.2f", this, calcArea());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": shapeColor=" + shapeColor;
    }
}
