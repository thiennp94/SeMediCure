package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    private static final String EMAIL_PATTERN =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String PHONE_PATTERN = "^\\d{10}$";
    private static final String ADDR_PATTERN = "^\\d.{0,4}?\\s\\w+$";
    private static final String ZIP_PATTERN = "^\\d{5}$";
    private static final String STATE_PATTERN = "^\\[A-Za-z]{2}$";

    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern phonePattern = Pattern.compile(PHONE_PATTERN);
    private static final Pattern addrPattern = Pattern.compile(ADDR_PATTERN);
    private static final Pattern zipPattern = Pattern.compile(ZIP_PATTERN);
    private static final Pattern statePattern = Pattern.compile(STATE_PATTERN);

    private TextView mTextViewAdminName;
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

        mTextViewAdminName = findViewById(R.id.txtAdminName);
        mTextViewPhone = findViewById(R.id.txtPhone);
        mTextViewEmail = findViewById(R.id.txtAdminEmail);
        mTextViewAddr = findViewById(R.id.txtStAddr);
        mTextViewCity = findViewById(R.id.txtCity);
        mTextViewZip = findViewById(R.id.txtZip);
        mTextViewState = findViewById(R.id.txtState);
        mQueue = Volley.newRequestQueue(this);
    }

    public void createAdminInfo(View view){
        if(CheckAllFields())
            jsonParse();
    }

    /**
     * Validate all user inputs.
     */
    private boolean CheckAllFields() {
        if (mTextViewAdminName.length() == 0) {
            mTextViewAdminName.setError("This field is required");
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
     * Parse JSON object data into screen fields.
     */
    private void jsonParse() {

        String url = "https://4c1cb4dc-453e-425d-a7bb-82fec8d336d0.mock.pstmn.io/clients/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Admins");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject Admin = jsonArray.getJSONObject(i);

                                String AdminName = Admin.getString("adminname");
                                String phone = Admin.getString("phone");
                                String email = Admin.getString("email");
                                String dob = Admin.getString("dob");
                                String address = Admin.getString("address");
                                String city = Admin.getString("city");
                                String state = Admin.getString("state");
                                String zip = Admin.getString("zip");

                                mTextViewAdminName.setText(AdminName);
                                mTextViewPhone.setText(phone);
                                mTextViewEmail.setText(email);
                                mTextViewAddr.setText(address);
                                mTextViewCity.setText(city);
                                mTextViewZip.setText(zip);
                                mTextViewState.setText(state);
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

    /**
     * Clear all the data user input on admin info screen.
     * @param view
     */
    public void clearAdminInfo(View view){
        mTextViewAdminName.setText("");
        mTextViewPhone.setText("");
        mTextViewEmail.setText("");
        mTextViewAddr.setText("");
        mTextViewCity.setText("");
        mTextViewZip.setText("");
        mTextViewState.setText("");
    }
}