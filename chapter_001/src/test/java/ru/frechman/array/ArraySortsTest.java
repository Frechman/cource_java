package ru.frechman.array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса ArraySorts.
 */
public class ArraySortsTest {

    @Test
    public void testBubbleSort() {
        int[] array = {2, -8, 3, 0, 1, 5, 6, 4, -1, 10, 100};
        int[] arrayS = {2, -8, 3, 0, 1, 5, 6, 4, -1, 10, 100};
        Arrays.sort(arrayS); //expectedSortArray
        assertThat(ArraySorts.bubbleSort(array), is(arrayS));
    }
}