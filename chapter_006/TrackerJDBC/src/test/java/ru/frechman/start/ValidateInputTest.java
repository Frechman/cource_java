package ru.frechman.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    /**
     * Output in console.
     */
    private final PrintStream stdout = System.out;

    /**
     * Array for save data from user's input.
     */
    private final ByteArrayOutputStream arrOut = new ByteArrayOutputStream();

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
        System.setOut(this.stdout);
    }

    private final StringBuilder sbMenu = new StringBuilder()
            .append("1. Add new Item.").append(System.lineSeparator())
            .append("2. Show all items.").append(System.lineSeparator())
            .append("3. Edit item.").append(System.lineSeparator())
            .append("4. Delete item.").append(System.lineSeparator())
            .append("5. Find item by Id.").append(System.lineSeparator())
            .append("6. Find items by name.").append(System.lineSeparator())
            .append("7. Exit Program.").append(System.lineSeparator())
            .append(System.lineSeparator());


    @Test
    public void whenMenuItemNotFoundAndNoValidateThenTestValidateInput() {
        String[] userAction = {"asd", "8", "j", "7"};
        StubInput input1 = new StubInput(userAction);
        ValidateInput input = new ValidateInput(input1);
        new StartUI(input, new Tracker()).init();

        assertThat(new String(this.arrOut.toByteArray()),
                is(
                        new StringBuilder().append(sbMenu)
                                .append("Please, enter validate data again.")
                                .append(System.lineSeparator())
                                .append("Please, enter item from menu.")
                                .append(System.lineSeparator())
                                .append("Please, enter validate data again.")
                                .append(System.lineSeparator())
                                .append("I'll be back!").append(System.lineSeparator())
                                .toString()
                )
        );
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