package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Button btn_Convert4;
        final EditText input4;
        final TextView output4;

        btn_Convert4= (Button) findViewById(R.id.btn_Convert4);
        input4=(EditText) findViewById(R.id.editText4);
        output4=(TextView) findViewById(R.id.textView4);

        btn_Convert4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long duration = TimeUnit.MINUTES.toMillis(Integer.parseInt(input4.getText().toString()));

                new CountDownTimer(duration, 1000){
                    @Override
                    public void onTick(long l) {
                        String sDuration = String.format(Locale.ENGLISH, "%02d : %02d",
                                TimeUnit.MILLISECONDS.toMinutes(l),
                                TimeUnit.MILLISECONDS.toSeconds(l)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                        output4.setText(sDuration.toString());
                    }

                    @Override
                    public void onFinish() {
                        output4.setText("Done!");
                        output4. setTextColor(Color.RED);
                    }
                }.start();
            }
        });
    }
}