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
        int arrayLength = array.length;
        if (index < arrayLength) {
            for (int i = index; i < arrayLength; i++) {
                if (isEven(array[i])) {
                    index = i; //need for next();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return array[index++];
        }
        throw new NoSuchElementException("No such element.");
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}