package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ItemJobSideBinding;
import com.example.drfinder.model.JobSide;

import java.util.ArrayList;

public class JobSideRecyclerview extends RecyclerView.Adapter<JobSideRecyclerview.Holder> {
    ArrayList<JobSide> jobSideArrayList = new ArrayList<>();
    JobSideRecyclerview.setOnClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemJobSideBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_job_side, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setModel(jobSideArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return jobSideArrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ItemJobSideBinding binding;

        public Holder(@NonNull ItemJobSideBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && RecyclerView.NO_POSITION != getAdapterPosition()) {
                        listener.setOnCLickListener(jobSideArrayList.get(getAdapterPosition()).getJobSideName());
                        if(jobSideArrayList.get(getAdapterPosition()).getBackground() == R.drawable.bg_filter_noselect){
                            binding.button.setBackgroundResource(R.drawable.bg_filter_select);
                            jobSideArrayList.get(getAdapterPosition()).setBackground(R.drawable.bg_filter_select);
                        }else if (jobSideArrayList.get(getAdapterPosition()).getBackground() == R.drawable.bg_filter_select){
                            binding.button.setBackgroundResource(R.drawable.bg_filter_noselect);
                            jobSideArrayList.get(getAdapterPosition()).setBackground(R.drawable.bg_filter_noselect);
                        }
                    }
                }
            });
        }
    }

    public interface setOnClickListener {
        void setOnCLickListener(String jobSide);
    }

    public void setJobSideListArrayList(ArrayList<JobSide> jobSideArrayList) {
        this.jobSideArrayList = jobSideArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemCLickListener(JobSideRecyclerview.setOnClickListener listener) {
        this.listener = listener;
    }
}
