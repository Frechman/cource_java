package task;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CoffeeMachineTest {

    private CoffeeMachine coffeeMachine = new CoffeeMachine();

    List<Integer> coins(Integer... ints) {
        return new ArrayList<>(Arrays.asList(ints));
    }

    @Test
    public void changeFor1() {
        assertEquals(coins(1), coffeeMachine.change(2, 1));
    }

    @Test
    public void changeFor2() {
        assertEquals(coins(2), coffeeMachine.change(4, 2));
    }

    @Test
    public void changeFor3() {
        assertEquals(coins(2, 1), coffeeMachine.change(50, 47));
    }

    @Test
    public void changeFor4() {
        assertEquals(coins(2, 2), coffeeMachine.change(50, 46));
    }

    @Test
    public void changeFor5() {
        assertEquals(coins(5), coffeeMachine.change(50, 45));
    }

    @Test
    public void changeFor7() {
        assertEquals(coins(5, 2), coffeeMachine.change(100, 93));
    }

    @Test
    public void changeFor9() {
        assertEquals(coins(5, 2, 2), coffeeMachine.change(50, 41));
    }

    @Test
    public void changeFor10() {
        assertEquals(coins(10), coffeeMachine.change(50, 40));
    }

    @Test
    public void changeFor13() {
        assertEquals(coins(10, 2, 1), coffeeMachine.change(50, 37));
    }

    @Test
    public void changeFor16() {
        assertEquals(coins(10, 5, 1), coffeeMachine.change(50, 34));
    }

    @Test
    public void changeFor23() {
        assertEquals(coins(10, 10, 2, 1), coffeeMachine.change(50, 27));
    }

    @Test
    public void changeFor38() {
        assertEquals(coins(10, 10, 10, 5, 2, 1), coffeeMachine.change(100, 62));
    }

    @Test
    public void changeFor189() {
        assertEquals(coins(100, 50, 10, 10, 10, 5, 2, 2), coffeeMachine.change(500, 311));
    }

    @Test
    public void banknote50price35changeFor15() {
        assertEquals(coins(10, 5), coffeeMachine.change(50, 35));
    }

    /*
    //for return int[]
    @Test
    public void changes() {
        int value = 50;
        int price = 35;
        int[] expected = {10, 5};
        int[] actual = coffeeMachine.change(value, price);
        assertArrayEquals(expected, actual);
    }
    */

}