package ru.frechman.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса Matrix.
 */
public class MatrixTest {

    @Test
    public void testMultiply() {
        Matrix matrix = new Matrix();
        int[][] expected = matrix.multiple(10);
        assertThat(81, is(expected[9][9]));
    }

    @Test
    public void when5x5Then25() {
        Matrix matrix = new Matrix();
        int[][] expected = matrix.multiple(10);
        assertThat(25, is(expected[5][5]));
    }
}