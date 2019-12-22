package ua.epam.training.piontkovskyi.task3_3;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class MyEnum {
    static Map<Class<? extends MyEnum>, Map<Object, String>> map = new HashMap<>();

    protected static void register(Class<? extends MyEnum> clazz, String name) {
        if (!map.containsKey(clazz))
            map.put(clazz, new HashMap<>());
        Map<Object, String> currEnum = map.get(clazz);
        int id = (currEnum.keySet().size());
        currEnum.put(id, name);
    }

    private Integer id;
    private String name;

    protected static MyEnum valueOf(Class<? extends MyEnum> clazz, String itemValue) throws IllegalAccessException, InstantiationException {
        Map<Object, String> currEnum = map.get(clazz);
        if (currEnum.containsValue(itemValue.toUpperCase())) {
            MyEnum enumObject = clazz.newInstance();
            for (int i = 0; i < currEnum.keySet().size(); ++i) {
                if (currEnum.get(i).equalsIgnoreCase(itemValue)) {
                    enumObject.id = i;
                    enumObject.name = currEnum.get(i);
                    return enumObject;
                }
            }
        }
        throw new NoSuchElementException(clazz.getSimpleName() + " haven`t element - " + itemValue);
    }

    public static MyEnum[] values(Class<? extends MyEnum> clazz) {
        Map<Object, String> currEnum = map.get(clazz);
        MyEnum[] enums = new MyEnum[currEnum.keySet().size()];
        for (int i = 0; i < currEnum.keySet().size(); i++) {
            try {
                enums[i] = valueOf(clazz, currEnum.get(i));
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return enums;
    }

    public Integer ordinal() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEnum myEnum = (MyEnum) o;
        return Objects.equals(id, myEnum.id) &&
                Objects.equals(name, myEnum.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
