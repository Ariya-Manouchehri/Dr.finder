package com.example.drfinder.model;

public class Appointment {
    String schedule;
    String hours;
    PopularDoctor doctor;

    public Appointment(String schedule, String hours, PopularDoctor doctor) {
        this.schedule = schedule;
        this.hours = hours;
        this.doctor = doctor;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public PopularDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(PopularDoctor doctor) {
        this.doctor = doctor;
    }
}
