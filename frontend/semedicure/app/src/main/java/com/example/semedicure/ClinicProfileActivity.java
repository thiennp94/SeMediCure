package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClinicProfileActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_clinic_profile);

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
        mQueue = Volley.newRequestQueue(this);
    }

    public void clinicInfo(View view){
        jsonParse();
    }

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

    public void clearClinicInfo(View view){
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

}