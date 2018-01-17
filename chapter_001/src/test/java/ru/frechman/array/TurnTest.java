package ru.frechman.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Тесты для класса Turn.
 */
public class TurnTest {

    @Test
    public void testTurnEvenArray() {
        Turn turn = new Turn();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertThat(turn.back(array), is(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void testTurnOddArray() {
        Turn turn = new Turn();
        int[] arraySecond = {0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10};

        assertThat(turn.back(arraySecond),
                is(new int[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0}));
    }

    @Test
    public void testTurn90() {
        Turn turn = new Turn();

        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] expected = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}};

        assertArrayEquals(expected, turn.turn(array));
    }
}