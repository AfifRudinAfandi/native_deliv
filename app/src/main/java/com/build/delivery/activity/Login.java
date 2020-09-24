package com.build.delivery.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.build.delivery.R;
import com.build.delivery.conn.RestClient;
import com.build.delivery.pojophone.PhoneBody;
import com.build.delivery.pojophone.PhoneResponse;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity{
    EditText phoneNumber;
    Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //cari editText yang memiliki id phoneNumber
        phoneNumber=findViewById(R.id.phoneNumber);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        Button next_btn = findViewById(R.id.btn_next);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validasi untuk input dari user, akan mengecek jumlah inputan yang dilakukan oleh user, minimal 10 maksimal 13
                if(phoneNumber.getText().toString().trim().isEmpty()){
                    Snackbar.make(view,"Nomor HP Tidak Boleh Kosong",Snackbar.LENGTH_LONG).show();
                }else if(phoneNumber.getText().toString().length()<10){
                    Snackbar.make(view,"Nomor HP Harus Lebih Dari 10 Digit",Snackbar.LENGTH_LONG).show();
                }else {
                    PhoneBody phoneBody=new PhoneBody();
                    phoneBody.setPhone("0"+phoneNumber.getText().toString());
                    RestClient.getService().postLogin(phoneBody).enqueue(new Callback<PhoneResponse>() {
                        @Override
                        public void onResponse(Call<PhoneResponse> call, Response<PhoneResponse> response) {
                            //jika semua validasi sukses maka akan pindah screen ke OTP verifikasi
                            Intent intent = new Intent(Login.this, Verif.class);
                            intent.putExtra("phoneNumber",phoneNumber.getText().toString());
                            intent.putExtra("otpNumber",response.body().getData().getOtp());
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<PhoneResponse> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}