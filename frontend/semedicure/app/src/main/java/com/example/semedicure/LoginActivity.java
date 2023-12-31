package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Acts as the view for the login screen.
 */
public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // digit + lowercase char + uppercase char + punctuation + symbol
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@(.+)$";

    private static final Pattern passwdPattern = Pattern.compile(PASSWORD_PATTERN);
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

    private EditText email;
    private EditText password;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName2);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.login_dropdown, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    /**
     * Sends an HTTP string request to the server sending email and username as parameters.
     */
    private void requestString() {
        RequestQueue rQueue = Volley.newRequestQueue(this);

        String num1 = email.getText().toString();
        String num2 = password.getText().toString();
        String num3 = user;

        String uri = String.format("http://coms-309-024.class.las.iastate.edu:8080/login?email=%1$s&password=%2$s&user=%3$s",
                num1,
                num2,
                num3);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri, new Response.Listener<String>() {
            /**
             * Displays a toast on-screen confirming a successful response from the server.
             * @param response String response from the server.
             */
            @Override
            public void onResponse(String response) {
                if(user.equals("patient")) {
                    Intent intent = new Intent(getApplicationContext(), PatientPortalActivity.class);
                    intent.putExtra("data", response);
                    startActivity(intent);
                }
                else if(user.equals("doctor")) {
                    Intent intent = new Intent(getApplicationContext(), ProviderPortalActivity.class);
                    intent.putExtra("data", response);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), AdminPortalActivity.class);
                    intent.putExtra("data", response);
                    startActivity(intent);
                }
                Log.i("response", response.toString());
            }
        }, new Response.ErrorListener() {
            /**
             * Displays a toast on-screen indicating an unsuccessful response from the server.
             * @param error Error indicating unsuccessful response from the server.
             */
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                Log.i("err", error.toString());
            }

        }) {
            /**
             * Stores email and password in a hashmap to be used as parameters for the HTTP request.
             * @return Hashmap containing the email and password.
             * @throws AuthFailureError
             */
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email.getText().toString());
                params.put("password", password.getText().toString());
                params.put("user", user);
                return params;
            }
        };

        rQueue.add(stringRequest);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(i) {
            case 0:
                user = "patient";
                break;
            case 1:
                user = "doctor";
                break;
            case 2:
                user = "admin";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * Validate all user inputs.
     */
    private boolean CheckAllFields() {
        if (email.length() == 0) {
            email.setError("Email is required");
            return false;
        }

        if (password.length() == 0) {
            password.setError("Password is required");
            return false;
        }

        Matcher passwdMatcher = passwdPattern.matcher(password.getText().toString());
        Matcher emailMatcher = emailPattern.matcher(email.getText().toString());

        if (passwdMatcher.matches() && emailMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param view
     */
    public void login(View view){
        if(CheckAllFields()) {
                requestString();
        } else {
            //Toast.makeText(LoginActivity.this, "Please enter a valid response", Toast.LENGTH_LONG).show();
        }

        if(email.getText().toString().equals("patient1") && password.getText().toString().equals("patient1")) {
            Intent intent = new Intent(this, PatientPortalActivity.class);
            startActivity(intent);
        }
        if(email.getText().toString().equals("doctor1") && password.getText().toString().equals("doctor1")) {
            Intent intent = new Intent(this, ProviderPortalActivity.class);
            startActivity(intent);
        }
        if(email.getText().toString().equals("admin1") && password.getText().toString().equals("admin1")) {
            Intent intent = new Intent(this, AdminPortalActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Starts the ForgotPassActivity
     * @param view The view associated with this activity.
     */
    public void forgotPassword(View view){
        Intent intent = new Intent(this, ForgotPassActivity.class);
        startActivity(intent);

    }

}