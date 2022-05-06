package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
public class LoginActivity extends AppCompatActivity {

    // digit + lowercase char + uppercase char + punctuation + symbol
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private static final String EMAIL_PATTERN =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private static final Pattern passwdPattern = Pattern.compile(PASSWORD_PATTERN);
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName2);
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

        Matcher passwdMatcher = passwdPattern.matcher(password.toString());
        Matcher emailMatcher = emailPattern.matcher(email.toString());

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
            Toast.makeText(LoginActivity.this, "Please enter a valid response", Toast.LENGTH_LONG).show();
        }

        if(email.getText().toString().equals("patient1") && password.getText().toString().equals("patient1")) {
            Intent intent = new Intent(this, PatientPortalActivity.class);
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