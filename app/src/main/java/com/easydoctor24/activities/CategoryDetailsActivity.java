package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.easydoctor24.R;

public class CategoryDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        setNotificationBar();

        Intent intent = getIntent();
        String catagoryType = intent.getStringExtra(INTENT_EXTRA_CATEGORY_NAME);
        int categoryImgId = intent.getIntExtra(INTENT_EXTRA_CATEGORY_IMG_ID, 0);
        setHeader(categoryImgId);
        setCategoryFilter();
    }

    private void setHeader(int headerImgId){
        ImageView ivHeaderLogo = findViewById(R.id.iv_category_details_logo);
        if (headerImgId != 0) ivHeaderLogo.setImageResource(headerImgId);

        if (isBuildVersionOk()){
            ivHeaderLogo.setElevation(100);
            Animation headerAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_right);
            headerAnimation.setDuration(700);
            ivHeaderLogo.startAnimation(headerAnimation);
        }
    }

    private void setCategoryFilter(){
        ImageView ivCategoryFilter = findViewById(R.id.iv_category_details_filter);
        if (isBuildVersionOk()){
            ivCategoryFilter.setElevation(200);
            Animation filterAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            filterAnimation.setDuration(700);
            ivCategoryFilter.startAnimation(filterAnimation);
        }
    }
}
