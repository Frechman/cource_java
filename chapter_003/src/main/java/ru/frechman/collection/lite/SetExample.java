package ru.frechman.collection.lite;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(1);
        integerSet.add(0);
        integerSet.add(6);
        integerSet.add(3);
        integerSet.add(441);
        integerSet.add(100);

        integerSet.forEach(System.out::println);
    }

}
