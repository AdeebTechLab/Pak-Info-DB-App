package com.AdeebTechLab.PakInfoDatabase.pak_info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class license extends AppCompatActivity {
    MaterialCardView isb;
    MaterialCardView pb;
    MaterialCardView sindh;
    MaterialCardView nha;
    MaterialCardView kpk;
    MaterialCardView qutta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_license);
        isb = findViewById(R.id.blochistan);
        pb = findViewById(R.id.punjab);
        sindh = findViewById(R.id.sindh);
        nha = findViewById(R.id.nha);
        kpk = findViewById(R.id.kpk);
        qutta = findViewById(R.id.quetta);

        isb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(license.this, browser.class);
                intent.putExtra("url","https://ict.islamabadpolice.gov.pk/license_verification/");
                startActivity(intent);
            }
        });
        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(license.this, browser.class);
                intent.putExtra("url","https://dlims.punjab.gov.pk/verify");
                startActivity(intent);
            }
        });
        sindh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(license.this, browser.class);
                intent.putExtra("url","https://dls.gos.pk/online-verification.html");
                startActivity(intent);
            }
        });
        nha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(license.this, browser.class);
                intent.putExtra("url","https://dla.nhmp.gov.pk/LicVerification.aspx");
                startActivity(intent);
            }
        });
        kpk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(license.this, browser.class);
                intent.putExtra("url","https://ptpkp.gov.pk/driving-license-verification/");
                startActivity(intent);
            }
        });
        qutta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(license.this, browser.class);
                intent.putExtra("url","https://qtp.gob.pk/driving");
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}