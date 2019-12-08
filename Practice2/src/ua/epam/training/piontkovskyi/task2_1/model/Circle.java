package ua.epam.training.piontkovskyi.task2_1.model;

public class Circle extends Shape {
    private int radius;

    public Circle(String shapeColor, int radius) {
        super(shapeColor);
        if (!isCircle(radius)) {
            throw new IllegalArgumentException("These radius do not form a circle");
        }
        this.radius = radius;
    }

    private boolean isCircle(int radius) {
        return radius > 0;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", radius=" + radius;
    }
}
