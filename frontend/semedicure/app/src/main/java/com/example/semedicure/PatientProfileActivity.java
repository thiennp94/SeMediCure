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

        // Get data from Patient Portal screen
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        String city = intent.getStringExtra("city");
        int dateOfBirth = intent.getIntExtra("date_of_birth", 0);
        String email = intent.getStringExtra("email");
        String firstName = intent.getStringExtra("firstName");
        int height = intent.getIntExtra("height", 0);
        String insurerName = intent.getStringExtra("insurer_name");
        String lastName = intent.getStringExtra("last_name");
        String middleName = intent.getStringExtra("middle_name");
        String password = intent.getStringExtra("password");
        int phoneNumber = intent.getIntExtra("phone_number", 0);
        String policyHolderName = intent.getStringExtra("policy_holder_name");
        String prescriptions = intent.getStringExtra("prescription");
        int ssn = intent.getIntExtra("ssn", 0);
        String state = intent.getStringExtra("state");
        String streetAddress = intent.getStringExtra("street_address");
        String username = intent.getStringExtra("username");
        int weight = intent.getIntExtra("weight", 0);
        int zip = intent.getIntExtra("zip", 0);
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

    public void msg(View view) {
        Intent intent = new Intent(this, WebSocketActivity.class);
        startActivity(intent);
    }
}