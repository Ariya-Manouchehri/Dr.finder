package com.example.drfinder.model;

public class HomeViewPager {
    int img,background_color;
    String title,text;

    public HomeViewPager(int img,int background_color, String title, String text) {
        this.img = img;
        this.background_color = background_color;
        this.title = title;
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getBackground_color() {
        return background_color;
    }

    public void setBackground_color(int background_color) {
        this.background_color = background_color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
