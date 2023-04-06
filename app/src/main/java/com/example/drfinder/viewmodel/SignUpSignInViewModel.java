package com.example.drfinder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.utils.Repository;

import java.util.List;

public class SignUpSignInViewModel extends ViewModel {

    public LiveData<Integer> signInButtonPressed(String username, String password) {
        return Repository.getInstance().signInButtonPressed(username, password);
    }

    public LiveData<Integer> signUpButtonPressed(String username, String password, String confirmPassword) {
        return Repository.getInstance().signUpButtonPressed(username, password, confirmPassword);
    }
}
