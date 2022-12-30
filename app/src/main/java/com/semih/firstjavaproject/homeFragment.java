package com.semih.firstjavaproject;

import static android.content.Context.MODE_PRIVATE;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {
    ImageSlider imageSlider;
    ArrayList<SlideModel> images;
    View view;
    List<String> slider;

    public homeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        slider = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        try {
            SQLiteDatabase database = getActivity().openOrCreateDatabase("Database", MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT text FROM anasayfa",null);
            int textIx = cursor.getColumnIndex("text");
            while (cursor.moveToNext()) {
                slider.add(cursor.getString(textIx));
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        imageSlider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(slider.get(0), null));
        images.add(new SlideModel(slider.get(1), null));
        images.add(new SlideModel(slider.get(2), null));
        images.add(new SlideModel(slider.get(3), null));


        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}