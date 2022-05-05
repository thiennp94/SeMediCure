package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

public class WebSocketActivity extends AppCompatActivity {

    private WebSocketClient cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_socket);

        JSONObject json = new JSONObject();
        try {
            json.put("email", getIntent().getStringExtra("email"));
            json.put("password", getIntent().getStringExtra("password"));
            json.put("user", getIntent().getStringExtra("user"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String intentData = getIntent().getStringExtra("UniqueId");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        String user = getIntent().getStringExtra("user");

        String w = "ws://coms-309-024.class.las.iastate.edu:8080/websocket/";
        Draft[] drafts = { new Draft_6455() };
        try {
            cc = new WebSocketClient(new URI(w), (Draft) drafts[0]) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    Log.i("OPEN", "run() returned: " + "is connecting");
                    if(getIntent().getStringExtra("UniqueId") != null) {
                        if (getIntent().getStringExtra("UniqueId").equals("login")) {
                            cc.send(getIntent().getStringExtra("email"));
                            //cc.send(String.valueOf(json));
                            //cc.send(getIntent().getStringExtra("password"));
                            //cc.send(getIntent().getStringExtra("user"));
                        }
                    }
                }

                @Override
                public void onMessage(String s) {
                    Log.i("msg", s);
                    /*if(getIntent().getStringExtra("user").equals("patients")) {
                        Intent intent = new Intent(getApplicationContext(), PatientPortalActivity.class)
                        intent.putExtra("data", s);
                        startActivity(intent);
                    }
                    else if(getIntent().getStringExtra("user").equals("doctors")) {
                        Intent intent = new Intent(getApplicationContext(), ProviderPortalActivity.class)
                        intent.putExtra("data", s);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), AdminPortalActivity.class)
                        intent.putExtra("data", s);
                        startActivity(intent);
                    }*/
                    //finish();
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    Log.i("CLOSE", "onClose() returned: " + s);
                }

                @Override
                public void onError(Exception e) {
                    Log.i("Exception:", e.toString());
                }
            };
        } catch (URISyntaxException e) {
            Log.d("Exception:", e.getMessage().toString());
            e.printStackTrace();
        }
        cc.connect();
    }
}