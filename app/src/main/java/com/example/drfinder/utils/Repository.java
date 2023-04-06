package com.example.drfinder.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.drfinder.backend.BackEnd;
import com.example.drfinder.model.HomeViewPager;
import com.example.drfinder.model.JobSide;
import com.example.drfinder.model.OurDoctor;
import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.model.Schedules;
import com.example.drfinder.model.WorkingHours;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository instance = null;

    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public LiveData<List<PopularDoctor>> getPopularDoctor() {
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getPopularDoctor());
        return liveData;
    }

    public LiveData<List<OurDoctor>> getOurDoctor(){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getOurDoctor());
        return liveData;
    }

    public LiveData<ArrayList<HomeViewPager>> getHomeViewPager(){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getHomeViewPager());
        return liveData;
    }
    public LiveData<PopularDoctor> getDoctor(int id){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getDoctor(id));
        return liveData;
    }

    public LiveData<List<WorkingHours>> getDoctorWorkingHours(){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getDoctorWorkingHours());
        return liveData;
    }

    public LiveData<List<PopularDoctor>> getAllPopularDoctor(){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getAllPopularDoctor());
        return liveData;
    }

    public LiveData<Integer> signInButtonPressed(String username, String password){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().signInButtonPressed(username,password));
        return liveData;
    }

    public LiveData<Integer> signUpButtonPressed(String username, String password, String confirmPassword){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().signUpButtonPressed(username,password,confirmPassword));
        return liveData;
    }
    public LiveData<List<PopularDoctor>> getDoctorByCategory(String job_side){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getDoctorByCategory(job_side));
        return liveData;
    }

    public LiveData<List<PopularDoctor>> getFilterDoctor(String job_side){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getFilterDoctor(job_side));
        return liveData;
    }
    public LiveData<List<JobSide>> getFilterItem(){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getFilterItem());
        return liveData;
    }
    public LiveData<List<Schedules>> getDoctorSchedule(){
        MutableLiveData liveData = new MutableLiveData();
        liveData.setValue(BackEnd.getInstance().getDoctorSchedule());
        return liveData;
    }

}
