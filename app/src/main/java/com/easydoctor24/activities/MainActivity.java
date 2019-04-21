package com.easydoctor24.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.easydoctor24.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void patientClicked(View view) {
        Toast.makeText(this, "Patient Clicked", Toast.LENGTH_SHORT).show();
    }

    public void doctorOnclick(View view) {
        Toast.makeText(this, "Doctor Clicked", Toast.LENGTH_SHORT).show();
    }
}
