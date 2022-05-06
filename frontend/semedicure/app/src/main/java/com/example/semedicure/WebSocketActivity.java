package com.example.semedicure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

    String firstName;
    Button b1, b2;
    EditText e1, e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_socket);

        b2 = (Button) findViewById(R.id.bt2);
        e2 = (EditText) findViewById(R.id.et2);
        t1 = (TextView) findViewById(R.id.tx1);

//        String data = getIntent().getStringExtra("data");
//        try {
//            JSONObject json = new JSONObject(data);
//            JSONObject newJson = json.getJSONObject("userInfo");
//            firstName = newJson.getString("firstName");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        String w = "ws://coms-309-024.class.las.iastate.edu:8080/websocket/" + firstName;
        Draft[] drafts = { new Draft_6455() };
        try {
            cc = new WebSocketClient(new URI(w), (Draft) drafts[0]) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    Log.i("OPEN", "onOpen() returned: " + "is connecting");
                }

                @Override
                public void onMessage(String s) {
                    Log.i("msg", s);
                    String str = t1.getText().toString();
                    t1.setText(s + "\nServer:" + s);

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

    public void click(View view) {
        try {
            cc.send(e2.getText().toString());
        } catch (Exception e) {
            Log.d("ExceptionSendMessage:", e.getMessage().toString());
        }
    }
}