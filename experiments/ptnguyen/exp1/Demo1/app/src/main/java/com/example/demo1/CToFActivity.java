package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CToFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cto_factivity);

        Button btn_Convert3;
        final EditText input3;
        final TextView output3;

        btn_Convert3= (Button) findViewById(R.id.btn_Convert3);
        input3=(EditText) findViewById(R.id.editText3);
        output3=(TextView) findViewById(R.id.textView3);

        btn_Convert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double convert= Double.parseDouble(input3.getText().toString());
                output3.setText(String.valueOf(convert*9/5+32));
                output3.setTextColor(Color.RED);
            }
        });
    }
}