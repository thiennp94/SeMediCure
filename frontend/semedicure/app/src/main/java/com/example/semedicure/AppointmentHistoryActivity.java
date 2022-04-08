package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AppointmentHistoryActivity extends AppCompatActivity {

    private TextView appointment1;
    private TextView appointment2;
    private TextView appointment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_history);

        appointment1 = (TextView) findViewById(R.id.textView12);
        appointment2 = (TextView) findViewById(R.id.textView14);
        appointment3 = (TextView) findViewById(R.id.textView16);
    }

    public void appointmentDetails(View view) {
        ApptHistoryDialogFragment dialog = new ApptHistoryDialogFragment();
        dialog.show(getSupportFragmentManager(), "details dialog");
    }

    public void fetchAppointments(View view) {
        requestJsonObject();
    }

    public void clearAppointments(View view) {
        appointment1.setText("");
        appointment2.setText("");
        appointment3.setText("");
    }

    private void requestJsonObject() {
        RequestQueue rQueue = Volley.newRequestQueue(this);
        String url = "https://8be4f6a4-40fe-40de-8be1-e9c3df6a16f7.mock.pstmn.io/Object/";

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("appointments");
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String appt1 = jsonObject.getString("appoint1");
                        String appt2 = jsonObject.getString("appoint2");
                        String appt3 = jsonObject.getString("appoint3");
                        appointment1.setText(appt1);
                        appointment2.setText(appt2);
                        appointment3.setText(appt3);
                        Toast.makeText(AppointmentHistoryActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AppointmentHistoryActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        rQueue.add(jsonRequest);

    }
}