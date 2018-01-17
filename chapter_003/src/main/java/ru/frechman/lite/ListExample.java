package ru.frechman.lite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListExample {

    static class User {

        private final String name;

        private User(String name) {
            this.name = name;
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
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + '}';
        }

        public int getInt(int max) {
            return 9;
        }

    }

    static class UserPet extends User {

        private UserPet(String name) {
            super(name);
        }
    }


    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.addAll(Arrays.asList(new User("pert"), new User("serj")));

        Iterator<User> iterator = users.iterator();

        for (User user : users) {
            System.out.println(user);
        }

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        users.forEach(user -> System.out.println(user));

        users.forEach(System.out::println);
    }

}
