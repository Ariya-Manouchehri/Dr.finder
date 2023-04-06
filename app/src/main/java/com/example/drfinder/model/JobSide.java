package com.example.drfinder.model;

public class JobSide {
    int background;
    String jobSideName;

    public JobSide(int background, String jobSideName) {
        this.background = background;
        this.jobSideName = jobSideName;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getJobSideName() {
        return jobSideName;
    }

    public void setJobSideName(String jobSideName) {
        this.jobSideName = jobSideName;
    }
}
