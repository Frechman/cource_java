package ru.frechman.bank;

import java.util.Objects;

public class User {

    private String name;

    private String passport;

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
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
        // if passports is equals, then not need check name.
        return Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}
