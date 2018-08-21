package ru.frechman.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            private final Iterator<Iterator<Integer>> iters = it;
            private Iterator<Integer> current;

            @Override
            public boolean hasNext() {
                while (current == null || !current.hasNext()) {
                    if (!iters.hasNext()) {
                        return false;
                    }
                    current = iters.next();
                }
                return current.hasNext();
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return current.next();
                }
                throw new NoSuchElementException();
            }
        };
    }
}
