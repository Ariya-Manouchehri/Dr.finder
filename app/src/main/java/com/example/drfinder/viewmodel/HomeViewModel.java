package com.example.drfinder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drfinder.model.HomeViewPager;
import com.example.drfinder.model.OurDoctor;
import com.example.drfinder.model.Doctor;
import com.example.drfinder.utils.Repository;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    public LiveData<List<Doctor>> getPopularDoctor(){
        return Repository.getInstance().getPopularDoctor();
    }

    public LiveData<List<OurDoctor>> getOurDoctor(){
        return Repository.getInstance().getOurDoctor();
    }

    public LiveData<ArrayList<HomeViewPager>> getHomeViewPager(){
        return Repository.getInstance().getHomeViewPager();
    }
}
