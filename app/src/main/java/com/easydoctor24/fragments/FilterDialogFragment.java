package com.easydoctor24.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.easydoctor24.R;

public class FilterDialogFragment extends DialogFragment {


    public FilterDialogFragment(){
    }

    public static FilterDialogFragment newInstance(String title){
        FilterDialogFragment frag = new FilterDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        LayoutInflater factory = LayoutInflater.from(getContext());
        View rootView = factory.inflate(R.layout.fragment_filter_dialog, null);
        setDialogView(rootView);


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(rootView);
        alertDialogBuilder.setPositiveButton("", null);
        alertDialogBuilder.setNegativeButton("", null);

        final Dialog dialog = alertDialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView ivClose = rootView.findViewById(R.id.iv_close_filter);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        return dialog;
    }

    private void setDialogView(final View rootView){
        SeekBar filterBar = rootView.findViewById(R.id.sb_filter_bar);
        filterBar.setMax(1000);
        filterBar.setProgress(500);
        final TextView filterTextView = rootView.findViewById(R.id.tv_filter_fees);
        filterTextView.setText(String.valueOf(500));

        filterBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                filterTextView.setText(String.valueOf(progressChangedValue));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
