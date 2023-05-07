package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ItemSearchByDoctorNameBinding;
import com.example.drfinder.model.PopularDoctor;

import java.util.ArrayList;

public class SearchByDoctorRecyclerview extends RecyclerView.Adapter<SearchByDoctorRecyclerview.Holder> {
    ArrayList<PopularDoctor> popularDoctorArrayList = new ArrayList<>();
    SearchByDoctorRecyclerview.setOnClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSearchByDoctorNameBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_search_by_doctor_name, parent, false);
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
        ItemSearchByDoctorNameBinding binding;

        public Holder(@NonNull ItemSearchByDoctorNameBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.searchDoctor.setOnClickListener(new View.OnClickListener() {
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

    public void setOnItemCLickListener(SearchByDoctorRecyclerview.setOnClickListener listener) {
        this.listener = listener;
    }
}
