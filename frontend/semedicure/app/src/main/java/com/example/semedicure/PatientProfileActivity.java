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
        Button buttonCreate = findViewById(R.id.buttonUpdate);

        mQueue = Volley.newRequestQueue(this);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
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
                                String email = patient.getString("email");
                                String email = patient.getString("email");
                                String email = patient.getString("email");
                                String email = patient.getString("email");
                                String email = patient.getString("email");
                                String email = patient.getString("email");
                                String email = patient.getString("email");

                                mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
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

//    private void requestJson() {
//        RequestQueue rQueue = Volley.newRequestQueue(this);
//        String url = "https://4c1cb4dc-453e-425d-a7bb-82fec8d336d0.mock.pstmn.io/clients/";
//
//        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Toast.makeText(PatientProfileActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(PatientProfileActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        rQueue.add(jsonRequest);
//
//    }
}