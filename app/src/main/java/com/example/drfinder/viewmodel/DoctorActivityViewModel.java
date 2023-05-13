package com.example.drfinder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drfinder.model.Appointment;
import com.example.drfinder.model.Comment;
import com.example.drfinder.model.Doctor;
import com.example.drfinder.model.Schedules;
import com.example.drfinder.model.WorkingHours;
import com.example.drfinder.utils.Repository;

import java.util.List;

public class DoctorActivityViewModel extends ViewModel {

    public LiveData<Doctor> getDoctor(int id){
        return Repository.getInstance().getDoctor(id);
    }

    public LiveData<List<WorkingHours>> getDoctorWorkingHours(){
        return Repository.getInstance().getDoctorWorkingHours();
    }

    public LiveData<List<Schedules>> getDoctorSchedule(){
        return Repository.getInstance().getDoctorSchedule();
    }

    public LiveData<Integer> setDoctorForUser(Appointment appointment){
        return Repository.getInstance().setDoctorForUser(appointment);
    }

    public LiveData<List<Comment>> getDoctorComment(int id){
        return Repository.getInstance().getDoctorComment(id);
    }
}
