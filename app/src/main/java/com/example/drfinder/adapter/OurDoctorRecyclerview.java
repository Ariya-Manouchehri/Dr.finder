package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ItemOurdoctorRecyclerviewBinding;
import com.example.drfinder.model.OurDoctor;

import java.util.ArrayList;

public class OurDoctorRecyclerview extends RecyclerView.Adapter<OurDoctorRecyclerview.Holder> {
    ArrayList<OurDoctor> ourDoctorArrayList = new ArrayList<>();
    OurDoctorRecyclerview.setOnItemCLickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOurdoctorRecyclerviewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_ourdoctor_recyclerview, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setModel(ourDoctorArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return ourDoctorArrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ItemOurdoctorRecyclerviewBinding binding;

        public Holder(@NonNull ItemOurdoctorRecyclerviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && RecyclerView.NO_POSITION != getAdapterPosition()) {
                        listener.setOnClickListener(ourDoctorArrayList.get(getAdapterPosition()).getJob_side());
                    }
                }
            });
        }
    }

    public void setOurDoctorArrayList(ArrayList<OurDoctor> ourDoctorArrayList) {
        this.ourDoctorArrayList = ourDoctorArrayList;
        notifyDataSetChanged();
    }

    public interface setOnItemCLickListener {
        void setOnClickListener(String category_name);
    }

    public void setOnCLickListener(OurDoctorRecyclerview.setOnItemCLickListener listener) {
        this.listener = listener;
    }
}
