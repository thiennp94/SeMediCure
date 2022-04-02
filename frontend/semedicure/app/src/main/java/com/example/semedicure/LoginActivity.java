package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName2);
    }

    private void requestString() {
        RequestQueue rQueue = Volley.newRequestQueue(this);
        String url = "https://8be4f6a4-40fe-40de-8be1-e9c3df6a16f7.mock.pstmn.io/Object/";

        StringRequest strRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }

        }) {
           @Override
            protected Map<String,String> getParams() throws AuthFailureError {
               Map<String, String> params = new HashMap<>();
               params.put("email", email.getText().toString());
               params.put("password", password.getText().toString());
               return params;
           }
        };

        rQueue.add(strRequest);

    }

    public void login(View view){
        if(email.getText().toString().length() > 0 && password.getText().toString().length() > 0) {
            requestString();
        }
        else {
            Toast.makeText(LoginActivity.this, "Please enter a valid response", Toast.LENGTH_LONG).show();
        }

//        Intent intent = new Intent(this, PatientPortalActivity.class);
//        startActivity(intent);
    }

    public void forgotPassword(View view){
        Intent intent = new Intent(this, ForgotPassActivity.class);
        startActivity(intent);

    }

}