package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.easydoctor24.R;
import com.easydoctor24.adapters.DoctorFragmentPagerAdapter;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.listeners.RVDoctorClickListener;


public class CategoryDetailsActivity extends BaseActivity implements RVDoctorClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        setNotificationBar();

        Intent intent = getIntent();
        int categoryImgId = intent.getIntExtra(INTENT_EXTRA_CATEGORY_IMG_ID, 0);
        int position = intent.getIntExtra(INTENT_EXTRA_POSITION, 0);

        ViewPager viewPager = findViewById(R.id.vp_doctorList);
        DoctorFragmentPagerAdapter adapter =
                new DoctorFragmentPagerAdapter(getSupportFragmentManager(), getDoctorCategoryData());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

        setHeader(categoryImgId);
        setCategoryFilterButton();
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


    @Override
    public void onDoctorClick(Doctor clickedDoctor) {
        Toast.makeText(this, "Cliked on " + clickedDoctor.getName(), Toast.LENGTH_SHORT).show();
    }
}
