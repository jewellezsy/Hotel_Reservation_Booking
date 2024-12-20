package com.example.hotelreservationbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvRegister = findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Validate credentials
            if (username.isEmpty() || password.isEmpty()) {
                if (username.isEmpty()) etUsername.setError("Username is required");
                if (password.isEmpty()) etPassword.setError("Password is required");
            } else if (username.equals("admin") && password.equals("password")) {
                Intent intent = new Intent(LoginActivity.this, RoomSelectionActivity.class);
                startActivity(intent);
            } else {
                etUsername.setError("Invalid username or password");
            }
        });

        tvRegister.setOnClickListener(v -> {
            // Navigate to Registration page (if available)
            // startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
        });
    }
}
