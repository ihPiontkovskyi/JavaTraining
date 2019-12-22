package ua.epam.training.piontkovskyi.task3_3;

public class DaysOfWeek extends MyEnum {
    static {
        register(DaysOfWeek.class, "SUNDAY");
        register(DaysOfWeek.class, "MONDAY");
        register(DaysOfWeek.class, "TUESDAY");
        register(DaysOfWeek.class, "WEDNESDAY");
        register(DaysOfWeek.class, "THURSDAY");
        register(DaysOfWeek.class, "FRIDAY");
        register(DaysOfWeek.class, "SATURDAY");
    }

    public static DaysOfWeek valueOf(String itemValue) throws InstantiationException, IllegalAccessException {
        return (DaysOfWeek) valueOf(DaysOfWeek.class, itemValue);
    }

    public static DaysOfWeek[] values() {
        MyEnum[] enums = values(DaysOfWeek.class);
        DaysOfWeek[] daysOfWeeks = new DaysOfWeek[enums.length];
        for (int i = 0; i < enums.length; i++) {
            daysOfWeeks[i] = (DaysOfWeek) enums[i];
        }
        return daysOfWeeks;
    }

    public DaysOfWeek nextDay() {
        DaysOfWeek[] days = DaysOfWeek.values();
        return days[(this.ordinal() + 1) % days.length];
    }

    @Override
    public String toString() {
        return name();
    }
}
