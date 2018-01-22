package ru.frechman.collection.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class for sort User.
 */
public class SortUser {

    /**
     * Convert List of users to Set of users with sort in TreeSet through Comparable in class User.
     * Sort by user age.
     *
     * @param users the list of users.
     * @return Set users.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Sort by name length user through ListCompare.
     *
     * @param listUser the collection users.
     * @return sorted list by name length.
     */
    public List<User> sortNameLength(List<User> listUser) {
        Collections.sort(listUser, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return listUser;
    }

    /**
     * Sorted by user name and user age.
     *
     * @param listUser the list users.
     * @return sorted list lexicographical by name users and by age users.
     */
    public List<User> sortByAllFields(List<User> listUser) {
        Collections.sort(listUser, new Comparator<User>() {
            /**
             * Sort by name and age user. Implements ListCompare. If o1.name ==
             * o2.name, then sort by age.
             *
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return a negative integer, zero, or a positive integer as the
             *         first argument is less than, equal to, or greater than
             *         the second.
             */
            @Override
            public int compare(User o1, User o2) {
                final int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result
                        : o1.getAge() < o2.getAge() ? -1 : (o1.getAge() == o2.getAge() ? 0 : -1);
            }
        });
        return listUser;
    }
}
