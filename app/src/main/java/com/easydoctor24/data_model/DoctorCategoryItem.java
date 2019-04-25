package com.easydoctor24.data_model;

public class DoctorCategoryItem {
    private int imgId;
    private String name;
    private int totalDoctor;

    public DoctorCategoryItem(int imgId, String name, int totalDoctor){
        this.imgId = imgId;
        this.name = name;
        this.totalDoctor = totalDoctor;
    }

    public DoctorCategoryItem(int imgId, String name){
        this.imgId = imgId;
        this.name = name;
        totalDoctor = 0;
    }

    public int getImgId(){
        return imgId;
    }
    public String getName(){
        return name;
    }
    public int getTotalDoctor(){
        return totalDoctor;
    }

    @Override
    public String toString(){
        return "Name : " + name + " Total doctor : " + totalDoctor + " Img id : " + imgId;
    }
}
