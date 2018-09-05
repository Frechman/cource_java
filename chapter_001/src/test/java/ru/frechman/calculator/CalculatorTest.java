package ru.frechman.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    public void whenOneAddOneThenTwo() {
        calc.add(1, 1);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenZeroAddOTenThenTen() {
        calc.add(0D, 10D);
        double result = calc.getResult();
        double expected = 10D;
        assertThat(result, is(expected));
    }

    @Test
    public void Add() {
        calc.add(-10D, 5D);
        assertEquals(-5D, calc.getResult(), 0D);

        calc.add(10D, -5D);
        assertEquals(5D, calc.getResult(), 0D);

        calc.add(0D, 5D);
        assertEquals(5D, calc.getResult(), 0D);

        calc.add(0, -25D);
        assertEquals(-25D, calc.getResult(), 0D);

        calc.add(-10D, 0);
        assertEquals(-10D, calc.getResult(), 0D);
    }

    @Test
    public void subtract() {
        calc.subtract(10, 5);
        double result = calc.getResult();
        double expected = 5;
        assertThat(result, is(expected));

        calc.subtract(10D, 0);
        assertThat(calc.getResult(), is(10D));

        calc.subtract(0, -15D);
        assertThat(calc.getResult(), is(15D));

        calc.subtract(-10D, 15D);
        assertThat(calc.getResult(), is(-25D));

        calc.subtract(-5D, -15);
        assertThat(calc.getResult(), is(10D));

        calc.subtract(200D, 999D);
        assertEquals(-799D, calc.getResult(), 0D);

        calc.subtract(0D, 999D);
        assertEquals(-999D, calc.getResult(), 0D);
    }

    @Test
    public void div() {
        calc.div(10, 5);
        double actual = calc.getResult();
        double expected = 2;
        assertThat(actual, is(expected));

        calc.div(0D, 5D);
        assertEquals(0, calc.getResult(), 0D);

        calc.div(99, 33);
        assertEquals(3, calc.getResult(), 0D);

        calc.div(3D, 4D);
        assertEquals(0.75D, calc.getResult(), 0D);

        calc.div(2D, -3D);
        assertEquals(-0.66666D, calc.getResult(), 0.00001D);

        calc.div(-5D, 5D);
        assertEquals(-1D, calc.getResult(), 0D);

        calc.div(-5D, 0);
        assertEquals(Double.NEGATIVE_INFINITY, calc.getResult(), 0D);

        calc.div(5D, 0F);
        assertEquals(Double.POSITIVE_INFINITY, calc.getResult(), 0D);
    }

    @Test
    public void whenFiveMultiplyFiveThen25() {
        calc.multiple(5D, 5D);
        double actual = calc.getResult();
        double expected = 25D;
        assertThat(actual, is(expected));
    }

    @Test
    public void whenNegativeTenMultiplyTenThenNegativeHundred() {
        calc.multiple(-10D, 10D);
        double actualResult = -100D;
        double expected = calc.getResult();
        assertThat(actualResult, is(expected));
    }

    @Test
    public void manyDifferentMultiply() {
        calc.multiple(-10D, -10D);
        assertEquals(100D, calc.getResult(), 0D);

        calc.multiple(0, 0);
        assertEquals(0D, calc.getResult(), 0D);

        calc.multiple(0D, 10D);
        assertEquals(0D, calc.getResult(), 0D);

        calc.multiple(9, 9);
        assertEquals(81, calc.getResult(), 0.000001);

        calc.multiple(2, 2);
        assertEquals(4, calc.getResult(), 0);

        calc.multiple(-10D, 0);
        assertEquals(0D, calc.getResult(), 0D);

        calc.multiple(0D, -10D);
        assertEquals(0, calc.getResult(), 0D);

        calc.multiple(11D, 11D);
        assertEquals(121, calc.getResult(), 0);

        calc.multiple(10D, -10D);
        assertEquals(-100D, calc.getResult(), 0D);
    }
}