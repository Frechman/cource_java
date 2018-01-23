package ru.frechman.array;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Tests for the Turn.
 */
public class ArrayDuplicateTest {

    @Test
    public void testDuplicateInArray() {
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expected = {"Привет", "Мир", "Супер"};

        ArrayDuplicate arrayDup = new ArrayDuplicate();
        String[] actualResult = arrayDup.removeDuplicates(array);

        assertThat(actualResult, arrayContainingInAnyOrder(expected));
    }

    @Test
    public void testNotDuplicateInArray() {
        String[] array = {"Hello", "World", "Super", "Puper", "Duper", "Flow"};
        String[] expected = {"Hello", "World", "Super", "Puper", "Duper", "Flow"};

        ArrayDuplicate arrayDup = new ArrayDuplicate();
        String[] actualResult = arrayDup.removeDuplicates(array);

        assertThat(actualResult, arrayContainingInAnyOrder(expected));
    }
}