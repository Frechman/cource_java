package ru.frechman;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    /**
     * Convert two-dimensional array to ArrayList.
     *
     * @param array two-dimensional of numbers.
     * @return list of integers number from array.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : array) {
            for (int elm : arr) {
                result.add(elm);
            }
        }
        return result;
    }

    /**
     * Convert List of integer's numbers to two-dimensional array.
     * <p>
     * If the number of elements is not a multiple of the number of rows,
     * then fill the remaining values in the array with zeros.
     *
     * @param list of integer's numbers.
     * @param rows number of lines.
     * @return two-dimensional array with number of <code> rows </code>.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int x = list.size() % rows != 0 ? list.size() / rows + 1 : list.size() / rows;
        int[][] result = new int[x][rows];
        int line = 0;
        int cols = 0;
        int k = 0;
        for (int[] arr : result) {
            for (int elm : arr) {
                if (k <= list.size() - 1) {
                    result[line][cols++] = list.get(k++);
                }
            }
            line++;
            cols = 0;
        }
        return result;
    }
}
