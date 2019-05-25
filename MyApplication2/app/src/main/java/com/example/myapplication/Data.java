package com.example.myapplication;

public class Data {

    private int image;
    private String name;
    private String cycle;
    private String when;
    private String times;
    private String time;


    public Data(int image, String name, String cycle, String when, String times, String time){
        this.image = image;
        this.name = name;
        this.cycle = cycle;
        this.when = when;
        this.times = times;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getCycle() {
        return cycle;
    }

    public String getWhen() {
        return when;
    }

    public String getTimes() {
        return times;
    }

    public String getTime() {
        return time;
    }

}
