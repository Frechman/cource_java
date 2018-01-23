package ru.frechman.array;

import java.util.Arrays;

/**
 * Remove duplicates in array.
 */
public class ArrayDuplicate {

    /**
     * Remove duplicates in array.
     */
    public String[] removeDuplicates(String[] array) {
        int unique = array.length;
        for (int i = 0; i < unique; i++) {
            for (int j = i + 1; j < unique; j++) {
                if (array[i].equals(array[j])) {
                    array[j--] = array[--unique];
                    // unique--;
                    // j--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}