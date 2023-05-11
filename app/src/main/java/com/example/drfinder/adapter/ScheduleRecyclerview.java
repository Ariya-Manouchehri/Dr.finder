package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ItemScedulesBinding;
import com.example.drfinder.databinding.ItemWorkingHoursBinding;
import com.example.drfinder.model.Schedules;
import com.example.drfinder.model.WorkingHours;

import java.util.ArrayList;

public class ScheduleRecyclerview extends RecyclerView.Adapter<ScheduleRecyclerview.Holder> {
    ArrayList<Schedules> schedulesArrayList = new ArrayList<>();
    ScheduleRecyclerview.setOnClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemScedulesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_scedules, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setModel(schedulesArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return schedulesArrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ItemScedulesBinding binding;

        public Holder(@NonNull ItemScedulesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.ViewSchedules.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && RecyclerView.NO_POSITION != getAdapterPosition()) {
                        listener.setOnCLickListener(schedulesArrayList.get(getAdapterPosition()).getSchedule());
                    }
                }
            });
        }
    }

    public interface setOnClickListener {
        void setOnCLickListener(String schedule);
    }

    public void setWorkingHoursArrayList( ArrayList<Schedules> schedulesArrayList) {
        this.schedulesArrayList = schedulesArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemCLickListener(ScheduleRecyclerview.setOnClickListener listener) {
        this.listener = listener;
    }
}
