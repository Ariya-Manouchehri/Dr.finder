package com.example.drfinder.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drfinder.R;
import com.example.drfinder.adapter.AppointmentListRecyclerview;
import com.example.drfinder.adapter.CommentListRecyclerview;
import com.example.drfinder.databinding.FragmentAppointmentListBinding;
import com.example.drfinder.databinding.FragmentCommentForDoctorBinding;
import com.example.drfinder.model.Appointment;
import com.example.drfinder.viewmodel.ProfileViewModel;

import java.util.ArrayList;
import java.util.List;

public class CommentForDoctorFragment extends Fragment {
    FragmentCommentForDoctorBinding binding;
    CommentListRecyclerview commentListRecyclerview = new CommentListRecyclerview();
    ProfileViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_comment_for_doctor, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        viewModel.getAppointmentList().observe(getViewLifecycleOwner(), new Observer<List<Appointment>>() {
            @Override
            public void onChanged(List<Appointment> appointments) {
                commentListRecyclerview.setAppointmentArrayList((ArrayList<Appointment>) appointments);

                binding.commentRecyclerview.setAdapter(commentListRecyclerview);
                binding.commentRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
            }
        });
    }

}