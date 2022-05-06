package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * The patient profile activity of the app.
 * The entry point/welcome screen > Login > Patient Portal > Patient Profile
 */
public class PatientProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
    }

    /**
     * Starts the patientInfo.
     * @param view
     */
    public void patientInfo(View view) {
        Intent intent = new Intent(this, PatientInfoActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the currentMedication.
     * @param view
     */
    public void currentMedication(View view) {
        Intent intent = new Intent(this, PatientInfoActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the appointmentHistory.
     * @param view
     */
    public void appointmentHistory(View view) {
        Intent intent = new Intent(this, PatientInfoActivity.class);
        startActivity(intent);
    }
}