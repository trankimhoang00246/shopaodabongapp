package com.example.shopaodabong;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnPhongBan = findViewById(R.id.btnPhongBan);
        Button btnNhanVien = findViewById(R.id.btnNhanVien);
        Button btnThoat = findViewById(R.id.btnThoat);

        btnPhongBan.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DepartmentActivity.class);
            startActivity(intent);
        });

        btnNhanVien.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ListActivity.class);
            startActivity(intent);
        });

        btnThoat.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

}