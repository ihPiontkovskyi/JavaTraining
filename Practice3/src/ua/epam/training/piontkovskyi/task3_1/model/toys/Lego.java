package ua.epam.training.piontkovskyi.task3_1.model.toys;


public class Lego extends Toy {
    private int numberOfParts;

    public int getNumberOfParts() {
        return numberOfParts;
    }

    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    private Lego() { }

    public static class Builder extends BaseBuilder<Lego, Builder> {

        public Builder withNumberOfParts(int numberOfParts) {
            actualClass.numberOfParts = numberOfParts;
            return actualBuilder;
        }

        @Override
        protected Lego getActual() {
            return new Lego();
        }

        @Override
        protected Lego.Builder getActualBuilder() {
            return this;
        }

        @Override
        public Lego build() {
            return actualClass;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfParts=" + numberOfParts;
    }
}
