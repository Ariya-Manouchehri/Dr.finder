package com.example.drfinder.backend;

import com.example.drfinder.model.User;

public class SignInSIgnUp {

    public static int SignIn(String username, String password){
        if (username.isEmpty() || username.contains(".") || username.contains("&") || username.contains("@") || username.contains(" ")) {
            return -1;
        }
        if (password.isEmpty() || password.contains(".") || password.contains("&") || password.contains("@") || password.contains(" ")) {
            return 0;
        }
        if (Users.getInstance().findUser(new User(username, password))){
        return 1;
        }else {
            return -2;
        }
    }
    public static int SignUp(String username, String password, String confirmPassword){
        if (username.isEmpty() || username.contains(".") || username.contains("&") || username.contains("@") || username.contains(" ")) {
            return -1;
        }
        if (password.isEmpty() || password.contains(".") || password.contains("&") || password.contains("@") || password.contains(" ")) {
            return 0;
        }
        if (!password.equals(confirmPassword)) {
            return -2;
        }
        if (Users.getInstance().uniqueUser(new User(username, password))){
            return -3;
        }else {
            Users.getInstance().addUserToList(new User(username, password));
            return 1;
        }
    }
}
