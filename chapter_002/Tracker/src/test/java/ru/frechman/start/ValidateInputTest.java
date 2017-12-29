package ru.frechman.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    /**
     * Вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * Массив для сохранения в него данных.
     */
    private ByteArrayOutputStream arrOut = new ByteArrayOutputStream();

    /**
     * Меняем стандартный поток вывода в консоль,
     * на вывод в наш массив.
     */
    @Before
    public void loadStream() {
        System.setOut(new PrintStream(arrOut));
    }

    /**
     * Устанавливаем стандартный вывод в консоль.
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
        assertThat(new String(arrOut.toByteArray()), is(String.format("Please, enter validate data again.%n")));
    }

}