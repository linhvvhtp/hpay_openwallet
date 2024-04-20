package com.hpay.openwallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.content.Intent;
import android.os.Bundle;

public class RootActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        Intent intent = new Intent(this, HPaySDKActivity.class);
        startActivity(intent);
    }
}