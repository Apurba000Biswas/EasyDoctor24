package com.easydoctor24.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easydoctor24.R;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.listeners.RVDoctorClickListener;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder>{

    private List<Doctor> mDataSet;
    private RVDoctorClickListener mClickListener;

    public DoctorAdapter(List<Doctor> dataSet,
                                   RVDoctorClickListener clickListener){
        //System.out.println("********** is doctor Empty? " + (dataSet.isEmpty()));
        this.mDataSet = dataSet;
        this.mClickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item2_doctor,
                        parent,
                        false);
        return new DoctorAdapter.ViewHolder(view, mDataSet, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctor currentData = mDataSet.get(position);
        holder.tvDoctorName.setText(currentData.getName());
        holder.tvDoctorDesignation.setText(currentData.getDesignation());
        holder.tvDoctorOnlineTime.setText(currentData.getOnlineTime());
        holder.tvDoctorFees.setText(String.valueOf(currentData.getFees()));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener {

        View mView;

        private List<Doctor> mDataSet;
        TextView tvDoctorName;
        TextView tvDoctorDesignation;
        TextView tvDoctorOnlineTime;
        TextView tvDoctorFees;

        private RVDoctorClickListener mListener;

        ViewHolder(View v, List<Doctor> dataset, RVDoctorClickListener
                listener) {
            super(v);
            mView = v;
            v.setOnClickListener(this);
            mDataSet = dataset;
            mListener = listener;
            initAllViews();
        }

        private void initAllViews(){
            tvDoctorName = mView.findViewById(R.id.tv_doctor_name);
            tvDoctorDesignation = mView.findViewById(R.id.tv_doctor_designation);
            tvDoctorOnlineTime = mView.findViewById(R.id.tv_doctor_online_time);
            tvDoctorFees = mView.findViewById(R.id.tv_doctor_fees);
        }

        @Override
        public void onClick(View view) {
            Doctor clickedDoctor = mDataSet.get(getAdapterPosition());
            mListener.onDoctorClick(clickedDoctor);
        }
    }
}
