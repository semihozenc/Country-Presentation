package com.semih.firstjavaproject;

import static android.content.Context.MODE_PRIVATE;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.semih.firstjavaproject.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link politicsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class politicsFragment extends Fragment {
    ActivityMainBinding binding;
    ArrayList<String> dbBasbakan;
    ArrayAdapter adapter;
    ListView listView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public politicsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment politicsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static politicsFragment newInstance(String param1, String param2) {
        politicsFragment fragment = new politicsFragment();
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
        View view = inflater.inflate(R.layout.fragment_politics, container, false);

        listView = view.findViewById(R.id.dbList);
        dbBasbakan = new ArrayList<>();

        try {
            SQLiteDatabase database = getActivity().openOrCreateDatabase("Database", MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT basbakan FROM basbakanlar",null);
            int textIx = cursor.getColumnIndex("basbakan");
            while (cursor.moveToNext()) {
                dbBasbakan.add(cursor.getString(textIx));
            }
            adapter.notifyDataSetChanged();
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,dbBasbakan);
        listView.setAdapter(adapter);



        return view;
    }
}