package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminPortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_portal);
    }

    public void approveAppointment(View view) {
        Intent intent = new Intent(this, ApproveApptActivity.class);
        startActivity(intent);
    }

    public void checkIn(View view) {
        Intent intent = new Intent(this, CheckInActivity.class);
        startActivity(intent);
    }

    public void updateProfile(View view) {
        Intent intent = new Intent(this, AdminInfoActivity.class);
        startActivity(intent);
    }
}