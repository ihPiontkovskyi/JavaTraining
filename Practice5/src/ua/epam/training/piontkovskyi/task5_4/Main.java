package ua.epam.training.piontkovskyi.task5_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            randomList.add(rnd.nextInt(1000));
        }
        RBTree<Integer> rbTreeRandom = new RBTree<>();
        for (Integer i : randomList) {
            rbTreeRandom.insert(i);
        }
        System.out.println(randomList);
        System.out.println(rbTreeRandom);
        List<Integer> sortedRandomList = new ArrayList<>(randomList);
        sortedRandomList.sort(Integer::compareTo);
        RBTree<Integer> rbTreeSorted = new RBTree<>();
        for (Integer i : sortedRandomList) {
            rbTreeSorted.insert(i);
        }
        System.out.println(sortedRandomList);
        System.out.println(rbTreeSorted);
    }


}
