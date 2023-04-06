package com.example.drfinder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.utils.Repository;

import java.util.List;

public class OurDoctorListActivityViewModel extends ViewModel {

    public LiveData<List<PopularDoctor>> getDoctorByCategory(String job_side){
        return Repository.getInstance().getDoctorByCategory(job_side);
    }
}
