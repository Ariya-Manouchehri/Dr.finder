package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ItemDoctorListRecyclerviewBinding;
import com.example.drfinder.databinding.ItemPopulardoctorRecyclerviewBinding;
import com.example.drfinder.model.PopularDoctor;

import java.util.ArrayList;

public class DoctorListRecyclerview extends RecyclerView.Adapter<DoctorListRecyclerview.Holder> {
    ArrayList<PopularDoctor> popularDoctorArrayList = new ArrayList<>();
    DoctorListRecyclerview.setOnClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDoctorListRecyclerviewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_doctor_list_recyclerview, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setModel(popularDoctorArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return popularDoctorArrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ItemDoctorListRecyclerviewBinding binding;

        public Holder(@NonNull ItemDoctorListRecyclerviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.cardBackgroundDoctor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && RecyclerView.NO_POSITION != getAdapterPosition()) {
                        listener.setOnCLickListener(popularDoctorArrayList.get(getAdapterPosition()).getId());
                    }
                }
            });
        }
    }

    public interface setOnClickListener {
        void setOnCLickListener(int id);
    }

    public void setDoctorListArrayList(ArrayList<PopularDoctor> popularDoctorArrayList) {
        this.popularDoctorArrayList = popularDoctorArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemCLickListener(DoctorListRecyclerview.setOnClickListener listener) {
        this.listener = listener;
    }
}
