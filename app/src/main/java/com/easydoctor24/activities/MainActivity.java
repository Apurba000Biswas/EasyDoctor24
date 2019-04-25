package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.easydoctor24.R;
import com.easydoctor24.fragments.MyAppoinmentsFragment;
import com.easydoctor24.listeners.RVDoctorCategoryOnclickListener;
import com.easydoctor24.data_model.DoctorCategoryItem;
import com.easydoctor24.fragments.AccountFragment;
import com.easydoctor24.fragments.BookHistoryFragment;
import com.easydoctor24.fragments.CategoryFragment;

import java.util.List;

public class MainActivity extends BaseActivity implements RVDoctorCategoryOnclickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNotificationBar();

        setNavigation();
        loadFragment(new CategoryFragment());

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
                        fragment = new CategoryFragment();
                        break;
                    case R.id.action_book_history:
                        fragment = new BookHistoryFragment();
                        break;
                    case R.id.action_my_Appts:
                        fragment = new MyAppoinmentsFragment();
                        break;
                    case R.id.action_account:
                        fragment = new AccountFragment();
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

    @Override
    public void onCategoryClicked(DoctorCategoryItem clicked, int position) {
        Intent intent = new Intent(this, CategoryDetailsActivity.class);
        intent.putExtra(INTENT_EXTRA_CATEGORY_IMG_ID, clicked.getImgId());
        intent.putExtra(INTENT_EXTRA_POSITION, position);
        startActivity(intent);
    }

    @Override
    public List<DoctorCategoryItem> getDoctorCategoryData(){
        return super.getDoctorCategoryData();
    }
}
