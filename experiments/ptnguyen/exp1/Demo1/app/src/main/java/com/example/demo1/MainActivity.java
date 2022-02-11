package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_about;
    private Button btn_help;
    private Button btn_unit;
    private Button btn_calc;
    private Button btn_cldr;
    private Button btn_wth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_about = (Button) findViewById(R.id.btn_about);
        btn_about.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });

        btn_help = (Button) findViewById(R.id.btn_help);
        btn_help.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openHelp();
            }
        });

        btn_unit = (Button) findViewById(R.id.btn_unit);
        btn_unit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openUnitConverter();
            }
        });

        btn_calc = (Button) findViewById(R.id.btn_calc);
        btn_calc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCalculator();
            }
        });

        btn_cldr = (Button) findViewById(R.id.btn_cldr);
        btn_cldr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCalendar();
            }
        });

        btn_wth = (Button) findViewById(R.id.btn_wth);
        btn_wth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openWeather();
            }
        });
    }

    public void openAbout(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void openHelp(){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void openUnitConverter(){
        Intent intent = new Intent(this, UnitConvertActivity.class);
        startActivity(intent);
    }

    public void openCalculator(){
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }

    public void openCalendar(){
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void openWeather(){
        Intent intent = new Intent(this, WeatherActivity.class);
        startActivity(intent);
    }
}