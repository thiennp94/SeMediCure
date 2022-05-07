package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The patient information activity of the app.
 * The entry point/welcome screen > Login > Patient Portal > Patient Profile > Patient Info
 */
public class PatientInfoActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_PATTERN = "^\\d{10}$";
    private static final String ADDR_PATTERN = "^\\d.{0,4}?\\s\\w+$";
    private static final String ZIP_PATTERN = "^\\d{5}$";
    private static final String STATE_PATTERN = "^\\[A-Za-z]{2}$";
    private static final String SSN_PATTERN = "^\\d{10}$";

    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern phonePattern = Pattern.compile(PHONE_PATTERN);
    private static final Pattern addrPattern = Pattern.compile(ADDR_PATTERN);
    private static final Pattern zipPattern = Pattern.compile(ZIP_PATTERN);
    private static final Pattern statePattern = Pattern.compile(STATE_PATTERN);
    private static final Pattern ssnPattern = Pattern.compile(SSN_PATTERN);

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
    private TextView mTextViewHeight;
    private TextView mTextViewPrescriptions;
    private TextView mTextViewWeight;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

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
        mTextViewHeight = findViewById(R.id.txtHeight);
        mTextViewPrescriptions = findViewById(R.id.txtPrescription);
        mTextViewWeight = findViewById(R.id.txtWeight);

        mQueue = Volley.newRequestQueue(this);

        // Get data from Patient Profile screen
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");

        try {
            JSONObject json = new JSONObject(data);
            JSONObject jsonArray = json.getJSONObject("userInfo");

            mTextViewEmail.setText(jsonArray.getString("email").toString());
            mTextViewPatientFName.setText(jsonArray.getString("firstName").toString());
            mTextViewPatientLName.setText(jsonArray.getString("lastName").toString());
            mTextViewPatientMName.setText(jsonArray.getString("middleName").toString());
            mTextViewDOB.setText(jsonArray.getString("dateOfBirth").toString());
            mTextViewSSN.setText(jsonArray.getString("ssn").toString());
            mTextViewPhone.setText(jsonArray.getString("phoneNumber").toString());
            mTextViewAddr.setText(jsonArray.getString("streetAddress").toString());
            mTextViewCity.setText(jsonArray.getString("city").toString());
            mTextViewZip.setText(jsonArray.getString("zip").toString());
            mTextViewState.setText(jsonArray.getString("state").toString());
            mTextViewSSN.setText(jsonArray.getString("ssn").toString());
            mTextViewInsurer.setText(jsonArray.getString("insurerName").toString());
            mTextViewPolicyHolder.setText(jsonArray.getString("policyHolderName").toString());
            mTextViewHeight.setText(jsonArray.getString("height").toString());
            mTextViewWeight.setText(jsonArray.getString("weight").toString());
            mTextViewPrescriptions.setText(jsonArray.getString("prescriptions").toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

//    public void getPatientInfo(View view){
//        jsonParse();
//    }

    public void sendPatientInfo(View view){
        if(CheckAllFields())
            sendString();
    }

    /**
     * Validate all user inputs.
     */
    private boolean CheckAllFields() {
        if (mTextViewPatientFName.length() == 0) {
            mTextViewPatientFName.setError("This field is required");
            return false;
        }

        if (mTextViewPatientLName.length() == 0) {
            mTextViewPatientLName.setError("This field is required");
            return false;
        }

        if (mTextViewDOB.length() == 0) {
            mTextViewDOB.setError("This field is required");
            return false;
        }

        if (mTextViewSSN.length() == 0) {
            mTextViewSSN.setError("This field is required");
            return false;
        }

        if (mTextViewInsurer.length() == 0) {
            mTextViewInsurer.setError("This field is required");
            return false;
        }

        if (mTextViewPolicyHolder.length() == 0) {
            mTextViewPolicyHolder.setError("This field is required");
            return false;
        }

        if (mTextViewPhone.length() == 0) {
            mTextViewPhone.setError("This field is required");
            return false;
        }

        if (mTextViewEmail.length() == 0) {
            mTextViewEmail.setError("Email is required");
            return false;
        }

        if (mTextViewAddr.length() == 0) {
            mTextViewAddr.setError("Email is required");
            return false;
        }

        if (mTextViewCity.length() == 0) {
            mTextViewCity.setError("Email is required");
            return false;
        }

        if (mTextViewZip.length() == 0) {
            mTextViewZip.setError("Email is required");
            return false;
        }

        if (mTextViewState.length() == 0) {
            mTextViewState.setError("Email is required");
            return false;
        }

        Matcher emailMatcher = emailPattern.matcher(mTextViewEmail.getText().toString());
        Matcher phoneMatcher = phonePattern.matcher(mTextViewPhone.getText().toString());
        Matcher addrMatcher = addrPattern.matcher(mTextViewAddr.getText().toString());
        Matcher zipMatcher = zipPattern.matcher(mTextViewZip.getText().toString());
        Matcher stateMatcher = statePattern.matcher(mTextViewState.getText().toString());
        Matcher ssnMatcher = ssnPattern.matcher(mTextViewSSN.getText().toString());

        if (emailMatcher.matches() && phoneMatcher.matches() && addrMatcher.matches()
                && zipMatcher.matches() && stateMatcher.matches() && ssnMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Clear all the data user input on patient info screen.
     * @param view
     */
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
        mTextViewHeight.setText("");
        mTextViewWeight.setText("");
        mTextViewPrescriptions.setText("");
    }

    // POST
    private void sendString() {
        RequestQueue rQueue = Volley.newRequestQueue(this);
        String url = "https://8be4f6a4-40fe-40de-8be1-e9c3df6a16f7.mock.pstmn.io/Object/";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(PatientInfoActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PatientInfoActivity.this, "Error", Toast.LENGTH_SHORT).show();
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
                return params;
            }
        };

        rQueue.add(strRequest);

    }
}