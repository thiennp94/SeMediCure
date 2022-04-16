package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * The check-in activity of the app.
 * The entry point/welcome screen > Login > Admin Portal > Check-in
 */
public class CheckInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
    }
}