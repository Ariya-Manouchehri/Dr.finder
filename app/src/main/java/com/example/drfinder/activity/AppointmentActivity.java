package com.example.drfinder.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.drfinder.R;
import com.example.drfinder.adapter.ScheduleRecyclerview;
import com.example.drfinder.adapter.WorkingHoursRecyclerview;
import com.example.drfinder.databinding.ActivityAppointmentBinding;
import com.example.drfinder.model.Schedules;
import com.example.drfinder.model.WorkingHours;
import com.example.drfinder.viewmodel.DoctorActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class AppointmentActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityAppointmentBinding binding;
    DoctorActivityViewModel viewModel;

    WorkingHoursRecyclerview workingHoursRecyclerview = new WorkingHoursRecyclerview();
    ArrayList<WorkingHours> workingHoursArrayList = new ArrayList<>();

    ScheduleRecyclerview scheduleRecyclerview  = new ScheduleRecyclerview();
    ArrayList<Schedules> schedulesArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_appointment);
        viewModel = new ViewModelProvider(this).get(DoctorActivityViewModel.class);

        viewModel.getDoctor(getIntent().getExtras().getInt("id")).observe(this, popularDoctor -> {
            binding.setModel(popularDoctor);
        });
        viewModel.getDoctorWorkingHours().observe(this, workingHours -> {

        });

        viewModel.getDoctorWorkingHours().observe(this, new Observer<List<WorkingHours>>() {
            @Override
            public void onChanged(List<WorkingHours> workingHours) {
                workingHoursArrayList = (ArrayList<WorkingHours>) workingHours;
                workingHoursRecyclerview.setWorkingHoursArrayList(workingHoursArrayList);
                binding.recyclerViewWorkingHours.setAdapter(workingHoursRecyclerview);
                binding.recyclerViewWorkingHours.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            }
        });

        viewModel.getDoctorSchedule().observe(this, new Observer<List<Schedules>>() {
            @Override
            public void onChanged(List<Schedules> schedules) {
                schedulesArrayList = (ArrayList<Schedules>) schedules;
                scheduleRecyclerview.setWorkingHoursArrayList(schedulesArrayList);
                binding.SchedulesRecyclerview.setAdapter(scheduleRecyclerview);
                binding.SchedulesRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            }
        });

        binding.backIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}