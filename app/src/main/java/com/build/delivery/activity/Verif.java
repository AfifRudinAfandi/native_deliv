package com.build.delivery.activity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.build.delivery.R;
import com.build.delivery.conn.RestClient;
import com.build.delivery.pojoauth.AuthBody;
import com.build.delivery.pojoauth.AuthResponse;
import com.poovam.pinedittextfield.PinField;
import com.poovam.pinedittextfield.SquarePinField;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Verif extends AppCompatActivity {
    String strPhoneNumber,strOtpNumber;
    TextView textPhoneNumber;
    SharedPreferences sharedpreferences;
    private BroadcastReceiver broadcastReceiver = null;
    private TextView otp;
    final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS = 12903;
    SquarePinField squarePinField;
    public static final String mypreference = "mypref";
    public static final String tokenJWT = "tokenKey";

    @Override
    protected void onResume() {
        super.onResume();
        if (broadcastReceiver == null) {
            broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Bundle bundle = intent.getExtras();
                    readLatestSms(bundle);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
            this.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verif);
        strPhoneNumber=getIntent().getStringExtra("phoneNumber");
        strOtpNumber=getIntent().getStringExtra("otpNumber");
        Toast.makeText(this, "OTP Anda: "+strOtpNumber, Toast.LENGTH_SHORT).show();
        textPhoneNumber=findViewById(R.id.textPhoneNumber);
        textPhoneNumber.setText(strPhoneNumber);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        requestPermission();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        FrameLayout btnBack = findViewById(R.id.btn_back_verif);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        squarePinField = findViewById(R.id.squareField);
        squarePinField.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {
            @Override
            public boolean onTextComplete(@NotNull String s) {
                AuthBody authBody=new AuthBody();
                authBody.setOtp(s);
                authBody.setPhone("0"+strPhoneNumber);
                RestClient.getService().postAuth(authBody).enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(tokenJWT, response.body().getData());
                        editor.commit();
                        startActivity(new Intent(Verif.this,MainActivity.class));
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {

                    }
                });
                return false;
            }
        });
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECEIVE_SMS},
                    MY_PERMISSIONS_REQUEST_RECEIVE_SMS);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RECEIVE_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this.getApplicationContext(), "Permission granted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this.getApplicationContext(), "Permission denied!", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void readLatestSms(Bundle bundle) {
        Object[] message = (Object[]) bundle.get("pdus");
        String smsBody = "";
        String address = "";
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < message.length; i++) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) message[i]);
            smsBody = smsMessage.getMessageBody().toString();
            address = smsMessage.getOriginatingAddress();
            squarePinField.setText(smsBody);
            Toast.makeText(this, ""+smsBody, Toast.LENGTH_SHORT).show();
        }
        if (broadcastReceiver != null) {
            this.unregisterReceiver(broadcastReceiver);
        }
    }
}