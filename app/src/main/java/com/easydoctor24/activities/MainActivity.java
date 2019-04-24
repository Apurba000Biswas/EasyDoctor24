package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.easydoctor24.R;
import com.easydoctor24.listeners.RVOnclickListener;
import com.easydoctor24.data_model.CategoryItem;
import com.easydoctor24.fragments.AccountFragment;
import com.easydoctor24.fragments.BookHistoryFragment;
import com.easydoctor24.fragments.CategoryFragment;

public class MainActivity extends BaseActivity implements RVOnclickListener {

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
    public void onItemClicked(CategoryItem clicked) {
        Intent intent = new Intent(this, CategoryDetailsActivity.class);
        intent.putExtra(INTENT_EXTRA_CATEGORY_NAME, clicked.getName());
        startActivity(intent);
    }
}
