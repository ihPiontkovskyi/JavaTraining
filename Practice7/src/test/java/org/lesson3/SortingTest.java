package org.lesson3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lesson3.sort.SortingUtil;

public class SortingTest {
    private Integer[] array;
    private Integer[] sortedArray;
    private Integer[] sortedDescendingArray;

    @Before
    public void initArrays() {
        array = new Integer[]{1, 23, 4, 43, 2, 1, 45, 5};
        sortedArray = new Integer[]{1, 1, 2, 4, 5, 23, 43, 45};
        sortedDescendingArray = new Integer[]{45, 43, 23, 5, 4, 2, 1, 1};
    }

    @Test
    public void bubbleSortShouldReturnSortedArray() {
        SortingUtil.sort(array);
        Assert.assertArrayEquals(sortedArray, array);
    }

    @Test
    public void bubbleSortShouldReturnSortedDescendingArray() {
        SortingUtil.sort(array, (o1, o2) -> o1.equals(o2) ? 0 : o1 > o2 ? -1 : 1);
        Assert.assertArrayEquals(sortedDescendingArray, array);
    }
}
