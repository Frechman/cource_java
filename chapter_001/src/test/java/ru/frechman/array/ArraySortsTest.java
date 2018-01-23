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
        int[] array = {2, -8, 3, 0, 1, 5, 6, 4, -1, 10, 100};

        //expectedSortArray
        int[] copyArray = {2, -8, 3, 0, 1, 5, 6, 4, -1, 10, 100};
        Arrays.sort(copyArray);

        int[] actualArray = ArraySorts.bubbleSort(array);

        assertThat(actualArray, is(copyArray));
    }
}