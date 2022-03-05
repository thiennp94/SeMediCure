package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class PatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        TextView patName = findViewById(R.id.patientName);
        TextView patDob = findViewById(R.id.patientDob);
        TextView patEmail = findViewById(R.id.patientEmail);
        TextView patPhoneNum = findViewById(R.id.patientPhoneNum);

        patName.setText("John Doe");
        patDob.setText("12/12/1900");
        patEmail.setText("john.doe@generic.com");
        patPhoneNum.setText("123-456-7890");
    }

}