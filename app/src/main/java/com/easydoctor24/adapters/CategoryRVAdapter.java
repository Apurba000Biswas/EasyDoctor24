package com.easydoctor24.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.easydoctor24.R;
import com.easydoctor24.RVOnclickListener;
import com.easydoctor24.data_model.CategoryItem;

import java.util.List;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder>{


    private List<CategoryItem> mDataSet;
    private RVOnclickListener mClickListener;

    public CategoryRVAdapter(List<CategoryItem> dataSet, RVOnclickListener clickListener){
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
        CategoryItem currentData = mDataSet.get(position);
        holder.ivImgId.setImageResource(currentData.getImgId());
        holder.tvName.setText(currentData.getName());
        String totalDoc = currentData.getTotalDoctor() + " Doctors";
        holder.tvName.setText(totalDoc);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }




    public static class ViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener {

        View mView;

        private List<CategoryItem> mDataSet;
        ImageView ivImgId;
        TextView tvName;
        TextView tvTotalDoctor;

        private RVOnclickListener mListener;

        // Constructor - also initialize all fields with views
        ViewHolder(View v, List<CategoryItem> dataset, RVOnclickListener
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
            CategoryItem clickedItem = mDataSet.get(getAdapterPosition());
            mListener.onItemClicked(clickedItem);
        }
    }
}
