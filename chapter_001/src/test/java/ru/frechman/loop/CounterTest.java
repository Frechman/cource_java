package ru.frechman.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Counter.
 */
public class CounterTest {

    @Test
    public void testAdd() {
        Counter count = new Counter();
        int start = -4;
        int finish = 10;

        int actualResult = count.add(start, finish);
        int expected = 24;

        assertThat(actualResult, is(expected));
    }

    @Test
    public void testAddFromOneToTen() {
        Counter count = new Counter();
        int start = 1;
        int finish = 10;

        int actualResult = count.add(start, finish);
        int expected = 30;

        assertThat(actualResult, is(expected));

        assertEquals(0, count.add(-30, 30));
        assertEquals(2550, count.add(0, 100));
        assertEquals(2548, count.add(-2, 100));
    }
}