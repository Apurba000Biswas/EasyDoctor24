package com.easydoctor24.activities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.easydoctor24.dataFactory.DoctorData;
import com.easydoctor24.data_model.DoctorCategoryItem;

import java.util.List;


// Base Activity
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    protected static final String INTENT_EXTRA_CATEGORY_NAME = "name";
    protected static final String INTENT_EXTRA_CATEGORY_IMG_ID = "imgId";

    private List<DoctorCategoryItem> doctorCategoryItemList;

    protected void setNotificationBar(){
        if (isBuildVersionOk()) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    protected boolean isBuildVersionOk(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    protected List<DoctorCategoryItem> getDoctorCategoryData(){
        if(doctorCategoryItemList == null){
            doctorCategoryItemList = DoctorData.getDoctorCategoryData();
        }
        return doctorCategoryItemList;
    }
}
