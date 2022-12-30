package com.semih.firstjavaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.semih.firstjavaproject.databinding.ActivityAdminBinding;

public class adminActivity extends AppCompatActivity {
    SQLiteDatabase database;
    ActivityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }


    public void sehirSave(View view) {
        String sehirText = binding.sehirAdi.getText().toString();
        try {
            database = this.openOrCreateDatabase("Database", MODE_PRIVATE, null);
            String sqlStr = "INSERT INTO sehirler (sehir) VALUES (?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlStr);
            sqLiteStatement.bindString(1,sehirText);
            sqLiteStatement.execute();
            System.out.println(sqlStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(adminActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void sehirDelete(View view) {
        String sehirText = binding.sehirAdiSil.getText().toString();
        try {
            database = this.openOrCreateDatabase("Database", MODE_PRIVATE, null);
            String sqlStr = "DELETE FROM sehirler WHERE sehir = (?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlStr);
            sqLiteStatement.bindString(1,sehirText);
            sqLiteStatement.execute();
            System.out.println(sqlStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(adminActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void basbakanEkle(View view) {
        String basbakanTxt = binding.basbakanEkleTxt.getText().toString();
        try {
            database = this.openOrCreateDatabase("Database", MODE_PRIVATE, null);
            String sqlStr = "INSERT INTO basbakanlar (basbakan) VALUES (?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlStr);
            sqLiteStatement.bindString(1,basbakanTxt);
            sqLiteStatement.execute();
            System.out.println(sqlStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(adminActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void basbakanSil(View view) {
        String basbakanTxt = binding.basbakanSilTxt.getText().toString();
        try {
            database = this.openOrCreateDatabase("Database", MODE_PRIVATE, null);
            String sqlStr = "DELETE FROM basbakanlar WHERE basbakan = (?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlStr);
            sqLiteStatement.bindString(1,basbakanTxt);
            sqLiteStatement.execute();
            System.out.println(sqlStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(adminActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
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