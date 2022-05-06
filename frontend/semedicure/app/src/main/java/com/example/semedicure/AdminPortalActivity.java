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

        // Get data from Login screen
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        String city = intent.getStringExtra("city");
        int dateOfBirth = intent.getIntExtra("date_of_birth", 0);
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("last_name");
        String middleName = intent.getStringExtra("middle_name");
        String password = intent.getStringExtra("password");
        int phoneNumber = intent.getIntExtra("phone_number", 0);
        int ssn = intent.getIntExtra("ssn", 0);
        String streetAddress = intent.getStringExtra("street_address");
        int zip = intent.getIntExtra("zip", 0);
        String email = intent.getStringExtra("email");
        String state = intent.getStringExtra("state");
        String username = intent.getStringExtra("username");
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