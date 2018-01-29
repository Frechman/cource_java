package ru.frechman.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Test;

/**
 * Test for class ArraySorts.
 */
public class ArraySortsTest {

    @Test
    public void testBubbleSort() {
        int[] array = {100, 10, 8, 7, 6, 4, 3, 2, 0, -5, -9};

        //expectedSortArray
        int[] copyArray = {100, 10, 8, 7, 6, 4, 3, 2, 0, -5, -9};
        Arrays.sort(copyArray);

        int[] actualArray = ArraySorts.bubbleSort(array);

        assertThat(actualArray, is(copyArray));
    }
}