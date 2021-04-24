package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
    SoundPool soundPool;
    EditText bpm;
    Button startPlayer;
    int soundIdTick;
    boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metronome);

        bpm = findViewById(R.id.editTextUserInput);
        startPlayer = findViewById(R.id.buttonStartMediaPlayer);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundIdTick = soundPool.load(this, R.raw.tick, 1);

        isPlaying = false;
    }


    public void tapMetronome(View view) {
        bpm = findViewById(R.id.editTextUserInput);
        float rate = Integer.parseInt(String.valueOf(bpm.getText()));
        rate /= 60f;
        rate /= 2;

        if (!isPlaying) {
            soundPool.play(soundIdTick, 1, 1, 0, -1, rate);
            isPlaying = !isPlaying;
        }
        else {
            isPlaying = !isPlaying;
            soundPool.autoPause();
        }
    }
}