package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProviderPortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_portal);
    }

    public void findPatient(View view) {
        Intent intent = new Intent(this, FindPatientActivity.class);
        startActivity(intent);
    }

    public void orderPrescription(View view) {
        Intent intent = new Intent(this, OrderPrescriptionActivity.class);
        startActivity(intent);
    }

    public void updateProfile(View view) {
        Intent intent = new Intent(this, ProviderInfoActivity.class);
        startActivity(intent);
    }
}