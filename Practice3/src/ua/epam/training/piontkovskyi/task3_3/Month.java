package ua.epam.training.piontkovskyi.task3_3;

public class Month extends MyEnum {
    static {
        register(Month.class, "JAN");
        register(Month.class, "FEB");
        register(Month.class, "MAR");
        register(Month.class, "APR");
        register(Month.class, "MAY");
        register(Month.class, "JUN");
        register(Month.class, "JUL");
        register(Month.class, "AUG");
        register(Month.class, "SEP");
        register(Month.class, "OCT");
        register(Month.class, "NOV");
        register(Month.class, "DEC");
    }

    public static Month valueOf(String itemValue) throws InstantiationException, IllegalAccessException {
        return (Month) valueOf(Month.class, itemValue);
    }

    public static Month[] values() {
        MyEnum[] enums = values(Month.class);
        Month[] months = new Month[enums.length];
        for (int i = 0; i < enums.length; i++) {
            months[i] = (Month) enums[i];
        }
        return months;
    }
}
