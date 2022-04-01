package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PatientProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
    }

    public void patientInfo(View view) {
        Intent intent = new Intent(this, PatientInfoActivity.class);
        startActivity(intent);
    }

    public void currentMedication(View view) {
        Intent intent = new Intent(this, PatientInfoActivity.class);
        startActivity(intent);
    }

    public void appointmentHistory(View view) {
        Intent intent = new Intent(this, PatientInfoActivity.class);
        startActivity(intent);
    }
}