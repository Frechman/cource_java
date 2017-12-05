package ru.frechman.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса Max.
 *
 */
public class MaxTest {

    @Test
    public void whenFirstBetterSecond(){
        Max max = new Max();
        assertThat(max.max(5,2), is(5));
        assertThat(max.max(5,-5), is(5));
        assertThat(max.max(-2,-10), is(-2));
    }

    @Test
    public void whenFirstLessSecond(){
        Max max = new Max();
        assertThat(max.max(0,25), is(25));
        assertThat(max.max(-10,0), is(0));
        assertThat(max.max(-15,-2), is(-2));
    }
}