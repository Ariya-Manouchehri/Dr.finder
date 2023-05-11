package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.activity.AppointmentActivity;
import com.example.drfinder.databinding.ItemDoctorListRecyclerviewBinding;
import com.example.drfinder.databinding.ItemWorkingHoursBinding;
import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.model.WorkingHours;

import java.util.ArrayList;

public class WorkingHoursRecyclerview extends RecyclerView.Adapter<WorkingHoursRecyclerview.Holder> {
    ArrayList<WorkingHours> workingHoursArrayList = new ArrayList<>();
    WorkingHoursRecyclerview.setOnClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWorkingHoursBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_working_hours, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setModel(workingHoursArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return workingHoursArrayList.size();
    }


    class Holder extends RecyclerView.ViewHolder {
        ItemWorkingHoursBinding binding;

        public Holder(@NonNull ItemWorkingHoursBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.ViewWorkingHours.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && RecyclerView.NO_POSITION != getAdapterPosition()) {
                        listener.setOnCLickListener(workingHoursArrayList.get(getAdapterPosition()).getHours());
                    }
                }
            });
        }
    }

    public interface setOnClickListener {
        void setOnCLickListener(String hours);
    }

    public void setWorkingHoursArrayList( ArrayList<WorkingHours> workingHoursArrayList) {
        this.workingHoursArrayList = workingHoursArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemCLickListener(WorkingHoursRecyclerview.setOnClickListener listener) {
        this.listener = listener;
    }
}
