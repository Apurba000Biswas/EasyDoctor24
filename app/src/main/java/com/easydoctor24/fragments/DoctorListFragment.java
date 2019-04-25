package com.easydoctor24.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easydoctor24.R;
import com.easydoctor24.adapters.DoctorAdapter;
import com.easydoctor24.dataFactory.DoctorData;
import com.easydoctor24.data_model.Doctor;
import com.easydoctor24.listeners.RVDoctorClickListener;

import java.util.List;

public class DoctorListFragment extends Fragment implements RVDoctorClickListener {

    private String category;

    public void setCategory(String category){
        this.category = category;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup vg, Bundle bundle) {
        View rootView = inflater.inflate(R.layout.fragment_doctor_list, vg, false);
        setRecyclerView(rootView);
        return rootView;
    }

    private void setRecyclerView(View rootView){
        RecyclerView rvDoctorList = rootView.findViewById(R.id.rv_doctor_list);
        rvDoctorList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvDoctorList.setLayoutManager(layoutManager);

        List<Doctor> doctorList = DoctorData.getDoctorList(category);

        DoctorAdapter adapter = new DoctorAdapter(doctorList, this);
        rvDoctorList.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        // ... any other GUI initialization needed
    }

    @Override
    public void onDoctorClick(Doctor clickedDoctor) {
        ((RVDoctorClickListener)getActivity()).onDoctorClick(clickedDoctor);
    }
}
