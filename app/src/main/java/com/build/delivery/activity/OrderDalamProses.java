package com.build.delivery.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.build.delivery.R;

public class OrderDalamProses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_dalam_proses);

        final ConstraintLayout layout_1 = findViewById(R.id.step1);
        final ConstraintLayout layout_2 = findViewById(R.id.step2);
        final CoordinatorLayout layout_3 = findViewById(R.id.step3);
        LinearLayout btn_wa_me = findViewById(R.id.btn_wa_me);
        LinearLayout konfirmasi = findViewById(R.id.btn_konfirmasi_sampai);
        btn_wa_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_1.setVisibility(View.GONE);
                layout_2.setVisibility(View.VISIBLE);
            }
        });
        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_2.setVisibility(View.GONE);
                layout_3.setVisibility(View.VISIBLE);
            }
        });
    }
}