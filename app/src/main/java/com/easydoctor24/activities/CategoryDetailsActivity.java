package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.easydoctor24.R;
import com.easydoctor24.adapters.DoctorListAdapter;
import com.easydoctor24.dataFactory.DoctorData;
import com.easydoctor24.data_model.DetailsDoctorCategoryItem;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.data_model.DoctorCategoryItem;
import com.easydoctor24.listeners.RVDoctorClickListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailsActivity extends BaseActivity implements RVDoctorClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        setNotificationBar();

        Intent intent = getIntent();
        String categoryType = intent.getStringExtra(INTENT_EXTRA_CATEGORY_NAME);
        int categoryImgId = intent.getIntExtra(INTENT_EXTRA_CATEGORY_IMG_ID, 0);
        setHeader(categoryImgId);
        setCategoryFilterButton();

        setRecyclerView();
    }

    private void setHeader(int headerImgId){
        ImageView ivHeaderLogo = findViewById(R.id.iv_category_details_logo);
        if (headerImgId != 0) ivHeaderLogo.setImageResource(headerImgId);

        Animation headerAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        setAnimation(ivHeaderLogo, headerAnimation);
    }

    private void setCategoryFilterButton(){
        ImageView ivCategoryFilter = findViewById(R.id.iv_category_details_filter);

        Animation filterAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        setAnimation(ivCategoryFilter, filterAnimation);
    }

    private void setAnimation(ImageView imageView, Animation animation){
        if (isBuildVersionOk()){
            imageView.setElevation(100);
            animation.setDuration(700);
            imageView.startAnimation(animation);
        }
    }


    private void setRecyclerView(){
        RecyclerView rvDoctorsHolder = findViewById(R.id.rv_doctors_holder);
        rvDoctorsHolder.setHasFixedSize(true);

        LinearLayoutManager layoutManager

                = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        rvDoctorsHolder.setLayoutManager(layoutManager);
        DoctorListAdapter adapter = new DoctorListAdapter (getAllCategories(), this, this);
        rvDoctorsHolder.setAdapter(adapter);
    }


    private List<DetailsDoctorCategoryItem> getAllCategories(){
        List<DetailsDoctorCategoryItem> categoryItemList = new ArrayList<>();

        List<DoctorCategoryItem> baseCategory = getDoctorCategoryData();
        for (DoctorCategoryItem curCategory : baseCategory){
            List<Doctor> doctors = DoctorData.getDoctorList(curCategory.getName());
            categoryItemList.add(new DetailsDoctorCategoryItem(curCategory.getImgId(), curCategory.getName(), doctors));
        }
        return categoryItemList;
    }

    @Override
    public void onDoctorClick(Doctor clickedDoctor) {
        Toast.makeText(this, "Cliked on " + clickedDoctor.getName(), Toast.LENGTH_SHORT).show();
    }
}
