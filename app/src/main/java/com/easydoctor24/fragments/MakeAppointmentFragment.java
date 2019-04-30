package com.easydoctor24.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.easydoctor24.R;

public class MakeAppointmentFragment extends DialogFragment{

    public MakeAppointmentFragment(){
    }

    public static MakeAppointmentFragment newInstance(){
        return new MakeAppointmentFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater factory = LayoutInflater.from(getContext());
        View rootView = factory.inflate(R.layout.fragment_make_appointment, null);
        setRootview(rootView);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(rootView);
        alertDialogBuilder.setPositiveButton("", null);
        alertDialogBuilder.setNegativeButton("", null);

        final Dialog dialog = alertDialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }

    private void setRootview(View rootView){
        LayoutInflater inflater = LayoutInflater.from(getContext());

        final LinearLayout chooseTimeHolder = rootView.findViewById(R.id.ll_choose_time_holder);
        View chooseTimeView = inflater.inflate(R.layout.choose_time, null);
        chooseTimeHolder.addView(chooseTimeView);
        chooseTimeHolder.setVisibility(View.VISIBLE);

        final LinearLayout patentInfoHolder = rootView.findViewById(R.id.ll_patient_info_holder);
        View patientInfoView = inflater.inflate(R.layout.paitent_info, null);
        patentInfoHolder.addView(patientInfoView);
        patientInfoView.setVisibility(View.GONE);

        final ImageView direction = rootView.findViewById(R.id.iv_make_appt_direction);
        direction.setTag(R.drawable.ic_next);

        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer) direction.getTag() == R.drawable.ic_next){
                    chooseTimeHolder.setVisibility(View.GONE);
                    patentInfoHolder.setVisibility(View.VISIBLE);
                    direction.setImageResource(R.drawable.ic_previous);
                    direction.setTag(R.drawable.ic_previous);
                }else{
                    chooseTimeHolder.setVisibility(View.VISIBLE);
                    patentInfoHolder.setVisibility(View.GONE);
                    direction.setImageResource(R.drawable.ic_next);
                    direction.setTag(R.drawable.ic_next);
                }
            }
        });
    }

}
