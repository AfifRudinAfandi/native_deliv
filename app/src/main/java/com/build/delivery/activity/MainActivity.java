package com.build.delivery.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.build.delivery.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kelin.translucentbar.library.TranslucentBarManager;

public class MainActivity extends AppCompatActivity {
    private String tokenJwt;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String tokenJWT = "tokenKey";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(tokenJWT)) {
            Toast.makeText(this, ""+sharedpreferences.getString(tokenJWT,""), Toast.LENGTH_SHORT).show();
        }
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);


        TranslucentBarManager translucentBarManager = new TranslucentBarManager(this);
        translucentBarManager.transparent(this);

    }

//    @Override
//    protected void onStart() {
//        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetDialogTheme);
//        View bottomSheedView = LayoutInflater.from(getApplicationContext()).inflate
//                (R.layout.fragment_alert_emty_data,(LinearLayout)findViewById(R.id.container_bottom_sheet)
//        );
//                bottomSheetDialog.setContentView(bottomSheedView);
//                bottomSheetDialog.show();
//
//        super.onStart();
//    }
}

