package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The patient portal activity of the app.
 * The entry point/welcome screen > Login > Patient Portal
 */
public class PatientPortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_portal);
    }

    /**
     * Starts the ScheduleApptActivity.
     * @param view
     */
    public void requestAppointment(View view) {
        Intent intent = new Intent(this, ScheduleApptActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the GenerateCodeActivity.
     * @param view
     */
    public void scanQRCode(View view) {
        Intent intent = new Intent(this, ScheduleApptActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the PatientProfileActivity.
     * @param view
     */
    public void updateMedicalHistory(View view) {
        Intent intent = new Intent(this, PatientProfileActivity.class);
        String intent1 = getIntent().getStringExtra("data").toString();
        intent.putExtra("data", intent1);
        startActivity(intent);
    }

    public void msg(View view) {
        Intent intent = new Intent(this, WebSocketActivity.class);
        startActivity(intent);
    }
}