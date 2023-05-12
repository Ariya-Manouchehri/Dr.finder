package com.example.drfinder.backend;

import android.graphics.Color;

import com.example.drfinder.R;
import com.example.drfinder.model.Doctor;

import java.util.ArrayList;

public class Doctors {
    private static Doctors instance = null;
    ArrayList<Doctor> doctorArrayList = new ArrayList<>();

    public static synchronized Doctors getInstance(){
        if (instance == null){
            instance = new Doctors();
        }
        return instance;
    }
    public Doctors(){
        doctorArrayList.add(new Doctor(1, Color.parseColor("#FEF5EB"), R.drawable.doctor1, "Dr.Sanaz Frozanfar", "Neurosurgery", 4.8f));
        doctorArrayList.add(new Doctor(2, Color.parseColor("#EFEFFB"), R.drawable.doctor2, "Dr.Ahmad Ahmadian", "Gastroenterology", 3.8f));
        doctorArrayList.add(new Doctor(3, Color.parseColor("#FEF5EB"), R.drawable.doctor3, "Dr.Mahdi Moghadam", "Gastroenterology", 5.8f));
        doctorArrayList.add(new Doctor(4, Color.parseColor("#EFEFFB"), R.drawable.doctor4, "Dr.Saba Nazari", "physiotherapy", 6.8f));
        doctorArrayList.add(new Doctor(5, Color.parseColor("#FEF5EB"), R.drawable.doctor5, "Dr.Mohammad Fazli", "Cardiology", 5.5f));
        doctorArrayList.add(new Doctor(6, Color.parseColor("#EFEFFB"), R.drawable.doctor6, "Dr.Mostafa Rezaei", "Dentist", 7.1f));
        doctorArrayList.add(new Doctor(7, Color.parseColor("#FEF5EB"), R.drawable.doctor7, "Dr.Ariya Manouchehri", "Dentist", 6.2f));
        doctorArrayList.add(new Doctor(8, Color.parseColor("#EFEFFB"), R.drawable.doctor8, "Dr.Javad javadi", "Ophthalmology", 7.5f));
        doctorArrayList.add(new Doctor(9, Color.parseColor("#FEF5EB"), R.drawable.doctor9, "Dr.Shamim tabatabayian", "Dentist", 8.5f));
        doctorArrayList.add(new Doctor(10, Color.parseColor("#EFEFFB"), R.drawable.doctor10, "Dr.Reza Mohammadi", "Neurosurgery", 7.5f));
        doctorArrayList.add(new Doctor(11, Color.parseColor("#FEF5EB"), R.drawable.doctor11, "Dr.Sara Ashkani", "Midwifery", 7.8f));
        doctorArrayList.add(new Doctor(12, Color.parseColor("#EFEFFB"), R.drawable.doctor12, "Dr.Maryam Shahbazi", "Ophthalmology", 7.8f));
        doctorArrayList.add(new Doctor(13, Color.parseColor("#FEF5EB"), R.drawable.doctor13, "Dr.Masome Heydari", "Radiologie", 7.6f));
        doctorArrayList.add(new Doctor(14, Color.parseColor("#EFEFFB"), R.drawable.doctor14, "Dr.Komail Moghadasi", "physiotherapy", 6.5f));
        doctorArrayList.add(new Doctor(15, Color.parseColor("#FEF5EB"), R.drawable.doctor15, "Dr.Sara Bahrami", "physiotherapy", 4.3f));
        doctorArrayList.add(new Doctor(16, Color.parseColor("#EFEFFB"), R.drawable.doctor16, "Dr.Reza Asadipour", "Neurosurgery", 4f));
    }

    public ArrayList<Doctor> getPopularDoctor() {
        ArrayList<Doctor> popularDoctorList = new ArrayList<>();
        for (Doctor item : doctorArrayList) {
            if (item.getRating() >= 7.5) {
                popularDoctorList.add(item);
            }
        }
        return popularDoctorList;
    }

    public ArrayList<Doctor> getAllPopularDoctor() {
        ArrayList<Doctor> popularDoctorList = new ArrayList<>();

        for (Doctor item : doctorArrayList) {
            if (item.getRating() >= 5) {
                popularDoctorList.add(item);
            }
        }
        return popularDoctorList;
    }

    public Doctor getDoctor(int id) {
        for (Doctor item : doctorArrayList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public ArrayList<Doctor> getFilterDoctor(String job_side) {
        ArrayList<Doctor> popularDoctorList = new ArrayList<>();
        if (job_side.equals("All")) {
            return doctorArrayList;
        } else {
            for (Doctor item : doctorArrayList) {
                if (item.getJob_doctor().equals(job_side)) {
                    popularDoctorList.add(item);
                }
            }
            return popularDoctorList;
        }
    }

    public ArrayList<Doctor> getDoctorByCategory(String job_side) {
        ArrayList<Doctor> popularDoctorList = new ArrayList<>();

        for (Doctor item : doctorArrayList) {
            if (item.getJob_doctor().equals(job_side)) {
                popularDoctorList.add(item);
            }
        }
        return popularDoctorList;
    }

    public ArrayList<Doctor> getAllDoctor() {
        return doctorArrayList;
    }
}
