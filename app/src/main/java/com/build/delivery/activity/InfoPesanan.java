package com.build.delivery.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.build.delivery.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class InfoPesanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pesanan);

        FrameLayout back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // get the bottom sheet view
        final LinearLayout llBottomSheet =  findViewById(R.id.pesan);
        //init the bottom sheet behavior
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        //change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        //set the peek height
        bottomSheetBehavior.setPeekHeight(520);
        //set hideable or not
        bottomSheetBehavior.setHideable(false);
        //set callback for changes
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        TextView tvPriceFee = findViewById(R.id.priceFee);
        TextView tvPriceFeeBtm = findViewById(R.id.priceFeeBtm);
        tvPriceFee.setPaintFlags(tvPriceFee.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        tvPriceFeeBtm.setPaintFlags(tvPriceFeeBtm.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        LinearLayout btnpesan = findViewById(R.id.btn_pesan);
        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoPesanan.this, OrderDalamProses.class);
                startActivity(intent);
            }
        });
    }
}