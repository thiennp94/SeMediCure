package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KgToLbsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kg_to_lbs);

        Button btn_Convert1;
        final EditText input1;
        final TextView output1;

        btn_Convert1= (Button) findViewById(R.id.btn_Convert1);
        input1=(EditText) findViewById(R.id.editText1);
        output1=(TextView) findViewById(R.id.textView1);

        btn_Convert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double convert= Double.parseDouble(input1.getText().toString());
                output1.setText(String.valueOf(convert*2.20462));
                output1.setTextColor(Color.RED);
            }
        });
    }
}