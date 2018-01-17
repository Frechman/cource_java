package ru.frechman.array;

/**
 * Turn array.
 */
public class Turn {

    /**
     * Turn array back to front.
     */
    public int[] back(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temp;
        }
        return array;
    }

    /**
     * Rotate the array 90 degrees.
     */
    public int[][] turn(int[][] array) {
        int tmp;
        int size = array.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - 1 - i; j++) {
                //right -> left //clockwise
                tmp = array[i][j];
                array[i][j] = array[size - 1 - j][i];
                array[size - 1 - j][i] = array[size - 1 - i][size - 1 - j];
                array[size - 1 - i][size - 1 - j] = array[j][size - 1 - i];
                array[j][size - 1 - i] = tmp;

                //left -> right //counterclockwise

                /*tmp = array[i][j];
                array[i][j] = array[j][size - 1 - i];
                array[j][size - 1 - i] = array[size - 1 - i][size - 1 - j];
                array[size - 1 - i][size - 1 - j] = array[size - 1 - j][i];
                array[size - 1 - j][i] = tmp;
                */
            }
        }

        return array;
    }
}