package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.HomeViewPagerBinding;
import com.example.drfinder.model.HomeViewPager;

import java.util.ArrayList;

public class HomeViewPagerAdapter extends RecyclerView.Adapter<HomeViewPagerAdapter.Holder> {
    ArrayList<HomeViewPager> homeViewPagerArrayList = new ArrayList<>();
    HomeViewPagerBinding binding;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.home_view_pager,parent,false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        binding.setModel(homeViewPagerArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return homeViewPagerArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        HomeViewPagerBinding binding;
        public Holder(@NonNull HomeViewPagerBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    public void setHomeViewPagerArrayList(ArrayList<HomeViewPager> homeViewPagerArrayList){
        this.homeViewPagerArrayList = homeViewPagerArrayList;
    }
}
