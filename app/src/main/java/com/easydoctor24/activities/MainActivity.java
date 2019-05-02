package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.easydoctor24.R;
import com.easydoctor24.adapters.DoctorFragmentPagerAdapter;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.fragments.FilterDialogFragment;
import com.easydoctor24.listeners.RVDoctorCategoryOnclickListener;
import com.easydoctor24.data_model.DoctorCategoryItem;
import com.easydoctor24.listeners.RVDoctorClickListener;
import com.easydoctor24.utils.DepthPageTransformer;

import java.util.List;

public class MainActivity extends BaseActivity implements RVDoctorClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNotificationBar();

        setNavigation();
        setViewPager(0);
        setHeader(R.drawable.ic_action_close, true);
        setCategoryFilterButton();
    }

    private void setNavigation() {
        final BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.action_category);

        navigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {

                    case R.id.action_category:
                        //fragment = new CategoryFragment();
                        //fragment = new CategoryDetailsFragment();
                        break;
                    case R.id.action_book_history:
                        //fragment = new BookHistoryFragment();
                        break;
                    case R.id.action_my_Appts:
                        //fragment = new MyAppoinmentsFragment();
                        break;
                    case R.id.action_account:
                        //fragment = new AccountFragment();
                        break;
                }
                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
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
}
