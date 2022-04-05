package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class ScheduleApptActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private static final String TAG = "tag";
    private CalendarView calendar;
    private long selectedDate;
    private Button timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appt);

        calendar = findViewById(R.id.calendarView);
        timeButton = findViewById(R.id.button8);
    }
    public void selectTime(View view) {
        SelectTimeDialogFragment dialog = new SelectTimeDialogFragment();
        dialog.show(getSupportFragmentManager(), "select time dialog");
    }
    public void submitAppointment(View view) {
        SubmitApptDialogFragment dialog = new SubmitApptDialogFragment();
        dialog.show(getSupportFragmentManager(), "submit dialog");
    }
    @Override
    public void onTimeSet(TimePicker timePicker, int selHr, int selMin) {
        timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", selHr, selMin));
    }
}