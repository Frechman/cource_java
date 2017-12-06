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
    
    /**
     * Максимальное из трёх чисел.
     *
     * @param first Первое число.
     * @param second Второе число.
     * @param third Третье число.
     * @return Максимальное из трёх чисел.
     */
    public int max(int first, int second, int third) {
        return max(third, max(first, second));
    }

}