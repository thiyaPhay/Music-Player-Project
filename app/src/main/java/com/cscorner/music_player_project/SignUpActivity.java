package com.cscorner.music_player_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    private MaterialButton btnBack;
    private TextInputEditText etUsernameEmail;
    private TextInputEditText etPassword;
    private Button btnSignup; // This is the Sign Up button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_activity);

        // Initialize views - ensure these IDs exist in your activity_sign_up.xml
        btnBack = findViewById(R.id.btnBack);
        etUsernameEmail = findViewById(R.id.etUsernameEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignUp);

        btnBack.setOnClickListener(v -> {
            // Handle back action
            onBackPressed(); // Standard way to go back
        });

        btnSignup.setOnClickListener(v -> {
            String username = etUsernameEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Basic validation
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(SignUpActivity.this, "Signing up...", Toast.LENGTH_SHORT).show(); // CORRECTED
                // signUpUser(username, password);
            }
        });
    }
}