package task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CoffeeMachineTest {

    @Test
    public void changes() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        int price = 50;
        int[] expected = {10, 5};

        assertThat(coffeeMachine.changes(35, price), is(expected));
    }
}