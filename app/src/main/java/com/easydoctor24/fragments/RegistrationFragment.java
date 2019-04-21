package com.easydoctor24.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easydoctor24.R;

public class RegistrationFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup vg, Bundle bundle) {
        // load the GUI layout from the XML
        return inflater.inflate(R.layout.fragment_patient, vg, false);
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        // ... any other GUI initialization needed
    }
}
