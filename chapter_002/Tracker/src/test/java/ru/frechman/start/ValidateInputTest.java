package ru.frechman.start;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ValidateInputTest {

    /**
     * Output in console.
     */
    private final PrintStream stdout = System.out;

    /**
     * Array for save data from user's input.
     */
    private ByteArrayOutputStream arrOut = new ByteArrayOutputStream();

    /**
     * Change standard outputStream in console, to outputStream in ByteArray.
     */
    @Before
    public void loadStream() {
        System.setOut(new PrintStream(arrOut));
    }

    /**
     * Set standard outputStream in console .
     */
    @After
    public void backStream() {
        System.setOut(stdout);
    }

    @Ignore
    @Test
    public void test() {
        String[] userChoice = {"sdf", "8", "1"};
        new StartUI(new ValidateInput(new StubInput(userChoice)), new Tracker()).init();
        assertThat(this.arrOut.toByteArray().toString(), is("Please, enter item from menu."));
    }

    @Test
    public void whenInvalidInput() {
        String[] userChoice = {"sadf", "7"};
        ValidateInput validateInput = new ValidateInput(new StubInput(userChoice));

        validateInput.ask("Введите пункт меню", new int[]{1, 2, 3, 4, 5, 6, 7});
        assertThat(new String(arrOut.toByteArray()),
                is(String.format("Please, enter validate data again.%n")));
    }

}