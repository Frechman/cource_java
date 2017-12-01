package ru.frechman;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Calculate.
 *
 * @author Sergey Frechman
 * @version $id$
 * @since 0.1
 */
public class CalculateTest {

    /**
     * Test echo.
     */
    @Test
    public void whenTakeNameThenThreeEchoPlusName() {
        String input = "Frechman";
        String expect = "Echo, echo, echo: Frechman";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}