package com.app2m.demo.network;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app2m.demo.network.module.OkHttpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openOkHttpActivity(View view) {
        startActivity(new Intent(this, OkHttpActivity.class));
    }
}
