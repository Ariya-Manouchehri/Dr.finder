package com.example.drfinder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drfinder.model.Doctor;
import com.example.drfinder.model.JobSide;
import com.example.drfinder.utils.Repository;

import java.util.List;

public class DoctorListActivityViewModel extends ViewModel {

    public LiveData<List<Doctor>> getAllPopularDoctor(){
        return Repository.getInstance().getAllPopularDoctor();
    }

    public LiveData<List<Doctor>> getFilterDoctor(String job_side){
        return Repository.getInstance().getFilterDoctor(job_side);
    }

    public LiveData<List<JobSide>> getFilterItem(){
        return Repository.getInstance().getFilterItem();
    }
}
