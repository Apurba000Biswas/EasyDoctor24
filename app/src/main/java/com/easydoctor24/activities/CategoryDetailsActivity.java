package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.easydoctor24.R;
import com.easydoctor24.adapters.DoctorFragmentPagerAdapter;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.data_model.DoctorCategoryItem;
import com.easydoctor24.fragments.FilterDialogFragment;
import com.easydoctor24.listeners.RVDoctorClickListener;
import com.easydoctor24.utils.DepthPageTransformer;

import java.util.List;


public class CategoryDetailsActivity extends BaseActivity implements RVDoctorClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        setNotificationBar();

        Intent intent = getIntent();
        int categoryImgId = intent.getIntExtra(INTENT_EXTRA_CATEGORY_IMG_ID, 0);
        int position = intent.getIntExtra(INTENT_EXTRA_POSITION, 0);

        setViewPager(position);
        setHeader(categoryImgId, true);
        setCategoryFilterButton();
    }

    private void setViewPager(int position){
        ViewPager viewPager = findViewById(R.id.vp_doctorList);
        DoctorFragmentPagerAdapter adapter =
                new DoctorFragmentPagerAdapter(getSupportFragmentManager(), getDoctorCategoryData());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {}

            @Override
            public void onPageSelected(int i) {
                List<DoctorCategoryItem> categoryItems = getDoctorCategoryData();
                DoctorCategoryItem curItem = categoryItems.get(i);
                setHeader(curItem.getImgId(), false);
            }

            @Override
            public void onPageScrollStateChanged(int i) {}
        });
        if (isBuildVersionOk())
            viewPager.setPageTransformer(true, new DepthPageTransformer());
    }

    private void setHeader(int headerImgId, boolean isActivityLaunched){
        ImageView ivHeaderLogo = findViewById(R.id.iv_category_details_logo);
        if (headerImgId != 0) ivHeaderLogo.setImageResource(headerImgId);

        Animation headerAnimation = (isActivityLaunched)?
                AnimationUtils.loadAnimation(this, R.anim.slide_right) :
                AnimationUtils.loadAnimation(this, R.anim.fade_in);
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
        Intent intent = new Intent(this, DoctorProfileActivity.class);
        //intent.putExtra(INTENT_EXTRA_CATEGORY_IMG_ID, clicked.getImgId());
        //intent.putExtra(INTENT_EXTRA_POSITION, position);
        startActivity(intent);
    }

    public void filterClicked(View view) {
        FragmentManager fm = getSupportFragmentManager();
        String title = getResources().getString(R.string.filterDialogTitle);
        FilterDialogFragment alertDialog = FilterDialogFragment.newInstance(title);
        alertDialog.show(fm, "fragment_alert");
    }
}
