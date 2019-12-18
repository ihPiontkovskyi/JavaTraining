package ua.epam.training.piontkovskyi.task3_1.model.toys;

public class Car extends Toy {

    private Car() { }

    public static class Builder extends BaseBuilder<Car, Builder> {
        @Override
        protected Car getActual() {
            return new Car();
        }

        @Override
        protected Builder getActualBuilder() {
            return this;
        }

        @Override
        public Car build() {
            return actualClass;
        }
    }
}
