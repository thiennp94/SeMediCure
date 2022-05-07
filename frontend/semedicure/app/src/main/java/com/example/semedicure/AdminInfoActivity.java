package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The admin information activity of the app.
 * The entry point/welcome screen > Login > Admin Portal > Admin Info
 */
public class AdminInfoActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_PATTERN = "^\\d{10}$";
    private static final String ADDR_PATTERN = "^\\d.{0,4}?\\s\\w+$";
    private static final String ZIP_PATTERN = "^\\d{5}$";
    private static final String STATE_PATTERN = "^\\[A-Za-z]{2}$";

    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern phonePattern = Pattern.compile(PHONE_PATTERN);
    private static final Pattern addrPattern = Pattern.compile(ADDR_PATTERN);
    private static final Pattern zipPattern = Pattern.compile(ZIP_PATTERN);
    private static final Pattern statePattern = Pattern.compile(STATE_PATTERN);

    private TextView mTextViewAdminFName;
    private TextView mTextViewAdminLName;
    private TextView mTextViewAdminMName;
    private TextView mTextViewDOB;
    private TextView mTextViewSSN;
    private TextView mTextViewPhone;
    private TextView mTextViewEmail;
    private TextView mTextViewAddr;
    private TextView mTextViewCity;
    private TextView mTextViewZip;
    private TextView mTextViewState;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_info);

        mTextViewAdminFName = findViewById(R.id.txtAdminFName);
        mTextViewAdminLName = findViewById(R.id.txtAdminLName);
        mTextViewAdminMName = findViewById(R.id.txtAdminMName);
        mTextViewDOB = findViewById(R.id.txtDOB);
        mTextViewSSN = findViewById(R.id.txtSSN);
        mTextViewPhone = findViewById(R.id.txtPhone);
        mTextViewEmail = findViewById(R.id.txtAdminEmail);
        mTextViewAddr = findViewById(R.id.txtStAddr);
        mTextViewCity = findViewById(R.id.txtCity);
        mTextViewZip = findViewById(R.id.txtZip);
        mTextViewState = findViewById(R.id.txtState);
        mQueue = Volley.newRequestQueue(this);

        // Get data from Admin Portal screen
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");

        try {
            JSONObject json = new JSONObject(data);
            JSONObject jsonArray = json.getJSONObject("userInfo");

            mTextViewEmail.setText(jsonArray.getString("email").toString());
            mTextViewAdminFName.setText(jsonArray.getString("firstName").toString());
            mTextViewAdminLName.setText(jsonArray.getString("lastName").toString());
            mTextViewAdminMName.setText(jsonArray.getString("middleName").toString());
            mTextViewDOB.setText(jsonArray.getString("dateOfBirth").toString());
            mTextViewSSN.setText(jsonArray.getString("ssn").toString());
            mTextViewPhone.setText(jsonArray.getString("phoneNumber").toString());
            mTextViewAddr.setText(jsonArray.getString("streetAddress").toString());
            mTextViewCity.setText(jsonArray.getString("city").toString());
            mTextViewZip.setText(jsonArray.getString("zip").toString());
            mTextViewState.setText(jsonArray.getString("state").toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void createAdminInfo(View view){
//        if(CheckAllFields())
//            jsonParse();
    }

    /**
     * Validate all user inputs.
     */
    private boolean CheckAllFields() {
        if (mTextViewAdminFName.length() == 0) {
            mTextViewAdminFName.setError("This field is required");
            return false;
        }

        if (mTextViewAdminLName.length() == 0) {
            mTextViewAdminLName.setError("This field is required");
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
            mTextViewAddr.setError("Address is required");
            return false;
        }

        if (mTextViewCity.length() == 0) {
            mTextViewCity.setError("City is required");
            return false;
        }

        if (mTextViewZip.length() == 0) {
            mTextViewZip.setError("Zip code is required");
            return false;
        }

        if (mTextViewState.length() == 0) {
            mTextViewState.setError("State is required");
            return false;
        }

        Matcher emailMatcher = emailPattern.matcher(mTextViewEmail.toString());
        Matcher phoneMatcher = phonePattern.matcher(mTextViewPhone.toString());
        Matcher addrMatcher = addrPattern.matcher(mTextViewAddr.toString());
        Matcher zipMatcher = zipPattern.matcher(mTextViewZip.toString());
        Matcher stateMatcher = statePattern.matcher(mTextViewState.toString());

        if (emailMatcher.matches() && phoneMatcher.matches() && addrMatcher.matches()
            && zipMatcher.matches() && stateMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Clear all the data user input on admin info screen.
     * @param view
     */
    public void clearAdminInfo(View view){
        mTextViewAdminFName.setText("");
        mTextViewAdminLName.setText("");
        mTextViewAdminMName.setText("");
        mTextViewDOB.setText("");
        mTextViewSSN.setText("");
        mTextViewPhone.setText("");
        mTextViewEmail.setText("");
        mTextViewAddr.setText("");
        mTextViewCity.setText("");
        mTextViewZip.setText("");
        mTextViewState.setText("");
    }
}