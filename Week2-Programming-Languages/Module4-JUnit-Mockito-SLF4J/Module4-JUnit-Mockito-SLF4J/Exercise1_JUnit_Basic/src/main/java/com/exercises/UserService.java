package com.exercises;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<String> users = new ArrayList<>();

    public boolean addUser(String username) {
        if (username == null || username.trim().isEmpty()) return false;
        users.add(username.trim());
        return true;
    }

    public boolean userExists(String username) { return users.contains(username); }
    public boolean removeUser(String username) { return users.remove(username); }
    public int getUserCount() { return users.size(); }
    public void clear() { users.clear(); }
}
