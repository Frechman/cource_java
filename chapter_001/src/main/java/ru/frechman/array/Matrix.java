package ru.frechman.array;

/**
 * Таблица умножения.
 */
public class Matrix {

    /**
     * Таблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = i * j;
            }
        }
        return matrix;
    }
}