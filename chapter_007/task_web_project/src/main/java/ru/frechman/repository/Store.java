package ru.frechman.repository;

import ru.frechman.model.User;

import java.util.Collection;

public interface Store {

    User add(User user);

    boolean update(Long id, User user);

    boolean delete(Long id);

    Collection<User> findAll();

    User findById(Long id);
}