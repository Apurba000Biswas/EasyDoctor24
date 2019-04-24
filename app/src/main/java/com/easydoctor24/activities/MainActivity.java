package com.easydoctor24.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.Toast;

import com.easydoctor24.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNavigation();
    }

    private void setNavigation(){
        final BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setOnNavigationItemReselectedListener(
                new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_category:
                        Toast.makeText(MainActivity.this, "Category", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_book_history:
                        Toast.makeText(MainActivity.this, "Book History", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_account:
                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
