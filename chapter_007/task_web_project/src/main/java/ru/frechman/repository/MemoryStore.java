package ru.frechman.repository;

import ru.frechman.model.User;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryStore implements Store {

    private static final MemoryStore INSTANCE = new MemoryStore();

    private MemoryStore() {
    }

    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    private final Map<Long, User> userStore = new ConcurrentHashMap<>();
    private AtomicLong seqId = new AtomicLong(0);

    @Override
    public User add(User user) {
        user.setId(seqId.getAndIncrement());
        user.setCreateDate(new Date());
        this.userStore.put(user.getId(), user);
        return user;
    }

    @Override
    public boolean update(Long id, User user) {
        return userStore.put(id, user) != null;
    }

    @Override
    public boolean delete(Long id) {
        return userStore.remove(id) != null;
    }

    @Override
    public Collection<User> findAll() {
        return userStore.values();
    }

    @Override
    public User findById(Long id) {
        return userStore.get(id);
    }
}