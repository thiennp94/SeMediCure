package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnitConvertActivity extends AppCompatActivity {

    private Button btn_kglb;
    private Button btn_mft;
    private Button btn_cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_convert);

        btn_kglb = (Button) findViewById(R.id.btn_kglb);
        btn_kglb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openKgLb();
            }
        });

        btn_mft = (Button) findViewById(R.id.btn_mft);
        btn_mft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMFT();
            }
        });

        btn_cf = (Button) findViewById(R.id.btn_cf);
        btn_cf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCF();
            }
        });
    }

    public void openKgLb(){
        Intent intent = new Intent(this, KgToLbsActivity.class);
        startActivity(intent);
    }

    public void openMFT(){
        Intent intent = new Intent(this, MToFtActivity.class);
        startActivity(intent);
    }

    public void openCF(){
        Intent intent = new Intent(this, CToFActivity.class);
        startActivity(intent);
    }
}