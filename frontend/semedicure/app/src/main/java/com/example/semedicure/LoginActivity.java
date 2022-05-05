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

/**
 * Acts as the view for the login screen.
 */
public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        String url = "https://8be4f6a4-40fe-40de-8be1-e9c3df6a16f7.mock.pstmn.io/Object/";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            /**
             * Displays a toast on-screen confirming a successful response from the server.
             * @param response String response from the server.
             */
            @Override
            public void onResponse(String response) {
                Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            /**
             * Displays a toast on-screen indicating an unsuccessful response from the server.
             * @param error Error indicating unsuccessful response from the server.
             */
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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

        rQueue.add(strRequest);

    }

    /**
     *
     * @param view
     */
    public void login(View view){

        if(email.getText().toString().length() > 0 && password.getText().toString().length() > 0) {
            requestString();
        }
        else {
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(i) {
            case 0:
                user = "patients";
                break;
            case 1:
                user = "doctors";
                break;
            case 2:
                user = "admins";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}