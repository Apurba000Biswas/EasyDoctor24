package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;

import com.easydoctor24.R;

public class CategoryDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        setNotificationBar();

        Intent intent = getIntent();
        String extra = intent.getStringExtra(INTENT_EXTRA_CATEGORY_NAME);
    }
}
