package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * The admin portal activity of the app.
 * The entry point/welcome screen > Login > Admin Portal
 */
public class AdminPortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_portal);
    }

    /**
     * Starts the ApproveApptActivity.
     * @param view
     */
    public void approveAppointment(View view) {
        Intent intent = new Intent(this, ApproveApptActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the CheckInActivity.
     * @param view
     */
    public void checkIn(View view) {
        Intent intent = new Intent(this, CheckInActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the AdminInfoActivity.
     * @param view
     */
    public void updateProfile(View view) {
        Intent intent = new Intent(this, AdminInfoActivity.class);
        startActivity(intent);
    }
}