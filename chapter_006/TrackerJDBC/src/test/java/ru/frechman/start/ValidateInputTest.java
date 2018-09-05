package ru.frechman.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    private ClassLoader cl = TrackerTest.class.getClassLoader();
    private URL resource = cl.getResource("appH2DB.properties");
    private File config = new File(resource.getPath());

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
            .append("1. Add new item.").append(System.lineSeparator())
            .append("2. Show all items.").append(System.lineSeparator())
            .append("3. Edit item.").append(System.lineSeparator())
            .append("4. Delete item.").append(System.lineSeparator())
            .append("5. Find item by id.").append(System.lineSeparator())
            .append("6. Find items by name.").append(System.lineSeparator())
            .append("7. Exit program.").append(System.lineSeparator())
            .append(System.lineSeparator());


    @Test
    public void whenMenuItemNotFoundAndNoValidateThenTestValidateInput() {
        String[] userAction = {"asd", "8", "j", "7"};
        StubInput input1 = new StubInput(userAction);
        ValidateInput input = new ValidateInput(input1);
        new StartUI(input, new Tracker(config)).init();

        assertThat(new String(this.arrOut.toByteArray()),
                is(
                        String.valueOf(sbMenu) +
                                "Please, enter validate data again." +
                                System.lineSeparator() +
                                "Please, enter item from menu." +
                                System.lineSeparator() +
                                "Please, enter validate data again." +
                                System.lineSeparator() +
                                "I'll be back!" + System.lineSeparator()
                )
        );
    }

    @Test
    public void whenInvalidInputThenErrorMessage() {
        String[] userChoice = {"sadf", "7"};
        ValidateInput validateInput = new ValidateInput(new StubInput(userChoice));

        validateInput.ask("Введите пункт меню", new int[]{1, 2, 3, 4, 5, 6, 7});
        assertThat(new String(arrOut.toByteArray()),
                is(String.format("Please, enter validate data again.%n")));
    }

}