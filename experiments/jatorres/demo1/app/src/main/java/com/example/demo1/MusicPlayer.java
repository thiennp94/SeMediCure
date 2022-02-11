package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MusicPlayer extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        music = MediaPlayer.create(this, R.raw.circles);
    }
    public void playMusic(View view) {
        music.start();
    }
    public void pauseMusic(View view) {
        music.pause();
    }
}