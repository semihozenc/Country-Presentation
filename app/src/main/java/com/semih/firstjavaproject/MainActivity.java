package com.semih.firstjavaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.semih.firstjavaproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Database",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS anasayfa (id INTEGER PRIMARY KEY, konum VARCHAR, text VARCHAR)");
            database.execSQL("CREATE TABLE IF NOT EXISTS sehirler (id INTEGER PRIMARY KEY, sehir VARCHAR)");
            database.execSQL("CREATE TABLE IF NOT EXISTS basbakanlar (id INTEGER PRIMARY KEY, basbakan VARCHAR)");
            database.execSQL("CREATE TABLE IF NOT EXISTS uyeler (id INTEGER PRIMARY KEY, email VARCHAR, username VARCHAR, password VARCHAR)");
            //database.execSQL("INSERT INTO anasayfa (konum,text) VALUES ('slider','https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Kenya.svg/250px-Flag_of_Kenya.svg.png')");
            //database.execSQL("INSERT INTO anasayfa (konum,text) VALUES ('slider','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStNi4teHQ_UXu3-XYzKgdsECsM0YWNPjJjZw&usqp=CAU')");
            //database.execSQL("INSERT INTO anasayfa (konum,text) VALUES ('slider','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5ujN_Qu2dOqDyKG2WeCQ8O8O-MPzaGRlvcA&usqp=CAU')");
            //database.execSQL("INSERT INTO anasayfa (konum,text) VALUES ('slider','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6ZGfQ6G1M5GV_RDWyspPbvo9dpDqgg9TUyw&usqp=CAU')");
        } catch (Exception e) {
            e.printStackTrace();
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new homeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new homeFragment());
                    break;
                case R.id.about:
                    replaceFragment(new aboutFragment());
                    break;
            }

            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.login_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.login) {
            Intent intent = new Intent(this, loginActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.signup) {
            Intent intent = new Intent(this, signupActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}