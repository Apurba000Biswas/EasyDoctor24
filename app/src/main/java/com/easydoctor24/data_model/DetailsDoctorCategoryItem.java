package com.easydoctor24.data_model;

import java.util.List;

public class DetailsDoctorCategoryItem extends DoctorCategoryItem{

    private List<Doctor> doctorList;
    public DetailsDoctorCategoryItem(int imgId, String name, List<Doctor> doctors) {
        super(imgId, name);
        doctorList = doctors;
    }

    public List<Doctor> getDoctorList(){
        return doctorList;
    }

}
