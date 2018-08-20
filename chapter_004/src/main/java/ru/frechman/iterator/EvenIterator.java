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
        boolean rst = false;
        int arrayLength = array.length;
        for (int i = index; i < arrayLength; i++) {
            if (isEven(array[i])) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public Integer next() {
        int rst;
        int arrayLength = array.length;
        if (index < arrayLength) {
            for (int i = index; i < arrayLength; i++) {
                if (isEven(array[i])) {
                    rst = array[i++];
                    index = i;
                    return rst;
                }
            }
        }
        throw new NoSuchElementException("No such element.");
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}