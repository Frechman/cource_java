package ru.frechman.collection;

import java.util.ArrayList;
import java.util.LinkedList;
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
        int row = 0;
        int cols = 0;

        /*Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (cols <= rows-1) {
                result[row][cols++] = (int) iterator.next();
            } else {
                row++;
                cols = 0;
            }
        }*/

        for (int current : list) {
            if (cols <= rows - 1) {
                result[row][cols++] = current;
            } else {
                row++;
                cols = 0;
                result[row][cols++] = current;
            }
        }

        /*int line = 0;
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
        }*/
        return result;
    }

    /**
     * Convert List of array's elements to list.
     *
     * @param list of array's elements.
     * @return list of Integer's elements from <code>list</code>.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> resultList = new LinkedList<>();

        for (int[] arr : list) {
            for (int element : arr) {
                resultList.add(element);
            }
        }

        return resultList;
    }
}
