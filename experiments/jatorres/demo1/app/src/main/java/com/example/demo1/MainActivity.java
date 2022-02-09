package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);
    }

    public void startPlayer(View view) {
        startActivity(new Intent(this, MusicPlayer.class));
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        Intent musicIntent = new Intent(this, MusicPlayer.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK) {
                TextView textView2 = findViewById(R.id.textView2);
                String returnMsg = data.getStringExtra("return");
                textView2.setText(returnMsg);
            }
        }
    }
}