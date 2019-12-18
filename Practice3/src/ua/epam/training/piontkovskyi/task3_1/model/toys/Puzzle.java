package ua.epam.training.piontkovskyi.task3_1.model.toys;

public class Puzzle extends Toy {
    private int numberOfPuzzles;

    public int getNumberOfPuzzles() {
        return numberOfPuzzles;
    }

    public void setNumberOfPuzzles(int numberOfPuzzles) {
        this.numberOfPuzzles = numberOfPuzzles;
    }

    private Puzzle() {
    }

    public static class Builder extends BaseBuilder<Puzzle, Builder> {

        public Builder withNumberOfPuzzles(int numberOfPuzzles) {
            actualClass.numberOfPuzzles = numberOfPuzzles;
            return actualBuilder;
        }

        @Override
        protected Puzzle getActual() {
            return new Puzzle();
        }

        @Override
        protected Builder getActualBuilder() {
            return this;
        }

        @Override
        public Puzzle build() {
            return actualClass;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfPuzzles=" + numberOfPuzzles;
    }
}