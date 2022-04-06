package com.example.semedicure;

import androidx.annotation.NonNull;
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
    private int selYear;
    private int selMonth;
    private int selDay;
    private Button timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appt);

        calendar = findViewById(R.id.calendarView);
        timeButton = findViewById(R.id.button8);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                selYear = year;
                selMonth = month;
                selDay = day;
            }
        });
    }
    public void selectTime(View view) {
        SelectTimeDialogFragment dialog = new SelectTimeDialogFragment();
        dialog.show(getSupportFragmentManager(), "select time dialog");
    }
    public void submitAppointment(View view) {
        SubmitApptDialogFragment dialog = new SubmitApptDialogFragment();
        Bundle dateBundle = new Bundle();
        dateBundle.putString("APPTDATE", selMonth + "/" + selDay + "/" + selYear);
        dialog.setArguments(dateBundle);
        dialog.show(getSupportFragmentManager(), "submit dialog");
    }
    @Override
    public void onTimeSet(TimePicker timePicker, int selHr, int selMin) {
        timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", selHr, selMin));
    }
}