package com.example.shopaodabong;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.usernameEditText);
        EditText password = findViewById(R.id.passwordEditText);
        EditText rePassword = findViewById(R.id.rePasswordEditText);

        Button registerButton = findViewById(R.id.registerButton);
        Button backButton = findViewById(R.id.backButton);

        registerButton.setOnClickListener(v -> {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            String rePasswordValue = rePassword.getText().toString();

            if (usernameValue.equals("") || passwordValue.equals("") || rePasswordValue.equals("")) {
                Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else if(!passwordValue.equals(rePasswordValue)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("username", usernameValue);
                intent.putExtra("password", passwordValue);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}