package com.geeks.homeapp6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.geeks.homeapp6.databinding.ActivityLoginBinding;
import com.geeks.homeapp6.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    Button button;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        editText1 = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);

      findViewById(R.id.button).setOnClickListener(v -> {
          String login = editText1.getText().toString();
          String password = editText2.getText().toString();
          if (login.equals("car") && password.equals("car")){
              Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
              startActivity(intent);
              finish();
          } else {
              Snackbar.make(v, "Неправильный логин или пароль", Snackbar.LENGTH_SHORT).show();
          }
      });
    }
}