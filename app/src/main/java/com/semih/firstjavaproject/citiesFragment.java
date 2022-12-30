package com.semih.firstjavaproject;

import static android.content.Context.MODE_PRIVATE;

import android.app.ActionBar;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.semih.firstjavaproject.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link citiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class citiesFragment extends Fragment {

    ArrayList<city> cityArrayList;
    ActivityMainBinding binding;
    cityAdaptor cityAdaptor;
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public citiesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment citiesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static citiesFragment newInstance(String param1, String param2) {
        citiesFragment fragment = new citiesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cities, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        cityArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        cityAdaptor = new cityAdaptor(getData(),getContext());
        recyclerView.setAdapter(cityAdaptor);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private ArrayList<city> getData() {
        try {
            SQLiteDatabase database = getActivity().openOrCreateDatabase("Database", MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT sehir FROM sehirler",null);
            int sehirIx = cursor.getColumnIndex("sehir");
            while (cursor.moveToNext()) {
                String sehirName = cursor.getString(sehirIx);
                city city = new city(sehirName);
                cityArrayList.add(city);
            }

            cityAdaptor.notifyDataSetChanged();
            cursor.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return cityArrayList;
    }

}