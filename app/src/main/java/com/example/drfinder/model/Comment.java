package com.example.drfinder.model;

public class Comment {
    int doctorId;
    String comment;
    String username;
    float rating;

    public Comment(int doctorId, String comment, String username, float rating) {
        this.doctorId = doctorId;
        this.comment = comment;
        this.username = username;
        this.rating = rating;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
