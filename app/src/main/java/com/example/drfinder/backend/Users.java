package com.example.drfinder.backend;

import com.example.drfinder.model.User;

import java.util.ArrayList;

public class Users {
    private static Users instance = null;
    ArrayList<User> userArrayList = new ArrayList<>();

    public static synchronized Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }
    public Users(){
        userArrayList.add(new User("ariya","137979"));
        userArrayList.add(new User("sara082","sara082"));
    }

    public void addUserToList(User user) {
        userArrayList.add(user);
    }

    public boolean findUser(User user) {
        for (User item : userArrayList) {
            if (item.getUsername().equals(user.getUsername()) && item.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean uniqueUser(User user) {
        for (User item : userArrayList) {
            if (item.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
