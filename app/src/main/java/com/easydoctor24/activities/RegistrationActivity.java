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
    }

    public void patientClicked(View view) {
        View regFragment = findViewById(R.id.fr_registration);
        regFragment.setVisibility(View.GONE);
        Toast.makeText(this, "Patient Clicked", Toast.LENGTH_SHORT).show();
    }

    public void doctorOnclick(View view) {
        Toast.makeText(this, "Doctor Clicked", Toast.LENGTH_SHORT).show();
    }
}
