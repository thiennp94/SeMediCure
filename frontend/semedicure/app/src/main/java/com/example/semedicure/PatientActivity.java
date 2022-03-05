package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PatientActivity extends AppCompatActivity {

    private TextView patName;
    private TextView patDob;
    private TextView patEmail;
    private TextView patPhoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        patName = findViewById(R.id.patientName);
        patDob = findViewById(R.id.patientDob);
        patEmail = findViewById(R.id.patientEmail);
        patPhoneNum = findViewById(R.id.patientPhoneNum);

        patName.setText("John Doe");
        patDob.setText("12/12/1900");
        patEmail.setText("john.doe@generic.com");
        patPhoneNum.setText("123-456-7890");
    }

    private void requestString() {
        RequestQueue rQueue = Volley.newRequestQueue(this);
        String url = "https://8be4f6a4-40fe-40de-8be1-e9c3df6a16f7.mock.pstmn.io/Object/";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(PatientActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                try {
                    JSONArray patInfoArr = new JSONArray(response);
                    for(int i = 0; i < patInfoArr.length(); i++) {
                         JSONObject jsonObject = patInfoArr.getJSONObject(i);
                         patName.setText(jsonObject.getString("PatientName"));
                         patDob.setText(jsonObject.getString("PatientDob"));
                         patEmail.setText(jsonObject.getString("PatientEmail"));
                         patPhoneNum.setText(jsonObject.getString("PatientPhoneNum"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PatientActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }

        });

        rQueue.add(strRequest);

    }

}