package ua.epam.training.piontkovskyi.model.data;

public enum CarClass {
    ECONOMY(1.0),BUSINESS(1.5),REPRESENTATIVE(2.0);

    private double coefficient;

    private CarClass(double coefficient){
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
