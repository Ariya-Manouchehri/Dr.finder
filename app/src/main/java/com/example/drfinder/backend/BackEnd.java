package com.example.drfinder.backend;

import android.graphics.Color;

import com.example.drfinder.R;
import com.example.drfinder.model.Appointment;
import com.example.drfinder.model.Comment;
import com.example.drfinder.model.Doctor;
import com.example.drfinder.model.HomeViewPager;
import com.example.drfinder.model.JobSide;
import com.example.drfinder.model.OurDoctor;
import com.example.drfinder.model.Schedules;
import com.example.drfinder.model.WorkingHours;

import java.util.ArrayList;
import java.util.List;

public class BackEnd {
    private static BackEnd instance = null;
    ArrayList<Appointment> DoctorForUser = new ArrayList<>();


    public static synchronized BackEnd getInstance() {
        if (instance == null) {
            instance = new BackEnd();
        }
        return instance;
    }

    public int signInButtonPressed(String username, String password) {
        return SignInSIgnUp.SignIn(username, password);
    }

    public int signUpButtonPressed(String username, String password, String confirmPassword) {
        return SignInSIgnUp.SignUp(username, password, confirmPassword);
    }

    public ArrayList<Doctor> getPopularDoctor() {
        return Doctors.getInstance().getPopularDoctor();
    }

    public ArrayList<Doctor> getAllPopularDoctor() {
        return Doctors.getInstance().getAllPopularDoctor();
    }

    public Doctor getDoctor(int id) {
        return Doctors.getInstance().getDoctor(id);
    }

    public ArrayList<OurDoctor> getOurDoctor() {
        ArrayList<OurDoctor> ourDoctorArrayList = new ArrayList<>();
        ourDoctorArrayList.add(new OurDoctor("5 Doctors", "Medicine Specialist", R.drawable.drug1));
        ourDoctorArrayList.add(new OurDoctor("10 Doctors", "Dentist", R.drawable.drug2));
        ourDoctorArrayList.add(new OurDoctor("12 Doctors", "Gastroenterology", R.drawable.drug3));
        return ourDoctorArrayList;
    }

    public ArrayList<HomeViewPager> getHomeViewPager() {
        ArrayList<HomeViewPager> homeViewPagerArrayList = new ArrayList<>();
        homeViewPagerArrayList.add(new HomeViewPager(R.drawable.doctor6, Color.parseColor("#FFE780"), "welcome to Dr.finder", "you can find your doctor from this application"));
        homeViewPagerArrayList.add(new HomeViewPager(R.drawable.doctor11, Color.parseColor("#FFBAD3"), "Get The Best Medical Service", "Lorem Ipsum is Simply dummy text of the printing"));
        homeViewPagerArrayList.add(new HomeViewPager(R.drawable.doctor8, Color.parseColor("#AAFFAE"), "welcome to Dr.finder", "you can find your doctor from this application"));
        return homeViewPagerArrayList;
    }

    public ArrayList<Doctor> getDoctorByCategory(String job_side) {
       return Doctors.getInstance().getDoctorByCategory(job_side);
    }

    public ArrayList<Doctor> getFilterDoctor(String job_side) {
       return Doctors.getInstance().getFilterDoctor(job_side);
    }

    public ArrayList<WorkingHours> getDoctorWorkingHours() {
        return DoctorSchedule.getInstance().getDoctorWorkingHours();
    }

    public ArrayList<Schedules> getDoctorSchedule() {
        return DoctorSchedule.getInstance().getDoctorSchedule();
    }

    public ArrayList<JobSide> getFilterItem() {
        ArrayList<JobSide> jobSideArrayList = new ArrayList<>();
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_select, "All"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect, "Dentist"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect, "physiotherapy"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect, "Neurosurgery"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect, "Gastroenterology"));
        jobSideArrayList.add(new JobSide(R.drawable.bg_filter_noselect, "Ophthalmology"));
        return jobSideArrayList;
    }

    public ArrayList<Doctor> getAllDoctor() {
        return Doctors.getInstance().getAllDoctor();
    }

    public Integer setDoctorForUser(Appointment appointment) {
        DoctorForUser.add(appointment);
        return 1;
    }

    public List<Appointment> getAppointmentList() {
        return DoctorForUser;
    }

    public Integer setCommentForDoctor(int doctorId ,String comment , String username,float rating) {
        return ListOfComment.getInstance().addCommentForDoctor(new Comment(doctorId , comment,username,rating));
    }
    public List<Comment> getDoctorComment(int id) {
        return ListOfComment.getInstance().getDoctorComment(id);
    }
}
