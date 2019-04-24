package com.easydoctor24.data_model;

public class CategoryItem {
    private int imgId;
    private String name;
    private int totalDoctor;

    public CategoryItem(int imgId, String name, int totalDoctor){
        this.imgId = imgId;
        this.name = name;
        this.totalDoctor = totalDoctor;
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
