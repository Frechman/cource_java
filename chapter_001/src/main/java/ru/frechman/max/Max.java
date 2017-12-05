package ru.frechman.max;

/**
 * Максимальное из двух чисел.
 *
 */
public class Max {
    
    /**
     * Максимальное из двух чисел.
     *
     * @param first Первое число.
     * @param second Второе число.
     * @return Максимальное из двух чисел.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

}