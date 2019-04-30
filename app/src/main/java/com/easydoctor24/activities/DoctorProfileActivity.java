package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;

import com.easydoctor24.R;

public class DoctorProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        setNotificationBar();

        Intent intent = getIntent();
    }
}
