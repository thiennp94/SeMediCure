package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class WebSocketActivity extends AppCompatActivity {

    private WebSocketClient cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_socket);

        String intentData = getIntent().getStringExtra("UniqueId");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        String user = getIntent().getStringExtra("user");

        String w = "ws://localhost:8080/websocket/";
        try {
            cc = new WebSocketClient(new URI(w)) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                }

                @Override
                public void onMessage(String s) {
                    Toast.makeText(WebSocketActivity.this, s, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onClose(int i, String s, boolean b) {

                }

                @Override
                public void onError(Exception e) {

                }
            };
        } catch (URISyntaxException e) {

        }
        cc.connect();

        if(intentData != null) {
            if (intentData.equals("login")) {
                cc.send(email);
                cc.send(password);
                cc.send(user);
            }
        }
    }
}