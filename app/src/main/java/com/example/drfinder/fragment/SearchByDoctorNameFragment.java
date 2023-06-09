package com.example.drfinder.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.drfinder.R;
import com.example.drfinder.activity.DoctorActivity;
import com.example.drfinder.adapter.SearchByDoctorRecyclerview;
import com.example.drfinder.databinding.FragmentSearchByDoctorNameBinding;
import com.example.drfinder.model.Doctor;
import com.example.drfinder.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchByDoctorNameFragment extends Fragment implements SearchByDoctorRecyclerview.setOnClickListener {
    FragmentSearchByDoctorNameBinding binding;
    SearchViewModel viewModel;
    SearchByDoctorRecyclerview searchByDoctorRecyclerview = new SearchByDoctorRecyclerview();
    ArrayList<Doctor> allDoctor = new ArrayList<>();
    ArrayList<Doctor> filterDoctor = new ArrayList<>();


    public SearchByDoctorNameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_by_doctor_name, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(SearchViewModel.class);

        viewModel.getAllDoctor().observe(getViewLifecycleOwner(), new Observer<List<Doctor>>() {
            @Override
            public void onChanged(List<Doctor> popularDoctors) {
                allDoctor = (ArrayList<Doctor>) popularDoctors;
                searchByDoctorRecyclerview.setDoctorListArrayList(allDoctor);
                binding.recyclerViewSearchByDoctorName.setAdapter(searchByDoctorRecyclerview);
                binding.recyclerViewSearchByDoctorName.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }
        });

        binding.searchDoctorsEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    filterDoctor.clear();
                    for (Doctor doctor : allDoctor) {
                        if (doctor.getName_doctor().toLowerCase().contains(s)) {
                            filterDoctor.add(doctor);
                        }
                    }
                    Log.i("TAG", "onTextChanged: " + filterDoctor.size());
                    searchByDoctorRecyclerview.setDoctorListArrayList(filterDoctor);
                } else {
                    searchByDoctorRecyclerview.setDoctorListArrayList(allDoctor);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        searchByDoctorRecyclerview.setOnItemCLickListener(this);
    }

    @Override
    public void setOnCLickListener(int id) {
        Intent intent = new Intent(getContext(), DoctorActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}