package com.easydoctor24.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.easydoctor24.R;
import com.easydoctor24.listeners.RVDoctorCategoryOnclickListener;
import com.easydoctor24.data_model.DoctorCategoryItem;

import java.util.List;

public class DoctorCategoryRVAdapter extends
        RecyclerView.Adapter<DoctorCategoryRVAdapter.ViewHolder>{


    private List<DoctorCategoryItem> mDataSet;
    private RVDoctorCategoryOnclickListener mClickListener;

    public DoctorCategoryRVAdapter(List<DoctorCategoryItem> dataSet,
                                   RVDoctorCategoryOnclickListener clickListener){
        this.mDataSet = dataSet;
        this.mClickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_item_category,
                        parent,
                        false);
        return new ViewHolder(view, mDataSet, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorCategoryItem currentData = mDataSet.get(position);
        holder.ivImgId.setImageResource(currentData.getImgId());
        holder.tvName.setText(currentData.getName());
        String totalDoc = currentData.getTotalDoctor() + " Doctors";
        holder.tvTotalDoctor.setText(totalDoc);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }




    public static class ViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener {

        View mView;

        private List<DoctorCategoryItem> mDataSet;
        ImageView ivImgId;
        TextView tvName;
        TextView tvTotalDoctor;

        private RVDoctorCategoryOnclickListener mListener;

        // Constructor - also initialize all fields with views
        ViewHolder(View v, List<DoctorCategoryItem> dataset, RVDoctorCategoryOnclickListener
                listener) {
            super(v);
            mView = v;
            v.setOnClickListener(this);
            mDataSet = dataset;
            mListener = listener;
            initAllViews();
        }

        private void initAllViews(){
            ivImgId = mView.findViewById(R.id.iv_categoryItem_logo);
            tvName = mView.findViewById(R.id.tv_categoryItem_name);
            tvTotalDoctor = mView.findViewById(R.id.tv_categoryItem_count);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            DoctorCategoryItem clickedItem = mDataSet.get(position);
            mListener.onCategoryClicked(clickedItem, position);
        }
    }
}
