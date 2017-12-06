package ru.frechman.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест класса Factorial.
 */
public class FactorialTest {

    @Test
    public void testCalcMethod() {
        Factorial fact = new Factorial();

        assertThat(fact.calc(5), is(120));
        assertThat(fact.calc(1), is(1));
    }

    @Test
    public void wnehFactFiveThen120() {
        Factorial fact = new Factorial();

        assertThat(fact.factorial(5), is(120));
    }

    @Test
    public void wnehFactZeroThenOne() {
        Factorial fact = new Factorial();

        assertThat(fact.factorial(0), is(1));
    }

    @Test
    public void testFactorialStream() {
        Factorial fact = new Factorial();

        assertThat(fact.factorialStream(20), is(2432902008176640000L));
        assertThat(fact.factorialStream(0), is(1L));
        assertThat(fact.factorialStream(1), is(1L));
    }
}