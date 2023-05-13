package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ItemCommentListBinding;
import com.example.drfinder.databinding.ItemCommentListForDoctorBinding;
import com.example.drfinder.model.Appointment;
import com.example.drfinder.model.Comment;

import java.util.ArrayList;

public class CommentListForDoctorRecyclerview extends RecyclerView.Adapter<CommentListForDoctorRecyclerview.Holder> {
    ArrayList<Comment> commentArrayList = new ArrayList<>();
    CommentListForDoctorRecyclerview.setOnClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCommentListForDoctorBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_comment_list_for_doctor, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setModel(commentArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ItemCommentListForDoctorBinding binding;

        public Holder(@NonNull ItemCommentListForDoctorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface setOnClickListener {
        void setOnCLickListener(int doctorId, String comment, float rating);
    }

    public void setCommentArrayList(ArrayList<Comment> commentArrayList) {
        this.commentArrayList = commentArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemCLickListener(CommentListForDoctorRecyclerview.setOnClickListener listener) {
        this.listener = listener;
    }
}
