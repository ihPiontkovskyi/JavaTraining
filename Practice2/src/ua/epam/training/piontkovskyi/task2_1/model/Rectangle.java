package ua.epam.training.piontkovskyi.task2_1.model;

public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(String shapeColor, int length, int width) {
        super(shapeColor);
        if (!isRectangle(length, width)) {
            throw new IllegalArgumentException("These sides do not form a rectangle");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calcArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return super.toString() + ", length=" + length + ", width=" + width;
    }

    private boolean isRectangle(int l, int w) {
        return l > 0 && w > 0;
    }
}