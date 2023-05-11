package com.example.drfinder.backend;

import com.example.drfinder.model.Schedules;
import com.example.drfinder.model.WorkingHours;

import java.util.ArrayList;
import java.util.Random;

public class DoctorSchedule {
    private static DoctorSchedule instance = null;
    ArrayList<WorkingHours> workingHoursArrayList = new ArrayList<>();
    ArrayList<Schedules> schedulesArrayList = new ArrayList<>();

    public static synchronized DoctorSchedule getInstance() {
        if (instance == null) {
            instance = new DoctorSchedule();
        }
        return instance;
    }

    public ArrayList<WorkingHours> getDoctorWorkingHours() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10); i++) {
            workingHoursArrayList.add(new WorkingHours((random.nextInt(13-7) + 7) + ":00" + " AM"));
        }
        for (int i = 0; i < random.nextInt(10); i++) {
            workingHoursArrayList.add(new WorkingHours((random.nextInt(23-17) + 17) + ":00" + " PM"));
        }
        return workingHoursArrayList;
    }

    public ArrayList<Schedules> getDoctorSchedule() {
        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    schedulesArrayList.add(new Schedules("Sat\n" + (i + 10)));
                    break;
                case 1:
                    schedulesArrayList.add(new Schedules("Sun\n" + (i + 10)));
                    break;
                case 2:
                    schedulesArrayList.add(new Schedules("Mon\n" + (i + 10)));
                    break;
                case 3:
                    schedulesArrayList.add(new Schedules("Tue\n" + (i + 10)));
                    break;
                case 4:
                    schedulesArrayList.add(new Schedules("Wed\n" + (i + 10)));
                    break;
                case 5:
                    schedulesArrayList.add(new Schedules("Thu\n" + (i + 10)));
                    break;
                case 6:
                    schedulesArrayList.add(new Schedules("Fri\n" + (i + 10)));
                    break;
            }
        }
        return schedulesArrayList;
    }
}
