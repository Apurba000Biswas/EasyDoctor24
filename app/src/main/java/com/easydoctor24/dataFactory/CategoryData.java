package com.easydoctor24.dataFactory;

import com.easydoctor24.R;
import com.easydoctor24.data_model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryData {
    public static List<CategoryItem> getCategoryData(){
        CategoryData obj = new CategoryData();
        return obj.getData();
    }

    private List<CategoryItem> getData(){
        List<CategoryItem> dataList = new ArrayList<>();
        dataList.add(new CategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new CategoryItem(R.drawable.health_care, "Health Care", 2303));
        dataList.add(new CategoryItem(R.drawable.height, "Neurology", 704));
        dataList.add(new CategoryItem(R.drawable.medical_kit, "Dentist", 987));
        dataList.add(new CategoryItem(R.drawable.health_care, "Skin specialist", 578));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new CategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new CategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new CategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new CategoryItem(R.drawable.heart, "Heart", 1245));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));
        dataList.add(new CategoryItem(R.drawable.blood_drop, "Eye Specialist", 1539));


        return dataList;
    }
}
