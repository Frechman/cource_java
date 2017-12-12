package ru.frechman.array;

/**
 * Сортировки массива.
 * LearnSortsArray.
 *
 * @author Frechman.
 */
public class ArraySorts {

    /**
     * Сортировка BubbleSort.
     */
    public static int[] bubbleSort(int... array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {        // (length - 1) потому что при последнем проходе 
            for (int j = 0; j < array.length - 1; j++) {    // элемент уже на своём месте и чтобы 
                if (array[j] > array[j + 1]) {              // j-элемент не вышел за пределы массива
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}