package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ItemAppointmentListBinding;
import com.example.drfinder.databinding.ItemDoctorListRecyclerviewBinding;
import com.example.drfinder.model.Appointment;
import com.example.drfinder.model.PopularDoctor;

import java.util.ArrayList;

public class AppointmentListRecyclerview extends RecyclerView.Adapter<AppointmentListRecyclerview.Holder> {
    ArrayList<Appointment> appointmentArrayList = new ArrayList<>();
    AppointmentListRecyclerview.setOnClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAppointmentListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_appointment_list, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setModel(appointmentArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return appointmentArrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ItemAppointmentListBinding binding;

        public Holder(@NonNull ItemAppointmentListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface setOnClickListener {
        void setOnCLickListener(int id);
    }

    public void setAppointmentArrayList(ArrayList<Appointment> appointmentArrayList) {
        this.appointmentArrayList = appointmentArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemCLickListener(AppointmentListRecyclerview.setOnClickListener listener) {
        this.listener = listener;
    }
}
