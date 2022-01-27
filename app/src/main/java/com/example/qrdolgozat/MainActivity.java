package com.example.qrdolgozat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button scanBtn;
    private Button kiirBtn;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        scanBtn = findViewById(R.id.scanBtn);
        kiirBtn = findViewById(R.id.kiirBtn);
        txtView = findViewById(R.id.txtView);

        scanBtn.setOnClickListener(v -> scanBtnClick());
        kiirBtn.setOnClickListener(v -> kiirBtnClick());
    }

    private void scanBtnClick() {

    }

    private void kiirBtnClick() {

    }
}