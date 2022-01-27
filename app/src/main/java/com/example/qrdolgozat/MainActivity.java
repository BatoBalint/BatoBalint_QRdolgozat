package com.example.qrdolgozat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

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
        IntentIntegrator qrIntent = new IntentIntegrator(this);
        qrIntent.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        qrIntent.setPrompt("QR Scan");
        qrIntent.setCameraId(0);
        qrIntent.setBeepEnabled(false);
        qrIntent.setOrientationLocked(false);
        qrIntent.initiateScan();
    }

    private void kiirBtnClick() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Scanner closed", Toast.LENGTH_SHORT).show();
            } else {
                txtView.setText(result.getContents());
            }
        }
    }
}