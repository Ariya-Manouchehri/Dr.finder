package com.example.drfinder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drfinder.model.Appointment;
import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.model.Schedules;
import com.example.drfinder.model.WorkingHours;
import com.example.drfinder.utils.Repository;

import java.util.List;

public class DoctorActivityViewModel extends ViewModel {

    public LiveData<PopularDoctor> getDoctor(int id){
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
}
