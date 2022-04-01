package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);
    }

    public void patientProfile(View view) {
        Intent intent = new Intent(this, PatientProfileActivity.class);
        startActivity(intent);
    }

    public void adminProfile(View view) {
        Intent intent = new Intent(this, AdminProfileActivity.class);
        startActivity(intent);
    }

    public void clinicProfile(View view) {
        Intent intent = new Intent(this, ProviderProfileActivity.class);
        startActivity(intent);
    }
}