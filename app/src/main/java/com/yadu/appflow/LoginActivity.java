package com.yadu.appflow;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;

    //temp---------
    private static final int PERMISSION_CALLBACK_CONSTANT = 100;
    private static final int REQUEST_PERMISSION_SETTING = 101;
    String[] permissionsRequired = new String[]{Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    private SharedPreferences permissionStatus;
    private boolean sentToSettings = false;

    //-------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_screen);

        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);

        //temp------
        permissionStatus = getSharedPreferences("permissionStatus",MODE_PRIVATE);
        //-----------
        
     /*   Glide.with(LoginActivity.this).load(R.drawable.city_bg)
                .apply(bitmapTransform(new BlurTransformation(5)))
                .into((ImageView) findViewById(R.id.img_parent));*/
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){

            case R.id.btn_login:

              Intent in = new Intent(getApplicationContext(), OneQADActivity.class);

                startActivity(in);

                break;
        }
    }

}
