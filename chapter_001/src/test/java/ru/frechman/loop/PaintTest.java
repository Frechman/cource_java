package ru.frechman.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса Paint.
 */
public class PaintTest {

    @Test
    public void testPaint() {
        Paint paint = new Paint();
        assertThat(paint.pyramid(2), is(String.format(" ^ %n^^^%n")));
    }

    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint paint = new Paint();
        String ln = System.getProperty("line.separator");
        String actualResult = paint.pyramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s", ln, ln, ln);
        assertThat(actualResult, is(expected));
    }
}