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

public class sim_owner extends AppCompatActivity {

    MaterialCardView server1;
    MaterialCardView server2;
    MaterialCardView server3;
    MaterialCardView server4;
    MaterialCardView server5;
    MaterialCardView server6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sim_owner);
        server1 = findViewById(R.id.server_1);
        server2 = findViewById(R.id.server_2);
        server3 = findViewById(R.id.server_3);
        server4 = findViewById(R.id.server_4);
        server5 = findViewById(R.id.server_5);
        server6 = findViewById(R.id.server_6);

        server1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sim_owner.this, browser.class);
                intent.putExtra("url","http://cnic.sims.pk/");
                startActivity(intent);
            }
        });
        server2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sim_owner.this, browser.class);
                intent.putExtra("url","https://kashiimalik.com/tools/sim-owner-details");
                startActivity(intent);
            }
        });
        server3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sim_owner.this, browser.class);
                intent.putExtra("url","https://simownership.net/");
                startActivity(intent);
            }
        });
        server4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sim_owner.this, browser.class);
                intent.putExtra("url","https://cnic.pk");
                startActivity(intent);
            }
        });
        server5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sim_owner.this, browser.class);
                intent.putExtra("url","https://dbcenter.cc/result/");
                startActivity(intent);
            }
        });
        server6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sim_owner.this, browser.class);
                intent.putExtra("url","https://simdetails.net/");
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