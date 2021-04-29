package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.item_home):
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            case (R.id.item_instruction):
                AlertDialog.Builder builder = new AlertDialog.Builder(MetronomeActivity.this);
                builder.setTitle("INSTRUCTIONS");
                builder.setMessage("Select an Instrument to Build a Chord \n\nSelect Saved Chords to View Your Chords \n\nSelect Chord Finder to Find Chord From Root ");

                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
                break;
            case (R.id.item_metro):
                Intent intent1 = new Intent(getApplicationContext(),MetronomeActivity.class);
                startActivity(intent1);


        }
        return super.onOptionsItemSelected(item);
    }
}