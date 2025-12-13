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

public class vehicle_verification extends AppCompatActivity {
    MaterialCardView isb;
    MaterialCardView pb;
    MaterialCardView sindh;
    MaterialCardView kpk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vehicle_verification);
        isb = findViewById(R.id.islamabad);
        pb = findViewById(R.id.punjab);
        sindh = findViewById(R.id.sindh);
        kpk = findViewById(R.id.kpk);

        isb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vehicle_verification.this, browser.class);
                intent.putExtra("url","https://islamabadexcise.gov.pk/");
                startActivity(intent);
            }
        });
        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vehicle_verification.this, browser.class);
                intent.putExtra("url","https://mtmis.excise.punjab.gov.pk/");
                startActivity(intent);
            }
        });
        sindh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vehicle_verification.this, browser.class);
                intent.putExtra("url","https://excise.gos.pk/vehicle/vehicle_search");
                startActivity(intent);
            }
        });
        kpk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vehicle_verification.this, browser.class);
                intent.putExtra("url","https://www.kpexcise.gov.pk/mvrecords/");
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