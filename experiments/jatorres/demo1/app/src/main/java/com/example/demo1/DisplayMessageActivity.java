package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }
    public void sendMessage(View view) {
        Intent returnIntent = new Intent();
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String returnMsg = editText.getText().toString();
        returnIntent.putExtra("return", returnMsg);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}