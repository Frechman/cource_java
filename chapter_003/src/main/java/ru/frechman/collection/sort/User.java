package ru.frechman.collection.sort;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User>, Comparator<User> {

    private final String name;

    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Sort by age user. Implements Comparable.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal
     * to, or greater than the specified object.
     */
    @Override
    public int compareTo(User o) {
        //return this.age > o.age ? 1 : (this.age == o.age) ? 0 : -1;
        return Integer.compare(this.age, o.age);
    }

    /**
     * Sort by name and age user. Implements Comparator. If o1.name == o2.name, then sort by age.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     * equal to, or greater than the second.
     */
    @Override
    public int compare(User o1, User o2) {
        final int result = o1.name.compareTo(o2.name);
        return result != 0 ? result : Integer.compare(o1.age, o2.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }
}
