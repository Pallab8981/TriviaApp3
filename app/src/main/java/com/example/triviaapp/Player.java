package com.example.triviaapp;
// creating class player to store objects
public class Player {

    private String date;
    private String name;
    private String cric;
    private String flag;

    public Player(String date, String name, String cric, String flag)
    {

        this.date=date;
        this.name=name;
        this.cric=cric;
        this.flag=flag;


    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCric() {
        return cric;
    }

    public void setCric(String cric) {
        this.cric = cric;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }



}
