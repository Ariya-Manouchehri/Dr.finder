package com.example.drfinder.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drfinder.R;
import com.example.drfinder.activity.DoctorActivity;
import com.example.drfinder.activity.DoctorListActivity;
import com.example.drfinder.activity.OurDoctorListActivity;
import com.example.drfinder.adapter.HomeViewPagerAdapter;
import com.example.drfinder.adapter.OurDoctorRecyclerview;
import com.example.drfinder.databinding.FragmentHomeBinding;
import com.example.drfinder.model.Doctor;
import com.example.drfinder.model.HomeViewPager;
import com.example.drfinder.model.OurDoctor;
import com.example.drfinder.adapter.PopularDoctorRecyclerview;
import com.example.drfinder.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment implements PopularDoctorRecyclerview.setOnClickListener, OurDoctorRecyclerview.setOnItemCLickListener {
    final Handler handler = new Handler();
    public Timer swipeTimer ;

    FragmentHomeBinding binding;
    HomeViewModel viewModel;

    PopularDoctorRecyclerview popularDoctorAdapter = new PopularDoctorRecyclerview();
    ArrayList<Doctor> popularDoctorArrayList = new ArrayList<>();

    OurDoctorRecyclerview ourDoctorAdapter = new OurDoctorRecyclerview();
    ArrayList<OurDoctor> ourDoctorArrayList = new ArrayList<>();

    ArrayList<HomeViewPager> homeViewPagerArrayList = new ArrayList<>();
    HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        setOurDoctor();
        setPopularDoctor();
        setViewPager();
        setTimer(binding.viewPager,4,3,0);
        showAllPopularDoctor();
        popularDoctorAdapter.setOnItemCLickListener(this);
        ourDoctorAdapter.setOnCLickListener(this);
    }

    public void setTimer(final ViewPager2 myPager, int time, final int numPages, final int curPage){

        final Runnable Update = new Runnable() {
            int NUM_PAGES =numPages;
            int currentPage = curPage;
            public void run() {
                if (currentPage == NUM_PAGES ) {
                    currentPage = 0;
                }
                myPager.setCurrentItem(currentPage++, true);
            }
        };

        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, time*1000);

    }

    public void stopTimer(){
        //handler.removeCallbacks(null);
        swipeTimer.cancel();
    }

    private void showAllPopularDoctor() {
        binding.popularDoctorSeeAll.setOnClickListener(v -> startActivity(new Intent(getActivity(), DoctorListActivity.class)));
        binding.ourDoctorSeeAll.setOnClickListener(v -> startActivity(new Intent(getActivity(), DoctorListActivity.class)));
    }

    private void setOurDoctor() {
        viewModel.getOurDoctor().observe(getViewLifecycleOwner(), ourDoctors -> {
            ourDoctorArrayList = (ArrayList<OurDoctor>) ourDoctors;
            ourDoctorAdapter.setOurDoctorArrayList(ourDoctorArrayList);

            binding.ourDoctorRecyclerview.setAdapter(ourDoctorAdapter);
            binding.ourDoctorRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        });

    }

    private void setPopularDoctor() {
        viewModel.getPopularDoctor().observe(getViewLifecycleOwner(), popularDoctors -> {
            popularDoctorArrayList = (ArrayList<Doctor>) popularDoctors;
            popularDoctorAdapter.setPopularDoctorArrayList(popularDoctorArrayList);

            binding.popularDoctorRecyclerview.setAdapter(popularDoctorAdapter);
            binding.popularDoctorRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        });
    }

    private void setViewPager() {
        viewModel.getHomeViewPager().observe(getViewLifecycleOwner(), homeViewPagers -> {
            homeViewPagerArrayList = homeViewPagers;
            homeViewPagerAdapter.setHomeViewPagerArrayList(homeViewPagerArrayList);

            binding.viewPager.setAdapter(homeViewPagerAdapter);
            binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }

                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    stopTimer();
                    setTimer(binding.viewPager,4,4,position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    super.onPageScrollStateChanged(state);
                }
            });
            binding.dotsIndicator.attachTo(binding.viewPager);
        });
    }

    @Override
    public void setOnCLickListener(int id) {
        Intent intent = new Intent(getActivity(), DoctorActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void setOnClickListener(String category_name) {
        Intent intent = new Intent(getActivity(), OurDoctorListActivity.class);
        intent.putExtra("category_name", category_name);
        startActivity(intent);
    }
}