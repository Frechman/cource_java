package ru.frechman.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for class Factorial.
 */
public class FactorialTest {

    private final Factorial fact = new Factorial();

    @Test
    public void testCalcMethod() {
        assertThat(fact.calc(5), is(120));
        assertThat(fact.calc(1), is(1));
    }

    @Test
    public void whenFactFiveThen120() {
        assertThat(fact.factorial(5), is(120));
    }

    @Test
    public void whenFactZeroThenOne() {
        assertThat(fact.factorial(0), is(1));
    }

    @Test
    public void testFactorialStream() {
        Factorial fact = new Factorial();

        assertThat(fact.factorialStream(20), is(2432902008176640000L));
        assertThat(fact.factorialStream(0), is(1L));
        assertThat(fact.factorialStream(1), is(1L));
        assertThat(fact.factorialStream(2), is(2L));
        assertThat(fact.factorialStream(5), is(120L));
    }

    @Test
    public void testStaticFactor1When5FactThen120() {
        assertThat(Factorial.factor1(5), is(120L));
    }

    @Test
    public void testStaticFactor2When10FactThen120() {
        assertThat(Factorial.factor2(10), is(3628800L));
    }
}