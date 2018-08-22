package ru.frechman.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorMultArray<E> implements Iterator<E> {

    private final E[][] array;
    private int count;
    private int row = 0;
    private int col = 0;

    public IteratorMultArray(E[][] array) {
        this.array = array;
        this.count = array.length;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (row < count) {
            if (col < array[row].length) {
                result = true;
            } else {
                for (int i = row + 1; i < count; i++) {
                    if (array[i].length > 0) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public E next() {
        while (row < count) {
            if (col < array[row].length) {
                return array[row][col++];
            } else {
                col = 0;
                row++;
            }
        }
        throw new NoSuchElementException("No such element.");
    }
}
