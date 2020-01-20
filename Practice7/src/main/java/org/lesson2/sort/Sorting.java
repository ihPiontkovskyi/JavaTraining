package org.lesson2.sort;

public class Sorting {
    private Sorting() {
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; ++i) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void bubbleRecursiveSort(T[] array, int arrayLength) {
        if (arrayLength == 1) {
            return;
        }
        for (int i = 0; i < arrayLength - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                T temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        bubbleRecursiveSort(array, arrayLength - 1);
    }
}
