package ru.frechman.service;

import ru.frechman.model.User;
import ru.frechman.repository.MemoryStore;
import ru.frechman.repository.Store;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ValidateService {

    private final Store memoryStore = MemoryStore.getInstance();

    private static final ValidateService INSTANCE = new ValidateService();

    private ValidateService() {
    }

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    public User add(User user) {
        if (user != null) {
            return memoryStore.add(user);
        }
        return null;
    }

    public boolean update(Long id, User user) {
        User foundUser = memoryStore.findById(id);
        if (foundUser != null) {
            if (user.getName() != null) {
                foundUser.setName(user.getName());
            }
            if (user.getEmail() != null) {
                foundUser.setEmail(user.getEmail());
            }
            if (user.getLogin() != null) {
                foundUser.setLogin(user.getLogin());
            }
            return memoryStore.update(id, foundUser);
        }
        return false;
    }

    public boolean delete(Long id) {
        User foundUser = memoryStore.findById(id);
        return foundUser != null && memoryStore.delete(id);
    }

    public List<User> findAll() {
        Collection<User> all = memoryStore.findAll();
        return all != null ? new CopyOnWriteArrayList<>(all) : Collections.emptyList();
    }

    public User findById(Long id) {
        if (id != null) {
            return memoryStore.findById(id);
        }
        return null;
    }
}