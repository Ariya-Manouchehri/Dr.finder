package com.example.drfinder.model;

public class OurDoctor {
    private String number_of_doctors,job_side;
    private int img_drug;

    public OurDoctor(String number_of_doctors, String job_side, int img_drug) {
        this.number_of_doctors = number_of_doctors;
        this.job_side = job_side;
        this.img_drug = img_drug;
    }

    public String getNumber_of_doctors() {
        return number_of_doctors;
    }

    public void setNumber_of_doctors(String number_of_doctors) {
        this.number_of_doctors = number_of_doctors;
    }

    public String getJob_side() {
        return job_side;
    }

    public void setJob_side(String job_side) {
        this.job_side = job_side;
    }

    public int getImg_drug() {
        return img_drug;
    }

    public void setImg_drug(int img_drug) {
        this.img_drug = img_drug;
    }
}
