package com.easydoctor24.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easydoctor24.R;
import com.easydoctor24.data_model.DetailsDoctorCategoryItem;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.listeners.RVDoctorClickListener;

import java.util.List;


public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.ViewHolder>{

    private List<DetailsDoctorCategoryItem> mDataSet;
    private RVDoctorClickListener mClickedListener;
    private Context mContext;
    public DoctorListAdapter(List<DetailsDoctorCategoryItem> datset, Context context,
                             RVDoctorClickListener listener){
        mDataSet = datset;
        mClickedListener = listener;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_doctor_holder,
                        parent,
                        false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailsDoctorCategoryItem currentDoctorCategory = mDataSet.get(position);
        List<Doctor> doctorList = currentDoctorCategory.getDoctorList();


        holder.rvChild.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        holder.rvChild.setLayoutManager(layoutManager);

        DoctorAdapter doctorAdapter = new DoctorAdapter(doctorList, mClickedListener);
        holder.rvChild.setAdapter(doctorAdapter);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class ViewHolder extends
            RecyclerView.ViewHolder {

        RecyclerView rvChild;
        ViewHolder(View view) {
            super(view);
            rvChild = view.findViewById(R.id.rv_doctor_list);
        }
    }
}
