package com.easydoctor24.utils;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    public void transformPage(@NonNull View view, float position) {
        if (position < -1){    // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        }
        else if (position <= 0){    // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);
        }
        else if (position <= 1){    // (0,1]
            view.setTranslationX(-position*view.getWidth());
            view.setAlpha(1-Math.abs(position));

        }
        else {    // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);

        }


    }
}
