package com.example.drfinder.backend;

import android.graphics.Color;
import android.util.Log;

import com.example.drfinder.R;
import com.example.drfinder.model.HomeViewPager;
import com.example.drfinder.model.JobSide;
import com.example.drfinder.model.OurDoctor;
import com.example.drfinder.model.PopularDoctor;
import com.example.drfinder.model.Schedules;
import com.example.drfinder.model.WorkingHours;

import java.util.ArrayList;

public class BackEnd {
    private static BackEnd instance = null;
    ArrayList<PopularDoctor> popularDoctorArrayList = new ArrayList<>();
    ArrayList<WorkingHours> workingHoursArrayList = new ArrayList<>();
    ArrayList<Schedules> schedulesArrayList = new ArrayList<>();


    public static synchronized BackEnd getInstance() {
        if (instance == null) {
            instance = new BackEnd();
        }
        return instance;
    }

    public BackEnd() {
        popularDoctorArrayList.add(new PopularDoctor(1, Color.parseColor("#FEF5EB"), R.drawable.doctor1, "Dr.Sanaz Frozanfar", "Neurosurgery", 4.8f));
        popularDoctorArrayList.add(new PopularDoctor(2, Color.parseColor("#FEF5EB"), R.drawable.doctor2, "Dr.Ahmad Ahmadian", "Gastroenterology", 3.8f));
        popularDoctorArrayList.add(new PopularDoctor(3, Color.parseColor("#FEF5EB"), R.drawable.doctor3, "Dr.Mahdi Moghadam", "Gastroenterology", 5.8f));
        popularDoctorArrayList.add(new PopularDoctor(4, Color.parseColor("#FEF5EB"), R.drawable.doctor4, "Dr.Saba Nazari", "physiotherapy", 9.8f));
        popularDoctorArrayList.add(new PopularDoctor(5, Color.parseColor("#EFEFFB"), R.drawable.doctor5, "Dr.Mohammad Fazli", "Cardiology", 9.5f));
        popularDoctorArrayList.add(new PopularDoctor(6, Color.parseColor("#FEF5EB"), R.drawable.doctor6, "Dr.Mostafa Rezaei", "Dentist", 8.7f));
        popularDoctorArrayList.add(new PopularDoctor(7, Color.parseColor("#EFEFFB"), R.drawable.doctor7, "Dr.Ariya Manouchehri", "Dentist", 8.2f));
        popularDoctorArrayList.add(new PopularDoctor(8, Color.parseColor("#FEF5EB"), R.drawable.doctor8, "Dr.Javad javadi", "Ophthalmology", 7.5f));
        popularDoctorArrayList.add(new PopularDoctor(9, Color.parseColor("#FEF5EB"), R.drawable.doctor9, "Dr.Shamim Tabatabayian", "Dentist", 7.2f));
        popularDoctorArrayList.add(new PopularDoctor(10, Color.parseColor("#EFEFFB"), R.drawable.doctor10, "Dr.Reza Mohammadi", "Neurosurgery", 7.2f));
        popularDoctorArrayList.add(new PopularDoctor(11, Color.parseColor("#FEF5EB"), R.drawable.doctor11, "Dr.Sara Ashkani", "Midwifery", 7f));
        popularDoctorArrayList.add(new PopularDoctor(12, Color.parseColor("#EFEFFB"), R.drawable.doctor12, "Dr.Maryam Shahbazi", "Ophthalmology", 6.8f));
        popularDoctorArrayList.add(new PopularDoctor(13, Color.parseColor("#FEF5EB"), R.drawable.doctor13, "Dr.Masome Heydari", "Radiologie", 6.5f));
        popularDoctorArrayList.add(new PopularDoctor(14, Color.parseColor("#FEF5EB"), R.drawable.doctor14, "Dr.Komail Moghadasi", "physiotherapy", 6.5f));
        popularDoctorArrayList.add(new PopularDoctor(15, Color.parseColor("#FEF5EB"), R.drawable.doctor15, "Dr.Sara Bahrami", "physiotherapy", 4.3f));
        for (int i = 7; i < 13; i++) {
            workingHoursArrayList.add(new WorkingHours(i+":00"+" AM"));
        }
        for (int i = 17; i < 23; i++) {
            workingHoursArrayList.add(new WorkingHours(i+":00"+" PM"));
        }
        for (int i = 0; i < 7; i++) {
            switch (i){
                case 0:
                    schedulesArrayList.add(new Schedules("Sat\n" +(i+10)));
                    break;
                case 1:
                    schedulesArrayList.add(new Schedules("Sun\n" +(i+10)));
                    break;
                case 2:
                    schedulesArrayList.add(new Schedules("Mon\n" +(i+10)));
                    break;
                case 3:
                    schedulesArrayList.add(new Schedules("Tue\n" +(i+10)));
                    break;
                case 4:
                    schedulesArrayList.add(new Schedules("Wed\n" +(i+10)));
                    break;
                case 5:
                    schedulesArrayList.add(new Schedules("Thu\n" +(i+10)));
                    break;
                case 6:
                    schedulesArrayList.add(new Schedules("Fri\n" +(i+10)));
                    break;
            }
        }
    }

