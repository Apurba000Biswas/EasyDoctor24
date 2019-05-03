package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.easydoctor24.R;
import com.easydoctor24.adapters.DoctorCategoryRVAdapter;
import com.easydoctor24.adapters.DoctorFragmentPagerAdapter;
import com.easydoctor24.dataFactory.DoctorData;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.fragments.FilterDialogFragment;
import com.easydoctor24.data_model.DoctorCategoryItem;
import com.easydoctor24.listeners.RVDoctorCategoryOnclickListener;
import com.easydoctor24.listeners.RVDoctorClickListener;
import com.easydoctor24.utils.DepthPageTransformer;

import java.util.List;

public class MainActivity extends BaseActivity implements
        RVDoctorClickListener, RVDoctorCategoryOnclickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNotificationBar();

        setNavigation();
        setRecyclerView();
        setViewPager(0);
        setHeader(R.drawable.heart, true);
        setCategoryFilterButton();
    }

    private void setRecyclerView(){
        RecyclerView rvCateGory = findViewById(R.id.rv_category_list);
        rvCateGory.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        rvCateGory.setLayoutManager(layoutManager);

        List<DoctorCategoryItem> dataSet = DoctorData.getDoctorCategoryData();
        DoctorCategoryRVAdapter adapter = new DoctorCategoryRVAdapter(dataSet, this);
        rvCateGory.setAdapter(adapter);
    }

    private void setNavigation() {
        final BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent = null;
                switch (menuItem.getItemId()) {

                    case R.id.action_my_Appts:
                        intent = new Intent(MainActivity.this, MyAppointmentActivity.class);
                        break;
                    case R.id.action_appts_upcomming:
                        intent = new Intent(MainActivity.this, UpcomingAppointmentActivity.class);
                        break;
                    case R.id.action_account:
                        intent = new Intent(MainActivity.this, PatientAccountActivity.class);
                        break;
                }
                return startTheActivity(intent);
            }
        });
    }

    private boolean startTheActivity(Intent intent){
        if (intent != null){
            startActivity(intent);
            return true;
        }
        return false;
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
        ivHeaderLogo.bringToFront();
        if (headerImgId != 0) ivHeaderLogo.setImageResource(headerImgId);

        Animation headerAnimation = (isActivityLaunched)?
                AnimationUtils.loadAnimation(this, R.anim.slide_right) :
                AnimationUtils.loadAnimation(this, R.anim.fade_in);
        setAnimation(ivHeaderLogo, headerAnimation);
    }

    private void setAnimation(ImageView imageView, Animation animation){
        if (isBuildVersionOk()){
            imageView.setElevation(100);
            animation.setDuration(700);
            imageView.startAnimation(animation);
        }
    }

    private void setCategoryFilterButton(){
        ImageView ivCategoryFilter = findViewById(R.id.iv_category_details_filter);

        Animation filterAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        setAnimation(ivCategoryFilter, filterAnimation);
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
        FilterDialogFragment filterDialog = FilterDialogFragment.newInstance(title);
        filterDialog.show(fm, "fragment_alert");
    }

    @Override
    public void onCategoryClicked(DoctorCategoryItem clicked, int position) {
        Toast.makeText(this, "Clicked on " + clicked.getName(), Toast.LENGTH_SHORT).show();
    }
}
