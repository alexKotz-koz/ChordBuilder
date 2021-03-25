package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ChordFinderActivity extends AppCompatActivity {

    Spinner spinnerRoot;
    Spinner spinnerQuality;
    Button buttonSubmit;
    String chord;
    ProgressBar progressBar;
    TextView textViewStrings;
    TextView textViewVoicing;
    TextView textViewName;
    TextView textViewChordNotes;
    TextView textViewFingering;
    String parseChordString;
    private Handler mainHandler2;
    ChordHandlerThreadGuitarCF chordHandlerThreadGuitarCF;
    ArrayList<String> urlArray;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_finder);
        spinnerRoot = findViewById(R.id.spinnerRoot);
        spinnerQuality = findViewById(R.id.spinnerQuality);
        buttonSubmit = findViewById(R.id.buttonCFSubmit);
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.GONE);
        String root = String.valueOf(spinnerRoot.getSelectedItem());
        String quality = String.valueOf(spinnerQuality.getSelectedItem());
        System.out.println(root + quality);
        //************************************ Error... cant get values of spinners
        chord = root + "_"+quality;


        mainHandler2 = new Handler(){
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1){

                }
                else if (msg.what == 2){
                    progressBar.setVisibility(View.GONE);
                    chordHandlerThreadGuitarCF.quit();
                }
                else if (msg.what == 3){
                    progressBar.setVisibility(View.GONE);
                    urlArray = (ArrayList<String>) msg.obj;
                    textViewStrings.setText("Strings: " + urlArray.get(0));
                    textViewFingering.setText("Fingering" + urlArray.get(1));
                    parseChordString = urlArray.get(2);
                    System.out.println(parseChordString);

                    /*for (int i = 0; i < parseChordString.length();i++){
                        if (parseChordString.charAt(2) == ','){
                            textViewName.setText("Chord Name: " + parseChordString.charAt(0));
                        }
                        else{
                            textViewName.setText("Chord Name: " + parseChordString);
                        }
                    }*/
                    //textViewChordNotes.setText("Chord Notes: " + urlArray.get(4));
                }
            }
        };
    }

    public void getPreBuildChord(){
        System.out.println("Chord: "+chord);
        chordHandlerThreadGuitarCF = new ChordHandlerThreadGuitarCF(getApplicationContext(),mainHandler2, chord);
        chordHandlerThreadGuitarCF.start();
        progressBar.setVisibility(View.VISIBLE);
    }

    public void onClickSubmit(View view){
        getPreBuildChord();
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
            case R.id.item_home:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}