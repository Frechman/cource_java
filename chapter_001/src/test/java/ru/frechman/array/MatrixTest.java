package ru.frechman.array;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Тесты для класса Matrix.
 */
public class MatrixTest {

    @Test
    public void testMuiltiple() {
        Matrix matrix = new Matrix();
        int[][] expected = matrix.multiple(10);
        assertThat(81,is(expected[9][9]));
    }
    
    @Test
    public void when5x5Then25() {
        Matrix matrix = new Matrix();
        int[][] expected = matrix.multiple(10);
        assertThat(25,is(expected[5][5]));
    }
}