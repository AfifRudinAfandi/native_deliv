package com.build.delivery.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.build.delivery.R;
import com.bumptech.glide.Glide;

public class DetailMerchants extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_merchants);

        getIncomingIntent();

        FrameLayout btnBack = findViewById(R.id.back_detail_outlate);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("rating")){

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String ratingCount = getIntent().getStringExtra("rating");

            setImage(imageUrl, imageName, ratingCount);
        }
    }


    private void setImage(String imageUrl, String imageName, String ratingCount){

        TextView name = findViewById(R.id.image_description_outlate);
        name.setText(imageName);
        TextView rating = findViewById(R.id.detail_rating);
        rating.setText(ratingCount);

        ImageView image = findViewById(R.id.image_detail_outlate);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}