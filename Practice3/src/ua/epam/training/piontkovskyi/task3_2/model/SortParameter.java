package ua.epam.training.piontkovskyi.task3_2.model;

public enum SortParameter {
    NAME("Name"), PRODUCT_TYPE("Type"), LOCATION("Location"), SERVICES_COUNT("Service");
    private String value;

    SortParameter(String value) {
        this.value = value;
    }

    public boolean checkEqual(String value) {
        return this.value.equalsIgnoreCase(value);
    }
}
