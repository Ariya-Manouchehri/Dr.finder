package com.example.drfinder.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageSetter {
    @BindingAdapter("SetImage")
    public static void SetImage (ImageView imageView, int url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