    public int signInButtonPressed(String username, String password) {
        if (username.isEmpty() || username.contains(".") || username.contains("&") || username.contains("@") || username.contains(" ")) {
            return -1;
        }
        if (password.isEmpty() || password.contains(".") || password.contains("&") || password.contains("@") || password.contains(" ")) {
            return 0;
        }
        return 1;
    }

    public int signUpButtonPressed(String username, String password, String confirmPassword) {
        if (username.isEmpty() || username.contains(".") || username.contains("&") || username.contains("@") || username.contains(" ")) {
            return -1;
        }
        if (password.isEmpty() || password.contains(".") || password.contains("&") || password.contains("@") || password.contains(" ")) {
            return 0;
        }
        if (!password.equals(confirmPassword)) {
            return -2;
        }
        return 1;
    }

    public ArrayList<PopularDoctor> getPopularDoctor() {
        ArrayList<PopularDoctor> popularDoctorList = new ArrayList<>();

        for (PopularDoctor item : popularDoctorArrayList) {
            if (item.getRating() >= 7.5) {
                popularDoctorList.add(item);
            }
        }
        return popularDoctorList;
    }

    public ArrayList<PopularDoctor> getAllPopularDoctor() {
        ArrayList<PopularDoctor> popularDoctorList = new ArrayList<>();

        for (PopularDoctor item : popularDoctorArrayList) {
            if (item.getRating() >= 5) {
                popularDoctorList.add(item);
            }
        }
        return popularDoctorList;
    }

    public PopularDoctor getDoctor(int id) {
        for (PopularDoctor item : popularDoctorArrayList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<WorkingHours> getDoctorWorkingHours() {
        return workingHoursArrayList;
    }

    public ArrayList<OurDoctor> getOurDoctor() {
        ArrayList<OurDoctor> ourDoctorArrayList = new ArrayList<>();
        ourDoctorArrayList.add(new OurDoctor("35 Doctors", "Medicine Specialist", R.drawable.drug1));
        ourDoctorArrayList.add(new OurDoctor("20 Doctors", "Dentist", R.drawable.drug2));
        ourDoctorArrayList.add(new OurDoctor("25 Doctors", "Cardiologist", R.drawable.drug3));
        return ourDoctorArrayList;
    }

    public ArrayList<HomeViewPager> getHomeViewPager() {
        ArrayList<HomeViewPager> homeViewPagerArrayList = new ArrayList<>();
        homeViewPagerArrayList.add(new HomeViewPager(R.drawable.doctor6, Color.parseColor("#FFE780"), "welcome to Dr.finder", "you can find your doctor from this application"));
        homeViewPagerArrayList.add(new HomeViewPager(R.drawable.doctor7, Color.parseColor("#FFBAD3"), "Get The Best Medical Service", "Lorem Ipsum is Simply dummy text of the printing"));
        homeViewPagerArrayList.add(new HomeViewPager(R.drawable.doctor8, Color.parseColor("#AAFFAE"), "welcome to Dr.finder", "you can find your doctor from this application"));
        return homeViewPagerArrayList;
    }

    public ArrayList<PopularDoctor> getDoctorByCategory(String job_side) {
        ArrayList<PopularDoctor> popularDoctorList = new ArrayList<>();

        for (PopularDoctor item : popularDoctorArrayList) {
            if (item.getJob_doctor().equals(job_side)) {
                popularDoctorList.add(item);
            }
        }
        return popularDoctorList;
    }

    public ArrayList<PopularDoctor> getFilterDoctor(String job_side) {
        ArrayList<PopularDoctor> popularDoctorList = new ArrayList<>();
        if (job_side.equals("All")) {
            return popularDoctorArrayList;
        } else {
            for (PopularDoctor item : popularDoctorArrayList) {
                if (item.getJob_doctor().equals(job_side)) {
                    popularDoctorList.add(item);
                }
            }
            return popularDoctorList;
        }
    }

    public ArrayList<Schedules> getDoctorSchedule() {
        return schedulesArrayList;
    }

    public ArrayList<JobSide> getFilterItem() {
        ArrayList<JobSide> jobSideArrayList = new ArrayList<>();
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_select,"All"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect,"Dentist"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect,"physiotherapy"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect,"Neurosurgery"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect,"Gastroenterology"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect,"Ophthalmology"));
        return jobSideArrayList;
    }

    public ArrayList<PopularDoctor> getAllDoctor() {
        return popularDoctorArrayList;
    }
}
