package com.semih.firstjavaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class aboutFragment extends Fragment implements View.OnClickListener {

    public aboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        Button cities = (Button) view.findViewById(R.id.button);
        Button tourism = (Button) view.findViewById(R.id.button1);
        Button industry = (Button) view.findViewById(R.id.button3);
        Button politics = (Button) view.findViewById(R.id.button4);
        cities.setOnClickListener(this);
        tourism.setOnClickListener(this);
        industry.setOnClickListener(this);
        politics.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.button:
                fragment = new citiesFragment();
                replaceFragment(fragment);
                break;
            case R.id.button1:
                fragment = new tourismFragment();
                replaceFragment(fragment);
                break;
            case R.id.button3:
                fragment = new industryFragment();
                replaceFragment(fragment);
                break;
            case R.id.button4:
                fragment = new politicsFragment();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}