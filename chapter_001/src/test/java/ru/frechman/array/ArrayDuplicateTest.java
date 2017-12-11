package ru.frechman.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

/**
 * Tests for the Turn.
 *
 */
public class ArrayDuplicateTest {

    @Test
    public void testDuplicateInArray() {
        String[] arr = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expected = {"Привет", "Мир", "Супер"};

        ArrayDuplicate arrayDup = new ArrayDuplicate();
        String[] actualResualt = arrayDup.remove(arr);
        assertThat(actualResualt, arrayContainingInAnyOrder(expected));
    }

    @Test
    public void testNotDuplicateInArray() {
        String[] arr = {"Hello", "World", "Super", "Puper", "Duper", "Flow"};
        String[] expected = {"Hello", "World", "Super", "Puper", "Duper", "Flow"};

        ArrayDuplicate arrayDup = new ArrayDuplicate();
        String[] actualResualt = arrayDup.remove(arr);
        assertThat(actualResualt, arrayContainingInAnyOrder(expected));
    }
}