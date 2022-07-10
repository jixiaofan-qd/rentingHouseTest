package com.example.jixiaofan.rentinghousetest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class DetailedActivity extends AppCompatActivity {

    public static void actionStart(Context context, String houseName, int houseImageId) {
        Intent intent = new Intent(context, DetailedActivity.class);
        intent.putExtra("house_name", houseName);
        intent.putExtra("house_imageId", houseImageId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        String houseName = getIntent().getStringExtra("house_name");
        int houseImageId = getIntent().getIntExtra("house_imageId",0);

        HouseDetailedFragment houseDetailedFragment = (HouseDetailedFragment) getSupportFragmentManager().findFragmentById(R.id.house_detailed_fragement);
        houseDetailedFragment.refresh(houseName, houseImageId);

        Toast.makeText(DetailedActivity.this, houseName , Toast.LENGTH_SHORT).show();
    }


}
