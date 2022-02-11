package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MToFtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mto_ft);

        Button btn_Convert2;
        final EditText input2;
        final TextView output2;

        btn_Convert2= (Button) findViewById(R.id.btn_Convert2);
        input2=(EditText) findViewById(R.id.editText2);
        output2=(TextView) findViewById(R.id.textView2);

        btn_Convert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double convert= Double.parseDouble(input2.getText().toString());
                output2.setText(String.valueOf(convert*3.28084));
                output2.setTextColor(Color.RED);
            }
        });
    }
}