package ru.frechman.department;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentSortTest {

    private DepartmentSort departmentSort = new DepartmentSort();
    private String[] unsortedDepart = {
            "K1\\SK1",
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2",
            "A1\\B2",
            "A1\\B1\\C1\\D1",
            "A1\\B1\\C1\\D3"
    };

    private static List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }

    @Test
    public void testSortAscOrder() {
        String[] expectedSortInAscendingOrder = {
                "A1",
                "A1\\B1",
                "A1\\B1\\C1",
                "A1\\B1\\C1\\D1",
                "A1\\B1\\C1\\D3",
                "A1\\B2",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };

        assertArrayEquals(expectedSortInAscendingOrder,
                departmentSort.sortAscOrder(unsortedDepart));
    }

    @Test
    public void sortDescOrder() {
    }
}