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
        String categoryType = intent.getStringExtra(INTENT_EXTRA_CATEGORY_NAME);
        int categoryImgId = intent.getIntExtra(INTENT_EXTRA_CATEGORY_IMG_ID, 0);
        setHeader(categoryImgId);
        setCategoryFilter();
    }

    private void setHeader(int headerImgId){
        ImageView ivHeaderLogo = findViewById(R.id.iv_category_details_logo);
        if (headerImgId != 0) ivHeaderLogo.setImageResource(headerImgId);

        Animation headerAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        setAnimation(ivHeaderLogo, headerAnimation);
    }

    private void setCategoryFilter(){
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
}
