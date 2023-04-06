package com.example.drfinder.model;

public class PopularDoctor {
    private int id, card_background_doctor, img_doctor;
    private String name_doctor, job_doctor;
    private float rating;

    public PopularDoctor(int id, int card_background_doctor, int img_doctor, String name_doctor, String job_doctor, float rating) {
        this.id = id;
        this.card_background_doctor = card_background_doctor;
        this.img_doctor = img_doctor;
        this.name_doctor = name_doctor;
        this.job_doctor = job_doctor;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCard_background_doctor() {
        return card_background_doctor;
    }

    public void setCard_background_doctor(int card_background_doctor) {
        this.card_background_doctor = card_background_doctor;
    }

    public int getImg_doctor() {
        return img_doctor;
    }

    public void setImg_doctor(int img_doctor) {
        this.img_doctor = img_doctor;
    }

    public String getName_doctor() {
        return name_doctor;
    }

    public void setName_doctor(String name_doctor) {
        this.name_doctor = name_doctor;
    }

    public String getJob_doctor() {
        return job_doctor;
    }

    public void setJob_doctor(String job_doctor) {
        this.job_doctor = job_doctor;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
