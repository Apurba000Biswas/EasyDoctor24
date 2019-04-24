package com.easydoctor24.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easydoctor24.R;
import com.easydoctor24.listeners.RVOnclickListener;
import com.easydoctor24.adapters.CategoryRVAdapter;
import com.easydoctor24.dataFactory.CategoryData;

public class CategoryFragment extends Fragment{



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup vg, Bundle bundle) {
        View rootView = inflater.inflate(R.layout.fragment_category, vg, false);
        setRecyclerView(rootView);
        return rootView;
    }


    private void setRecyclerView(View rootView){
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        CategoryRVAdapter mAdapter = new CategoryRVAdapter (
                CategoryData.getCategoryData(), (RVOnclickListener) getActivity());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        // ... any other GUI initialization needed
    }


}
