package ru.frechman.collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

public class UserConvertTest {


    @Test
    public void testConvertListToMap() {

        List<User> listUser = new ArrayList<>();
        User user = new User(1, "alex", "msk");
        User user2 = new User(2, "kaleb", "msk");
        User user3 = new User(3, "vanya", "mord");
        User user4 = new User(4, "sonya", "goa");
        User user5 = new User(5, "jorik", "talin");
        listUser.add(user);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);
        listUser.add(user5);

        UserConvert userConvert = new UserConvert();

        HashMap<Integer, User> actual = userConvert.process(listUser);
        HashMap<Integer, User> expected = new HashMap<>();
        listUser.forEach(a -> expected.put(a.getId(), a));

        assertThat(actual, is(expected));
    }

}