package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.easydoctor24.R;
import com.easydoctor24.fragments.FilterDialogFragment;
import com.easydoctor24.fragments.MakeAppointmentFragment;

public class DoctorProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        setNotificationBar();

        Intent intent = getIntent();
    }

    public void makeApptClicked(View view) {
        FragmentManager fm = getSupportFragmentManager();
        String title = getResources().getString(R.string.filterDialogTitle);
        MakeAppointmentFragment apptDialog = MakeAppointmentFragment.newInstance();
        apptDialog.show(fm, "fragment_alert");
    }
}
