package ua.epam.training.piontkovskyi.task5_2;

import java.util.*;

public class Generator {
    private static Random rnd = new Random();

    public static List<Integer> generateList(int n, int startRange, int endRange) {

        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            list.add(startRange + rnd.nextInt(endRange));
        }
        return list;
    }

    public static Set<Integer> generateSet(int n, int startRange, int endRange) {
        if (endRange - startRange < n) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        while (set.size() < n) {
            set.add(startRange + rnd.nextInt(endRange));
        }
        return set;
    }
}
