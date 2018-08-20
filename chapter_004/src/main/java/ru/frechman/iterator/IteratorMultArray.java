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
            for (int i = row; i < count; i++) {
                if (col < array[i].length) {
                    result = true;
                    break;
                } else {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }

    @Override
    public E next() {
        while (true) {
            if (row < count) {
                if (col < array[row].length) {
                    return array[row][col++];
                } else {
                    col = 0;
                    row++;
                }
            } else {
                throw new NoSuchElementException("No such element.");
            }
        }
    }
}
