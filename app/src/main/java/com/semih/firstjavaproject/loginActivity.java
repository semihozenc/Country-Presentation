package com.semih.firstjavaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.semih.firstjavaproject.databinding.ActivityMainBinding;

public class loginActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn =(MaterialButton) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(loginActivity.this,"Giriş başarılı",Toast.LENGTH_SHORT).show();
                    pageChange();
                } else {
                    Toast.makeText(loginActivity.this,"Hatalı Giriş!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void pageChange() {
        Intent intent = new Intent(this,adminActivity.class);
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