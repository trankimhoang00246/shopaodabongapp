package com.example.shopaodabong;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.usernameEditText);
        EditText password = findViewById(R.id.passwordEditText);
        CheckBox rememberMe = findViewById(R.id.rememberMeCheckbox);

        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(v -> {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            boolean rememberMeValue = rememberMe.isChecked();
            if (usernameValue.equals("") && passwordValue.equals("")) {
                Toast.makeText(this, "Vui lòng nhập username và password", Toast.LENGTH_SHORT).show();
            } else if (usernameValue.equals("")) {
                Toast.makeText(this, "Vui lòng nhập username", Toast.LENGTH_SHORT).show();
            } else if (passwordValue.equals("")) {
                Toast.makeText(this, "Vui lòng nhập password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Username: " + usernameValue + ", password: " + passwordValue, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        myLauncher.launch(intent);
                    }
                }
        );
    }

    private ActivityResultLauncher<Intent> myLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK) {
                                Intent data = result.getData();
                                String username = data.getStringExtra("username");
                                String password = data.getStringExtra("password");
                                Toast.makeText(LoginActivity.this, "Username: " + username + ", Password: " + password, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
}