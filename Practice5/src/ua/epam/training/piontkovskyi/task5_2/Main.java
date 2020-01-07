package ua.epam.training.piontkovskyi.task5_2;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter count of objects n ->");
        int n = sc.nextInt();
        System.out.print("Enter start of range ->");
        int start = sc.nextInt();
        System.out.print("Enter end of range ->");
        int end = sc.nextInt();
        if (start > end) {
            System.err.println("Incorrect range!\n");
            return;
        }
        List<Integer> list = Generator.generateList(n, start, end);
        System.out.println(list);
        Set<Integer> set = Generator.generateSet(n, start, end);
        if (set == null) {
            System.err.println("Can not create set in such range\n");
        } else {
            System.out.println(set);
        }
    }
}
