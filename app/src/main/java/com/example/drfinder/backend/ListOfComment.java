package com.example.drfinder.backend;

import com.example.drfinder.model.Comment;
import com.example.drfinder.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListOfComment {
    private static ListOfComment instance = null;
    ArrayList<Comment> commentArrayList = new ArrayList<>();

    public static synchronized ListOfComment getInstance() {
        if (instance == null) {
            instance = new ListOfComment();
        }
        return instance;
    }

    public ListOfComment() {
        commentArrayList.add(new Comment(0, "ایشون دکتر خوبی هستند من دو ساله که تحت درمان هستم و شکر خدا رو به بهبودی هستم...", "mobina", 5f));
        commentArrayList.add(new Comment(0, "متاسفانه یکم سر نوبت دهی ازیت میکنند وگرنا دکتر بسیار خوبی هستند و تشخیصاشون عالیه بخاطر سرطان مادرم الان 3 سالی میشه که مرتبا پیش این پزشک مراجعه میکنم و در کل از کارشون راضی هستم", "ashkan", 3f));
        commentArrayList.add(new Comment(0, "ایشون اصلا دکتر خوبی نیستن و بسیار بسیار ادم پرخاش گر مغرور و از خود راضی هستند مراجعه به این پزشک رو اصلا توصیه نمیکنم :(", "sara", 0.5f));
    }

    public int addCommentForDoctor(Comment comment) {
        commentArrayList.add(comment);
        return 1;
    }

    public List<Comment> getDoctorComment(int id) {
        ArrayList<Comment> commentList = new ArrayList<>();
        for (Comment item : commentArrayList) {
            if (item.getDoctorId() == 0 || item.getDoctorId() == id) {
                commentList.add(item);
            }
        }
        return commentList;
    }
}
