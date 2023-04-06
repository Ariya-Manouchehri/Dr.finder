package com.example.drfinder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ActivityDoctorBinding;
import com.example.drfinder.fragment.SignInFragmentDirections;
import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.viewmodel.DoctorActivityViewModel;

public class DoctorActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityDoctorBinding binding;
    DoctorActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_doctor);
        viewModel = new ViewModelProvider(this).get(DoctorActivityViewModel.class);
        DoctorActivityEventListener listener = new DoctorActivityEventListener();

        viewModel.getDoctor(getIntent().getExtras().getInt("id")).observe(this, popularDoctor -> {
            binding.setModel(popularDoctor);
        });

        binding.setListener(listener);
        binding.backIcon.setOnClickListener(this);
    }
    public class DoctorActivityEventListener {
        public void goToAppointmentActivity(View view,PopularDoctor model) {
            Intent intent = new Intent(DoctorActivity.this,AppointmentActivity.class);
            intent.putExtra("id",model.getId());
            startActivity(intent);
        }
    }
    @Override
    public void onClick(View v) {
        finish();
    }
}