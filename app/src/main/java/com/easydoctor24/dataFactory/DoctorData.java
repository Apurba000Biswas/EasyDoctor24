package com.easydoctor24.dataFactory;

import com.easydoctor24.R;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.data_model.DoctorCategoryItem;

import java.util.ArrayList;
import java.util.List;

public class DoctorData {
    public static List<DoctorCategoryItem> getDoctorCategoryData(){
        DoctorData obj = new DoctorData();
        return obj.getCategoryData();
    }


    private List<DoctorCategoryItem> getCategoryData(){
        List<DoctorCategoryItem> dataList = new ArrayList<>();
        dataList.add(new DoctorCategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new DoctorCategoryItem(R.drawable.health_care, "Health Care", 2303));
        dataList.add(new DoctorCategoryItem(R.drawable.height, "Neurology", 704));
        dataList.add(new DoctorCategoryItem(R.drawable.medical_kit, "Dentist", 987));
        dataList.add(new DoctorCategoryItem(R.drawable.health_care, "Skin specialist", 578));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new DoctorCategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new DoctorCategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new DoctorCategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new DoctorCategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new DoctorCategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));


        return dataList;
    }

    public static final List<Doctor> getDoctorList(String category){
        DoctorData obj = new DoctorData();
        return obj.getDoctors();
    }

    private List<Doctor> getDoctors(){
        List<Doctor> dataList = new ArrayList<>();
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));
        dataList.add(new Doctor("Kathrine alexa", "Neurologist", "10.30 Am - 5.30 Pm", 500));

        return dataList;
    }
}
