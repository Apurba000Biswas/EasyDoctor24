package com.easydoctor24.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.easydoctor24.R;

public class CategoryDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);
        setNotificationBar();

        Intent intent = getIntent();
        String catagoryType = intent.getStringExtra(INTENT_EXTRA_CATEGORY_NAME);
        int categoryImgId = intent.getIntExtra(INTENT_EXTRA_CATEGORY_IMG_ID, 0);
        setHeader(categoryImgId);
    }

    private void setHeader(int headerImgId){
        ImageView ivHeaderLogo = findViewById(R.id.iv_category_details_logo);
        if (headerImgId != 0)
            ivHeaderLogo.setImageResource(headerImgId);
    }
}
