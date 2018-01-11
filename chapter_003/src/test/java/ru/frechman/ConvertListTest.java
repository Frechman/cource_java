package ru.frechman;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class ConvertListTest {

    @Test
    public void toList() {
        ConvertList convertList = new ConvertList();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        List<Integer> actual = convertList.toList(arr);

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 0, 0), actual);
    }

    @Test
    public void toArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int[][] actual = convertList.toArray(list, 3);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        //int[][] expected = {{1, 2,3,4}, {5, 6,7,0}};

        assertArrayEquals(expected, actual);
    }
}