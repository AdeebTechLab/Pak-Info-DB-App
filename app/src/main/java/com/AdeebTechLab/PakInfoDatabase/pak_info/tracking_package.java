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

public class tracking_package extends AppCompatActivity {
    MaterialCardView pakpost;
    MaterialCardView tcs;
    MaterialCardView lepoard;
    MaterialCardView daraz;
    MaterialCardView international;
    MaterialCardView mandp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tracking_package);
        pakpost = findViewById(R.id.pakistan_post);
        tcs = findViewById(R.id.tcs);
        lepoard = findViewById(R.id.leopareds);
        daraz = findViewById(R.id.daraz);
        international = findViewById(R.id.international);
        mandp = findViewById(R.id.mandp);
        pakpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tracking_package.this, browser.class);
                intent.putExtra("url","https://ep.gov.pk/");
                startActivity(intent);
            }
        });
        tcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tracking_package.this, browser.class);
                intent.putExtra("url","https://www.tcsexpress.com/track/");
                startActivity(intent);
            }
        });
        lepoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tracking_package.this, browser.class);
                intent.putExtra("url","https://www.leopardscourier.com/tracking");
                startActivity(intent);
            }
        });
        daraz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tracking_package.this, browser.class);
                intent.putExtra("url","https://www.trackingmore.com/shop/daraz.pk");
                startActivity(intent);
            }
        });
        international.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tracking_package.this, browser.class);
                intent.putExtra("url","https://www.17track.net/en/carriers/inter-courier");
                startActivity(intent);
            }
        });
        mandp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tracking_package.this, browser.class);
                intent.putExtra("url","https://mnptracking.com.pk/");
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