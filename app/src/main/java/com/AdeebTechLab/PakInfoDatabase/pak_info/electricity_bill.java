package com.AdeebTechLab.PakInfoDatabase.pak_info;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class electricity_bill extends AppCompatActivity {
    MaterialCardView fesco;
    MaterialCardView lesco;
    MaterialCardView iesco;
    MaterialCardView ke;
    MaterialCardView mepco;
    MaterialCardView gepco;
    MaterialCardView pesco;
    MaterialCardView sepco;
    MaterialCardView qesco;
    MaterialCardView hesco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_electricity_bill);
        fesco = findViewById(R.id.fesco);
        lesco = findViewById(R.id.lesco);
        iesco = findViewById(R.id.iesco);
        ke = findViewById(R.id.ke);
        mepco = findViewById(R.id.mepco);
        gepco = findViewById(R.id.gepco);
        pesco = findViewById(R.id.pesco);
        sepco = findViewById(R.id.sepco);
        qesco = findViewById(R.id.qesco);
        hesco = findViewById(R.id.hesco);
        fesco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/fescobill");
                startActivity(intent);
            }
        });
        lesco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/lescobill");
                startActivity(intent);
            }
        });
        iesco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/iescobill");
                startActivity(intent);
            }
        });
        ke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://keduplicatebill.com.pk/");
                startActivity(intent);
            }
        });
        gepco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/gepcobill");
                startActivity(intent);
            }
        });
        mepco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/mepcobill");
                startActivity(intent);
            }
        });
        qesco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/qescobill");
                startActivity(intent);
            }
        });
        hesco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/hescobill");
                startActivity(intent);
            }
        });
        sepco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/sepcobill");
                startActivity(intent);
            }
        });
        pesco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electricity_bill.this, browser.class);
                intent.putExtra("url","https://bill.pitc.com.pk/pescobill");
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