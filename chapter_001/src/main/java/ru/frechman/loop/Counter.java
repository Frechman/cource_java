package ru.frechman.loop;

/**
 * Cчётчик.
 *
 * @author Frechman.
 * @version 0.1.
 * @since 0.1
 */
public class Counter {

    /**
     * Считает сумму чётных чисел в заданном диапазоне.
     *
     * @param start  Начало диапазона.
     * @param finish Окончание диапазона.
     * @return Сумму чётных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}