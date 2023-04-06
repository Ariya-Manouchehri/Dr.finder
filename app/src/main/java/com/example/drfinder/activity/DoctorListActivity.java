package com.example.drfinder.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.drfinder.R;
import com.example.drfinder.adapter.DoctorListRecyclerview;
import com.example.drfinder.adapter.JobSideRecyclerview;
import com.example.drfinder.databinding.ActivityDoctorListBinding;
import com.example.drfinder.model.JobSide;
import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.viewmodel.DoctorListActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class DoctorListActivity extends AppCompatActivity implements DoctorListRecyclerview.setOnClickListener, JobSideRecyclerview.setOnClickListener, View.OnClickListener {
    ActivityDoctorListBinding binding;
    DoctorListActivityViewModel viewModel;

    DoctorListRecyclerview doctorListAdapter = new DoctorListRecyclerview();
    ArrayList<PopularDoctor> popularDoctorArrayList = new ArrayList<>();

    JobSideRecyclerview jobSideAdapter = new JobSideRecyclerview();
    ArrayList<JobSide> jobSideArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_doctor_list);
        viewModel = new ViewModelProvider(this).get(DoctorListActivityViewModel.class);

        jobSide();
        getDoctor();
        jobSideAdapter.setOnItemCLickListener(this);
        doctorListAdapter.setOnItemCLickListener(this);

        binding.backIcon.setOnClickListener(this);
    }

    private void jobSide() {
        viewModel.getFilterItem().observe(this, new Observer<List<JobSide>>() {
            @Override
            public void onChanged(List<JobSide> jobSides) {
                jobSideArrayList = (ArrayList<JobSide>) jobSides;
                jobSideAdapter.setJobSideListArrayList(jobSideArrayList);
                binding.selectJobSide.setAdapter(jobSideAdapter);
                binding.selectJobSide.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            }
        });
    }

    private void getDoctor() {
        viewModel.getFilterDoctor("All").observe(this, new Observer<List<PopularDoctor>>() {
            @Override
            public void onChanged(List<PopularDoctor> popularDoctors) {
                popularDoctorArrayList = (ArrayList<PopularDoctor>) popularDoctors;
                doctorListAdapter.setDoctorListArrayList(popularDoctorArrayList);
                binding.popularDoctorRecyclerview.setAdapter(doctorListAdapter);
                binding.popularDoctorRecyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            }
        });
    }

    @Override
    public void setOnCLickListener(int id) {
        Intent intent = new Intent(this, DoctorActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void setOnCLickListener(String jobSide) {
        viewModel.getFilterDoctor(jobSide).observe(this, new Observer<List<PopularDoctor>>() {
            @Override
            public void onChanged(List<PopularDoctor> popularDoctors) {
                popularDoctorArrayList = (ArrayList<PopularDoctor>) popularDoctors;
                doctorListAdapter.setDoctorListArrayList(popularDoctorArrayList);
                binding.popularDoctorRecyclerview.setAdapter(doctorListAdapter);
                binding.popularDoctorRecyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            }
        });
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}