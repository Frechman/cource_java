package ru.frechman.collection.comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListCompare implements Comparator<List<Integer>> {

    /**
     * Compares its two arguments for order.  Returns a negative integer, zero, or a positive
     * integer as the first argument is less than, equal to, or greater than the second.
     *
     * @param left the first list of integer to be compared.
     * @param right the second list of integer to be compared
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     *         equal to, or greater than the second.
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int result = 0;
        Iterator<Integer> itrLeft = left.iterator();
        Iterator<Integer> itrRight = right.iterator();
        while (itrLeft.hasNext() && itrRight.hasNext()) {
            result = Integer.compare(itrLeft.next(), itrRight.next());
            if (result != 0) {
                break;
            }
        }
        return itrLeft.hasNext() ? 1 : !itrRight.hasNext() ? result : -1;
    }
}
