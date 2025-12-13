package com.AdeebTechLab.PakInfoDatabase.pak_info;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    // Cards
    MaterialCardView myCardView1, myCardView2, myCardView3, myCardView4,
            myCardView5, myCardView6, myCardView7, myCardView8, myCardView9, myCardView10, myCardView11;
    ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7,
    imageButton8, imageButton9, imageButton10, imageButton11;

    private static final String PREFS_NAME = "AppPrefs";
    private static final String KEY_DIALOG_SHOWN = "dialogShown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Show dialog one time only
        showWelcomeDialogIfNeeded();

        // ------------------------------------
        // Initialize Card Views
        // ------------------------------------
        myCardView1 = findViewById(R.id.materialCardView1);
        myCardView2 = findViewById(R.id.materialCardView2);
        myCardView3 = findViewById(R.id.materialCardView3);
        myCardView4 = findViewById(R.id.materialCardView4);
        myCardView5 = findViewById(R.id.materialCardView5);
        myCardView6 = findViewById(R.id.materialCardView6);
        myCardView7 = findViewById(R.id.materialCardView7);
        myCardView8 = findViewById(R.id.materialCardView8);
        myCardView9 = findViewById(R.id.materialCardView9);
        myCardView10 = findViewById(R.id.materialCardView10);
        myCardView11 = findViewById(R.id.materialCardView11);

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton6 = findViewById(R.id.imageButton6);
        imageButton7 = findViewById(R.id.imageButton7);
        imageButton8 = findViewById(R.id.imageButton8);
        imageButton9 = findViewById(R.id.imageButton9);
        imageButton10 = findViewById(R.id.imageButton10);
        imageButton11 = findViewById(R.id.imageButton11);

        // ------------------------------------
        // Set Click Listeners
        // ------------------------------------
        myCardView1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, sim_owner.class)));
        myCardView2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, license.class)));
        myCardView3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, onlinefir.class)));
        myCardView4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ntninquiry.class)));
        myCardView5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, vehicle_verification.class)));
        myCardView6.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, echallan.class)));
        myCardView7.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, passport.class)));
        myCardView8.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, electricity_bill.class)));
        myCardView9.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, sui_gas.class)));
        myCardView10.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, internet_bill.class)));
        myCardView11.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, tracking_package.class)));

        imageButton1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, sim_owner.class)));
        imageButton2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, license.class)));
        imageButton3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, onlinefir.class)));
        imageButton4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ntninquiry.class)));
        imageButton5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, vehicle_verification.class)));
        imageButton6.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, echallan.class)));
        imageButton7.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, passport.class)));
        imageButton8.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, electricity_bill.class)));
        imageButton9.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, sui_gas.class)));
        imageButton10.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, internet_bill.class)));
        imageButton11.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, tracking_package.class)));

        // Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // ---------------------------------------------------------
    // Show Custom Welcome Dialog Only Once
    // ---------------------------------------------------------
    private void showWelcomeDialogIfNeeded() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean dialogShown = prefs.getBoolean(KEY_DIALOG_SHOWN, false);

        if (!dialogShown) {
            View view = getLayoutInflater().inflate(R.layout.custom_dialog, null);
            
            Button btnOk = view.findViewById(R.id.btnOk);
            Button btnCancel = view.findViewById(R.id.btnCancel);

            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setView(view)
                    .setCancelable(false)
                    .create();
            
            if (dialog.getWindow() != null) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }

            btnOk.setOnClickListener(v -> {
                prefs.edit().putBoolean(KEY_DIALOG_SHOWN, true).apply();
                dialog.dismiss();
            });

            btnCancel.setOnClickListener(v -> dialog.dismiss());

            dialog.show();
        }
    }
}
