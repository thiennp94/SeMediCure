package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class PatientProfileActivity extends AppCompatActivity {

    private TextView mTextViewPatientFName;
    private TextView mTextViewPatientMName;
    private TextView mTextViewPatientLName;
    private TextView mTextViewPhone;
    private TextView mTextViewEmail;
    private TextView mTextViewDOB;
    private TextView mTextViewAddr;
    private TextView mTextViewCity;
    private TextView mTextViewZip;
    private TextView mTextViewState;
    private TextView mTextViewSSN;
    private TextView mTextViewInsurer;
    private TextView mTextViewPolicyHolder;
    private TextView mTextViewGroupNum;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        mTextViewPatientFName = findViewById(R.id.txtPatientFName);
        mTextViewPatientMName = findViewById(R.id.txtPatientMName);
        mTextViewPatientLName = findViewById(R.id.txtPatientLName);
        mTextViewPhone = findViewById(R.id.txtPhone);
        mTextViewEmail = findViewById(R.id.txtPatientEmail);
        mTextViewDOB = findViewById(R.id.txtDOB);
        mTextViewAddr = findViewById(R.id.txtStAddr);
        mTextViewCity = findViewById(R.id.txtCity);
        mTextViewZip = findViewById(R.id.txtZip);
        mTextViewState = findViewById(R.id.txtState);
        mTextViewSSN = findViewById(R.id.txtSSN);
        mTextViewInsurer = findViewById(R.id.txtInsurer);
        mTextViewPolicyHolder = findViewById(R.id.txtPolicyHolder);
        mTextViewGroupNum = findViewById(R.id.txtGroupNum);
//        Button buttonCreate = findViewById(R.id.buttonUpdate);

        mQueue = Volley.newRequestQueue(this);

//        buttonCreate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                jsonParse();
//            }
//        });
    }

    public void getPatientInfo(View view){
        jsonParse();
    }

    public void sendPatientInfo(View view){
        sendString();
    }

    // GET
    private void jsonParse() {

        String url = "https://4c1cb4dc-453e-425d-a7bb-82fec8d336d0.mock.pstmn.io/clients/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("patients");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject patient = jsonArray.getJSONObject(i);

                                String firstName = patient.getString("firstname");
                                String middleName = patient.getString("middlename");
                                String lastName = patient.getString("lastname");
                                String phone = patient.getString("phone");
                                String email = patient.getString("email");
                                String dob = patient.getString("dob");
                                String address = patient.getString("address");
                                String city = patient.getString("city");
                                String state = patient.getString("state");
                                String zip = patient.getString("zip");
                                String ssn = patient.getString("ssn");
                                String insurer = patient.getString("insurer");
                                String policyholder = patient.getString("policyholder");
                                String group = patient.getString("group");

                                mTextViewPatientFName.setText(firstName);
                                mTextViewPatientMName.setText(middleName);
                                mTextViewPatientLName.setText(lastName);
                                mTextViewPhone.setText(phone);
                                mTextViewEmail.setText(email);
                                mTextViewDOB.setText(dob);
                                mTextViewAddr.setText(address);
                                mTextViewCity.setText(city);
                                mTextViewZip.setText(zip);
                                mTextViewState.setText(state);
                                mTextViewSSN.setText(ssn);
                                mTextViewInsurer.setText(insurer);
                                mTextViewPolicyHolder.setText(policyholder);
                                mTextViewGroupNum.setText(group);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    public void clearPatientInfo(View view){
        mTextViewPatientFName.setText("");
        mTextViewPatientMName.setText("");
        mTextViewPatientLName.setText("");
        mTextViewPhone.setText("");
        mTextViewEmail.setText("");
        mTextViewDOB.setText("");
        mTextViewAddr.setText("");
        mTextViewCity.setText("");
        mTextViewZip.setText("");
        mTextViewState.setText("");
        mTextViewSSN.setText("");
        mTextViewInsurer.setText("");
        mTextViewPolicyHolder.setText("");
        mTextViewGroupNum.setText("");
    }

    // POST
    private void sendString() {
        RequestQueue rQueue = Volley.newRequestQueue(this);
        String url = "https://8be4f6a4-40fe-40de-8be1-e9c3df6a16f7.mock.pstmn.io/Object/";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(PatientProfileActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PatientProfileActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

        }) {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("firstname", mTextViewPatientFName.getText().toString());
                params.put("middlename", mTextViewPatientMName.getText().toString());
                params.put("last", mTextViewPatientLName.getText().toString());
                params.put("phone", mTextViewPhone.getText().toString());
                params.put("email", mTextViewEmail.getText().toString());
                params.put("dob", mTextViewDOB.getText().toString());
                params.put("address", mTextViewAddr.getText().toString());
                params.put("city", mTextViewCity.getText().toString());
                params.put("zip", mTextViewZip.getText().toString());
                params.put("state", mTextViewState.getText().toString());
                params.put("ssn", mTextViewSSN.getText().toString());
                params.put("insurer", mTextViewInsurer.getText().toString());
                params.put("policyholder", mTextViewPolicyHolder.getText().toString());
                params.put("group", mTextViewGroupNum.getText().toString());
                return params;
            }
        };

        rQueue.add(strRequest);

    }
}