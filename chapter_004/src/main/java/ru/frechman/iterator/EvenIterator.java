package ru.frechman.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final int[] array;
    private int index = 0;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        int arrayLength = array.length;
        if (index < arrayLength) {
            for (int i = index; i < arrayLength; i++) {
                if (array[i] % 2 == 0) {
                    index = i; //need for next();
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return array[index++];
        }
        throw new NoSuchElementException("No such element.");
    }
}