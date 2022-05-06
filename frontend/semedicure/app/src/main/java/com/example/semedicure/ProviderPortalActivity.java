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

        // Get data from Login screen
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        String city = intent.getStringExtra("city");
        int dateOfBirth = intent.getIntExtra("date_of_birth", 0);
        String lastName = intent.getStringExtra("last_name");
        String firstName = intent.getStringExtra("firstName");
        String middleName = intent.getStringExtra("middle_name");
        String password = intent.getStringExtra("password");
        int phoneNumber = intent.getIntExtra("phone_number", 0);
        int ssn = intent.getIntExtra("ssn", 0);
        String streetAddress = intent.getStringExtra("street_address");
        int zip = intent.getIntExtra("zip", 0);
        String email = intent.getStringExtra("email");
        String specialty = intent.getStringExtra("specialty");
        String state = intent.getStringExtra("state");
        String username = intent.getStringExtra("username");
        String yearOfPractice = intent.getStringExtra("year_of_practice");
        String licenseNumber = intent.getStringExtra("license_num");
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