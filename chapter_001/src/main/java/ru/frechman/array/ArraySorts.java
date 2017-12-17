package ru.frechman.array;

import java.util.Arrays;

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

    /**
     * Merge Sort
     *
     * @param arr1 sort first array.
     * @param arr2 sort second array.
     * @return sort result array.
     */
    public static int[] mergeSort(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int ind1 = 0, ind2 = 0, indR = 0;

        while (ind1 < arr1.length && ind2 < arr2.length) {
            result[indR++] = arr1[ind1] < arr2[ind2] ? arr1[ind1++] : arr2[ind2++];
        }

        if (ind1 == arr1.length) {
            while (ind2 < arr2.length) {
                result[indR++] = arr2[ind2++];
            }
        } else if (ind2 == arr2.length) {
            while (ind1 < arr1.length) {
                result[indR++] = arr1[ind1++];
            }
        }

        return result;
    }

    public static int[] mergeSort(int[] arr, int left, int right) {
        int[] result = new int[arr.length];

        int mid = (left + right) / 2;
        int[] arrL = mergeSort(arr, 0, mid);
        int[] arrR = mergeSort(arr, mid + 1, right);

        result = mergeSort(arrL, arrR);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12};
        int[] arr2 = {0, 1, 3, 5, 7, 9, 11};

        System.out.println(Arrays.toString(mergeSort(arr, arr2)));
        int[] arrR = {4, 5, -1, 6, 7, 8, 8, 8, 9, 9, 3, 435, 35, 2, 4234, 62, -5};

        System.out.println(Arrays.toString(mergeSort(arrR, 0, arrR.length)));
    }
}