package com.example.drfinder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ItemAppointmentListBinding;
import com.example.drfinder.databinding.ItemCommentListBinding;
import com.example.drfinder.model.Appointment;

import java.util.ArrayList;

public class CommentListRecyclerview extends RecyclerView.Adapter<CommentListRecyclerview.Holder> {
    ArrayList<Appointment> appointmentArrayList = new ArrayList<>();
    CommentListRecyclerview.setOnClickListener listener;
    Animation animationFadeIn;
    Animation animationFadeOut;


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        animationFadeIn = AnimationUtils.loadAnimation(parent.getContext(), R.anim.fade_in);
        animationFadeOut = AnimationUtils.loadAnimation(parent.getContext(), R.anim.fade_out);

        ItemCommentListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_comment_list, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setModel(appointmentArrayList.get(position));
        holder.binding.arrow.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
    }

    @Override
    public int getItemCount() {
        return appointmentArrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ItemCommentListBinding binding;

        public Holder(@NonNull ItemCommentListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (binding.textInputLayout.getVisibility() == View.GONE) {
                        binding.arrow.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);

                        binding.arrow.startAnimation(animationFadeIn);
                        binding.textInputLayout.startAnimation(animationFadeIn);
                        binding.submit.startAnimation(animationFadeIn);
                        binding.rating.startAnimation(animationFadeIn);

                        binding.textInputLayout.setVisibility(View.VISIBLE);
                        binding.submit.setVisibility(View.VISIBLE);
                        binding.rating.setVisibility(View.VISIBLE);

                    } else {
                        binding.arrow.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);

                        binding.arrow.startAnimation(animationFadeIn);
                        binding.textInputLayout.startAnimation(animationFadeOut);
                        binding.submit.startAnimation(animationFadeOut);
                        binding.rating.startAnimation(animationFadeOut);

                        binding.textInputLayout.setVisibility(View.GONE);
                        binding.submit.setVisibility(View.GONE);
                        binding.rating.setVisibility(View.GONE);
                    }
                }
            });
            binding.submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && RecyclerView.NO_POSITION != getAdapterPosition()) {
                        listener.setOnCLickListener(appointmentArrayList.get(getAdapterPosition()).getDoctor().getId(), binding.comment.getText().toString(), binding.rating.getRating());
                    }
                }
            });
        }
    }

    public interface setOnClickListener {
        void setOnCLickListener(int doctorId, String comment, float rating);
    }

    public void setAppointmentArrayList(ArrayList<Appointment> appointmentArrayList) {
        this.appointmentArrayList = appointmentArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemCLickListener(CommentListRecyclerview.setOnClickListener listener) {
        this.listener = listener;
    }
}
