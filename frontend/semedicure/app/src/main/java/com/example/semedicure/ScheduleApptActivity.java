package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class ScheduleApptActivity extends AppCompatActivity {

    private CalendarView calendar;
    private Button timeButton;
    private int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appt);

        calendar = findViewById(R.id.calendarView);
        timeButton = findViewById((R.id.button8));
    }
    public void selectTime(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selHr, int selMin) {
                hour = selHr;
                minute = selMin;
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", selHr, selMin));
            }
        };
        int style = AlertDialog.THEME_HOLO_LIGHT;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, false);
        timePickerDialog.show();
    }
}