package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PatientPortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_portal);
    }

    public void requestAppointment(View view) {
        Intent intent = new Intent(this, ScheduleApptActivity.class);
        startActivity(intent);
    }

    public void scanQRCode(View view) {
        Intent intent = new Intent(this, ScheduleApptActivity.class);
        startActivity(intent);
    }

    public void updateMedicalHistory(View view) {
        Intent intent = new Intent(this, PatientProfileActivity.class);
        startActivity(intent);
    }
}