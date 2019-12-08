package ua.epam.training.piontkovskyi.task2_1.model;

public class Triangle extends Shape {
    private int a;
    private int b;
    private int c;

    public Triangle(String shapeColor, int a, int b, int c) throws IllegalArgumentException {
        super(shapeColor);
        if (!isTriangle(a, b, c)) {
            throw new IllegalArgumentException("These sides do not form a triangle");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public double calcArea() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return super.toString() +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c;
    }
}
