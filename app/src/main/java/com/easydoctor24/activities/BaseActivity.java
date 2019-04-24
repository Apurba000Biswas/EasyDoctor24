package com.easydoctor24.activities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


// Base Activity
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    protected static final String INTENT_EXTRA_CATEGORY_NAME = "name";

    protected void setNotificationBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}
