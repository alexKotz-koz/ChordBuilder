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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    String quality;
    String root;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chord_finder);
        spinnerRoot = (Spinner) findViewById(R.id.spinnerRoot);
        spinnerQuality = findViewById(R.id.spinnerQuality);
        buttonSubmit = findViewById(R.id.buttonCFSubmit);
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.GONE);
        urlArray = ChordHandlerThreadGuitarCF.getURLArr();
        String[] rootArray = getResources().getStringArray(R.array.notes_array);
        String[] qualityArray = getResources().getStringArray(R.array.quality_array);

        ArrayAdapter<String> spinnerRootAdapter = new ArrayAdapter<String>(ChordFinderActivity.this, android.R.layout.simple_list_item_1,rootArray );
        spinnerRoot.setAdapter(spinnerRootAdapter);

        ArrayAdapter<String> spinnerQualityAdapter = new ArrayAdapter<String>(ChordFinderActivity.this,android.R.layout.simple_list_item_1,qualityArray);
        spinnerQuality.setAdapter(spinnerQualityAdapter);


        spinnerRoot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                root = spinnerRoot.getSelectedItem().toString();
                System.out.println("Root: "+root);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerQuality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                quality = spinnerQuality.getSelectedItem().toString();
                if (quality.equals("Min")){
                    quality = "m";
                }
                System.out.println(quality);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        mainHandler2 = new Handler(){
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1){

                }
                else if (msg.what == 2){
                    progressBar.setVisibility(View.GONE);
                    chordHandlerThreadGuitarCF.quit();
                    Intent intent = new Intent(getApplicationContext(),ChordFinderResultActivity.class);
                    intent.putExtra("URLOBJECT",urlArray);
                    startActivity(intent);
                }
            }
        };
    }

    public void getPreBuildChord(){
        System.out.println("Chord: "+chord);
        if (quality==null || quality.equals("Maj")){
            chord = root;
        }else{

            chord = root+"_"+quality.toLowerCase();
        }

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