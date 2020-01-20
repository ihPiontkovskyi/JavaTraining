package org.lesson2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lesson2.sort.Sorting;

public class SortingTest {
    private Integer[] array;
    private Integer[] sortedArray;

    @Before
    public void initArrays() {
        array = new Integer[]{1, 23, 4, 43, 2, 1, 45, 5};
        sortedArray = new Integer[]{1, 1, 2, 4, 5, 23, 43, 45};

    }

    @Test
    public void bubbleSortShouldReturnSortedArray() {
        Sorting.bubbleSort(array);
        Assert.assertArrayEquals(sortedArray, array);
    }

    @Test
    public void bubbleSortRecursiveShouldReturnSortedArray() {
        Sorting.bubbleRecursiveSort(array, array.length);
        Assert.assertArrayEquals(sortedArray, array);
    }

    @Test
    public void insertionSortShouldReturnSortedArray() {
        Sorting.insertionSort(array);
        Assert.assertArrayEquals(sortedArray, array);
    }
}
