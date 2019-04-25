package com.easydoctor24.data_model;

public class Doctor {

    private String name;
    private String designation;
    private String onlineTime;
    private int fees;
    public Doctor(String name, String designation, String onlineTime, int fees){
        this.name = name;
        this.designation = designation;
        this.onlineTime = onlineTime;
        this.fees = fees;
    }

    public String getName(){
        return name;
    }

    public String getDesignation(){
        return designation;
    }

    public String getOnlineTime(){
         return onlineTime;
    }

    public int getFees(){
        return fees;
    }

}
