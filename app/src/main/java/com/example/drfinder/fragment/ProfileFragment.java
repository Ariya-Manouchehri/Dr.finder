package com.example.drfinder.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drfinder.R;
import com.example.drfinder.adapter.PopularDoctorRecyclerview;
import com.example.drfinder.databinding.FragmentProfileBinding;
import com.example.drfinder.model.Doctor;
import com.example.drfinder.viewmodel.HomeViewModel;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;

    HomeViewModel viewModel;
    PopularDoctorRecyclerview popularDoctorAdapter = new PopularDoctorRecyclerview();
    ArrayList<Doctor> popularDoctorArrayList = new ArrayList<>();

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        ProfileFragmentEventListener listener = new ProfileFragmentEventListener();
        binding.setListener(listener);

        viewModel.getPopularDoctor().observe(getViewLifecycleOwner(), popularDoctors -> {
            popularDoctorArrayList = (ArrayList<Doctor>) popularDoctors;
            popularDoctorAdapter.setPopularDoctorArrayList(popularDoctorArrayList);
            binding.profileRecyclerView.setAdapter(popularDoctorAdapter);
            binding.profileRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        });
    }

    public class ProfileFragmentEventListener{
        public void appointmentBtn(View view){
            Navigation.findNavController(view).navigate(ProfileFragmentDirections.actionProfileFragmentToAppointmentListFragment());
        }
        public void commentsForDoctorBtn(View view){
            Navigation.findNavController(view).navigate(ProfileFragmentDirections.actionProfileFragmentToCommentForDoctorFragment(getArguments().getString("username")));
        }
    }
}