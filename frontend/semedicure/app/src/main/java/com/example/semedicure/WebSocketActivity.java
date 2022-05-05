package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

        String w = "ws://localhost:8080/websocket/";
        try {
            cc = new WebSocketClient(new URI(w)) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {

                }

                @Override
                public void onMessage(String s) {

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
    }
}