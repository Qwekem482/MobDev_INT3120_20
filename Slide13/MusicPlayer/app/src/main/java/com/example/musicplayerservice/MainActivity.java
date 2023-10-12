package com.example.musicplayerservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start, stop, pause;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        String url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-9.mp3";
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        start = findViewById( R.id.startButton );
        pause = findViewById( R.id.pauseButton );
        stop = findViewById( R.id.stopButton );
        start.setOnClickListener( this );
        pause.setOnClickListener( this );
        stop.setOnClickListener( this );
    }

    public void onClick(View view) {
        if(view == start){
            mediaPlayer.start();
        }
        else if(view == pause){
            mediaPlayer.pause();
        }
        else if (view == stop){
            mediaPlayer.stop();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}