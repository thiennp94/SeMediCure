package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mult;
    private Button div;
    private Button clear;
    private Button result;
    private TextView txt_input;
    private TextView txt_result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char DIVISION = '/';
    private final char MULTIPLICATION = '*';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setupUIView();

        zero.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"0");
            }
        });

        one.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"1");
            }
        });

        two.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"2");
            }
        });

        three.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"3");
            }
        });

        four.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"4");
            }
        });

        five.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"5");
            }
        });

        six.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"6");
            }
        });

        seven.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"7");
            }
        });

        eight.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"8");
            }
        });

        nine.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txt_input.setText(txt_input.getText()+"9");
            }
        });

        add.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                compute();
                ACTION = ADDITION;
                txt_result.setText(String.valueOf(val1) + "+");
                txt_input.setText(null);
            }
        });

        sub.setOnClickListener (new View.OnClickListener() {
            public void onClick (View v) {
                compute();
                ACTION = SUBTRACTION;
                txt_result.setText(String.valueOf(val1) + "-");
                txt_input.setText(null);
            }
        });

        mult.setOnClickListener (new View.OnClickListener() {
            public void onClick (View v) {
                compute();
                ACTION = MULTIPLICATION;
                txt_result.setText(String.valueOf(val1) + "*");
                txt_input.setText(null);
            }
        });

        div.setOnClickListener (new View.OnClickListener() {
            public void onClick (View v) {
                compute();
                ACTION = DIVISION;
                txt_result.setText(String.valueOf(val1) + "/");
                txt_input.setText(null);
            }
        });
    }

    private void setupUIView() {
        zero = (Button) findViewById(R.id.btn_0);
        one = (Button) findViewById(R.id.btn_1);
        two = (Button) findViewById(R.id.btn_2);
        three = (Button) findViewById(R.id.btn_3);
        four = (Button) findViewById(R.id.btn_4);
        five = (Button) findViewById(R.id.btn_5);
        six = (Button) findViewById(R.id.btn_6);
        seven = (Button) findViewById(R.id.btn_7);
        eight = (Button) findViewById(R.id.btn_8);
        nine = (Button) findViewById(R.id.btn_9);
        add = (Button) findViewById(R.id.btn_add);
        sub = (Button) findViewById(R.id.btn_sub);
        mult = (Button) findViewById(R.id.btn_mult);
        div = (Button) findViewById(R.id.btn_div);
        clear = (Button) findViewById(R.id.btn_clr);
        result = (Button) findViewById(R.id.btn_result);
        txt_input = (TextView) findViewById(R.id.txtInput);
        txt_result = (TextView) findViewById(R.id.txtResult);
    }

    private void compute() {
        if (!Double.isNaN(val1)){
            val2 = Double.parseDouble(txt_input.getText().toString());

            switch(ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(txt_input.getText().toString());
        }
    }
}