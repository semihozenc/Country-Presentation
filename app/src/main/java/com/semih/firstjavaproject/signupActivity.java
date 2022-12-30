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
        import android.widget.Toast;

        import com.semih.firstjavaproject.databinding.ActivityAdminBinding;
        import com.semih.firstjavaproject.databinding.ActivitySignupBinding;

public class signupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void uyeOl(View view) {
        String emailTxt = binding.email.getText().toString();
        String usernameTxt = binding.username1.getText().toString();
        String passwordTxt = binding.password1.getText().toString();
        try {
            database = this.openOrCreateDatabase("Database", MODE_PRIVATE, null);
            String sqlStr = "INSERT INTO uyeler (email,username,password) VALUES (?,?,?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlStr);
            sqLiteStatement.bindString(1,emailTxt);
            sqLiteStatement.bindString(2,usernameTxt);
            sqLiteStatement.bindString(3,passwordTxt);
            sqLiteStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(signupActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(signupActivity.this,"Üyelik başarılı",Toast.LENGTH_SHORT).show();

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