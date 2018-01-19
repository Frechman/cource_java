package ru.frechman.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestCollections {

    public static void main(String[] args) {
        TestCollections testCollections = new TestCollections();
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        Set<String> treeSet = new TreeSet<>();

        System.out.println("time add in ArrayList: " + testCollections.add(arrayList, 1_000_000));
        System.out.println(
                "time delete in ArrayList: " + testCollections.delete(arrayList, 1_000_000));
        System.out.println();
        System.out.println("time add in LinkedList: " + testCollections.add(linkedList, 1_000_000));
        System.out.println(
                "time delete in LinkedList: " + testCollections.delete(linkedList, 1_000_000));
        System.out.println();
        System.out.println("time add in treeSet: " + testCollections.add(treeSet, 1_000_000));
        System.out.println("time delete in treeSet: " + testCollections.delete(treeSet, 1_000_000));
    }

    /**
     * The method checks spent time on the addition operation amount elements in the collection.
     *
     * @param collection the different implementations of the collection.
     * @param amount of elements.
     * @return time spent on the operation add to the collection.
     */
    public long add(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(i));
        }
        return System.currentTimeMillis() - startTime;
    }

    /**
     * The method checks spent time on the delete operation amount elements from the collection.
     *
     * @param collection the different implementations of the collection.
     * @param amount of elements.
     * @return time spent on the operation delete from the collection.
     */
    public long delete(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.remove(String.valueOf(i));
        }
        return System.currentTimeMillis() - startTime;
    }
}
