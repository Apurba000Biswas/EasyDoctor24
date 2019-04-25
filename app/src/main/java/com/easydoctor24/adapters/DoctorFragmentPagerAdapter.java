package com.easydoctor24.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.easydoctor24.data_model.DoctorCategoryItem;
import com.easydoctor24.fragments.DoctorListFragment;

import java.util.List;

public class DoctorFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<DoctorCategoryItem> mDataSet;
    public DoctorFragmentPagerAdapter(FragmentManager fm , List<DoctorCategoryItem> dataSet){
        super(fm);
        mDataSet = dataSet;
    }


    @Override
    public Fragment getItem(int i) {
        DoctorCategoryItem curCategory = mDataSet.get(i);
        String categoryName = curCategory.getName();
        DoctorListFragment docListFragment = new DoctorListFragment();
        docListFragment.setCategory(categoryName);
        return docListFragment;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }
}
