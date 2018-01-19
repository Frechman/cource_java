package ru.frechman.collection.sort;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class SortUserTest {

    @Test
    public void sort() {
        List<User> listUsers = new LinkedList<>();
        listUsers.add(new User("pert", 122));
        listUsers.add(new User("per4t1", 52));
        listUsers.add(new User("per4t2", 66));
        listUsers.add(new User("pe4rt3", 12));

        SortUser sort = new SortUser();
        Set<User> actual = sort.sort(listUsers);
        assertArrayEquals(new User[]{
                new User("pe4rt3", 12),
                new User("per4t1", 52),
                new User("per4t2", 66),
                new User("pert", 122)
        }, actual.toArray());
    }
}