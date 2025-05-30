package com.cscorner.music_player_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private MaterialButton btnBack;
    private TextInputEditText etUsernameEmail;
    private TextInputEditText etPassword;
    private Button btnLogin; // This is the Login button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);

        btnBack = findViewById(R.id.btnBack);
        etUsernameEmail = findViewById(R.id.etUsernameEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnBack.setOnClickListener(v -> {
            // Handle back action
            onBackPressed(); // Standard way to go back
        });

        btnLogin.setOnClickListener(v -> {
            String username = etUsernameEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Basic validation
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(LoginActivity.this, "Logging In...", Toast.LENGTH_SHORT).show(); // CORRECTED
                // Login User(username, password);
            }
        });
    }
}