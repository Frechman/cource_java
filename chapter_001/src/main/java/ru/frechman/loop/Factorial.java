package ru.frechman.loop;

import java.util.stream.*;

/**
 * Вычисление факториала.
 */
public class Factorial {

    /**
     * Вычесляет факториал с помощью цикла.
     *
     * @param n Факториал числа n.
     * @return Значение int 'n!'.
     */
    public int calc(int n) {
        int result = 1;
        if (n == 0 || n == 1) {
            return result;
        }
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Вычесляет факториал рекурсивным методом.
     *
     * @param n Факториал числа n.
     * @return Значение int 'n!'.
     */
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Вычесляет факториал с помощью StreamAPI.
     * 
     * @param n Факториал числа n.
     * @return Значение long 'n!'.
     */
    public long factorialStream(int n) {
        if (n == 0) {
            return 1;
        }
        return LongStream.rangeClosed(1, n).parallel()
                         .reduce(1, (a, b) -> a * b);
    }
}