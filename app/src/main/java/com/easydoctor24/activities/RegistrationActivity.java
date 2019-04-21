package com.easydoctor24.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.easydoctor24.R;

public class RegistrationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        View patientFragment = findViewById(R.id.fr_patient);
        patientFragment.setVisibility(View.GONE);

        View doctorFragment = findViewById(R.id.fr_doctor);
        doctorFragment.setVisibility(View.GONE);
    }

    public void patientClicked(View view) {
        View regFragment = findViewById(R.id.fr_registration);
        regFragment.setVisibility(View.GONE);

        View patientFragment = findViewById(R.id.fr_patient);
        patientFragment.setVisibility(View.VISIBLE);
    }

    public void doctorOnclick(View view) {
        View regFragment = findViewById(R.id.fr_registration);
        regFragment.setVisibility(View.GONE);

        View doctorFragment = findViewById(R.id.fr_doctor);
        doctorFragment.setVisibility(View.VISIBLE);
    }
}
