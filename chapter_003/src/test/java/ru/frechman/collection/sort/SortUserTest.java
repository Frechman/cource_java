package ru.frechman.collection.sort;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class SortUserTest {

    /**
     * List of users for tests.
     */
    private final List<User> listUsers = new LinkedList<>();

    /**
     * The instance class SortUser for run sorting methods.
     */
    private final SortUser sortUser = new SortUser();

    /**
     * Filling the listUsers before each test.
     */
    @Before
    public void fillList() {
        listUsers.add(new User("Ivan", 65));
        listUsers.add(new User("Alexander", 66));
        listUsers.add(new User("Pert", 122));
        listUsers.add(new User("Ivan", 54));
        listUsers.add(new User("Sergey", 52));
    }

    /**
     * Clearing the listUsers after each test.
     */
   /* @After
    public void clearList() {
        listUsers.clear();
    }*/

    @Test
    public void testSort() {
        Set<User> actual = sortUser.sort(listUsers);
        assertArrayEquals(new User[]{
                new User("Sergey", 52),
                new User("Ivan", 54),
                new User("Ivan", 65),
                new User("Alexander", 66),
                new User("Pert", 122)
        }, actual.toArray());
    }

    @Test
    public void testSortNameLength() {
        assertThat(sortUser.sortNameLength(listUsers),
                is(
                        Arrays.asList(
                                new User("Ivan", 65),
                                new User("Pert", 122),
                                new User("Ivan", 54),
                                new User("Sergey", 52),
                                new User("Alexander", 66)
                        )
                )
        );
    }

    @Test
    public void testSortByAllFields() {
        assertThat(sortUser.sortByAllFields(listUsers),
                is(
                        Arrays.asList(
                                new User("Alexander", 66),
                                new User("Ivan", 54),
                                new User("Ivan", 65),
                                new User("Pert", 122),
                                new User("Sergey", 52)
                        )
                )
        );
    }
}