package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class MetronomeActivity extends AppCompatActivity {
    MediaPlayer mp;
    EditText bpm;
    Button startPlayer;
    String tickFile;
    MetronomeThread metronomeThread;
    private Handler mainHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metronome);
        tickFile = String.valueOf(R.raw.stick);

        mp = MetronomeMediaPlayer.getMediaPlayer();
        bpm = findViewById(R.id.editTextUserInput);
        startPlayer = findViewById(R.id.buttonStartMediaPlayer);


        startPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = String.valueOf(bpm.getText());
                System.out.println("UI: "+userInput);
                metronomeThread = new MetronomeThread(getApplicationContext(),mainHandler,bpm);
                metronomeThread.start();
            }
        });

        mainHandler = new Handler() {
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1) {

                } else if (msg.what == 2) {
                    metronomeThread.quit();
                }
            }
        };

    }
}