package ru.frechman.collection;

import java.util.HashMap;
import java.util.List;

/**
 * Convert List to Map.
 */
public class UserConvert {


    /**
     * Convert List to Map.
     *
     * @param list the List.
     * @return Map, where key is User.id, and value is User.
     */
    public HashMap<Integer, User> process(List<User> list) {

        HashMap<Integer, User> mapUsers = new HashMap<>();
        for (User current : list) {
            mapUsers.put(current.getId(), current);
        }

        return mapUsers;
    }

}
