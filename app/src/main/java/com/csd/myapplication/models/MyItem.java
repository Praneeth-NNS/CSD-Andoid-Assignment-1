package com.csd.myapplication.models;

import com.csd.myapplication.R;

public class MyItem {

    int iconid = R.drawable.twitter;
    String title;
    String subTitle;

    public MyItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getIconid() {
        return iconid;
    }
}
