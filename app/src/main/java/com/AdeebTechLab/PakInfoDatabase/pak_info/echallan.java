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

public class echallan extends AppCompatActivity {

    MaterialCardView punjab;
    MaterialCardView sindh;
    MaterialCardView isb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_echallan);

        // You must initialize views AFTER setContentView is called.
        punjab = findViewById(R.id.punjab);
        sindh = findViewById(R.id.sindh);
        isb = findViewById(R.id.isb);

        punjab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(echallan.this, browser.class);
                intent.putExtra("url", "https://e-challan.pk/");
                startActivity(intent);
            }
        });

        sindh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(echallan.this, browser.class);
                intent.putExtra("url", "https://www.sindhpolice.gov.pk/challan-check");
                startActivity(intent);
            }
        });

        isb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(echallan.this, browser.class);
                intent.putExtra("url", "https://islamabadpolice.gov.pk/echallan.php");
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
