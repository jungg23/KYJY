package com.example.kyjy;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable image;
    private String name;
    private String cycle;
    private String when;
    private String times;
    private String time;

    public void setImage(Drawable image) {
        this.image = image;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public Drawable getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public String getCycle() {
        return this.cycle;
    }

    public String getWhen() {
        return this.when;
    }

    public String getTimes() {
        return this.times;
    }

    public String getTime() {
        return this.time;
    }
}
