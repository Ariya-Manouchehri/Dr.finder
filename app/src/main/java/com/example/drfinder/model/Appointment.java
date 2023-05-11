package com.example.drfinder.model;

public class Appointment {
    String schedule;
    String hours;
    Doctor doctor;

    public Appointment(String schedule, String hours, Doctor doctor) {
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
