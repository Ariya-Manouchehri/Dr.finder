package com.example.drfinder.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.drfinder.R;
import com.example.drfinder.adapter.DoctorListRecyclerview;
import com.example.drfinder.adapter.PopularDoctorRecyclerview;
import com.example.drfinder.databinding.ActivityDoctorBinding;
import com.example.drfinder.databinding.ActivityOurDoctorListBinding;
import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.viewmodel.OurDoctorListActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class OurDoctorListActivity extends AppCompatActivity {
    ActivityOurDoctorListBinding binding;
    OurDoctorListActivityViewModel viewModel;

    DoctorListRecyclerview doctorListAdapter = new DoctorListRecyclerview();
    ArrayList<PopularDoctor> popularDoctorArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_our_doctor_list);
        viewModel = new ViewModelProvider(this).get(OurDoctorListActivityViewModel.class);

        viewModel.getDoctorByCategory(getIntent().getExtras().getString("category_name")).observe(this, new Observer<List<PopularDoctor>>() {
            @Override
            public void onChanged(List<PopularDoctor> popularDoctors) {
                popularDoctorArrayList = (ArrayList<PopularDoctor>) popularDoctors;
                doctorListAdapter.setDoctorListArrayList(popularDoctorArrayList);
                binding.ourDoctorList.setAdapter(doctorListAdapter);
                binding.ourDoctorList.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            }
        });

    }
}