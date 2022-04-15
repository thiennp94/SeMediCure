package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The main activity of the app. The entry point/welcome screen.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts the LoginActivity.
     * @param view
     */
    public void returningUser(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the SelectUserActivity.
     * @param view
     */
    public void registerUser(View view) {
        Intent intent = new Intent(this, SelectUserActivity.class);
        startActivity(intent);
    }
}