package com.example.drfinder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drfinder.model.Appointment;
import com.example.drfinder.utils.Repository;

import java.util.List;

public class ProfileViewModel extends ViewModel {
    public LiveData<List<Appointment>> getAppointmentList() {
        return Repository.getInstance().getAppointmentList();
    }

    public LiveData<Integer> setCommentForDoctor(int doctorId, String comment, String username, float rating) {
        return Repository.getInstance().setCommentForDoctor(doctorId, comment, username, rating);
    }
}
