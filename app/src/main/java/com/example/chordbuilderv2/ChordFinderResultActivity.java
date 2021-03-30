package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ChordFinderResultActivity extends AppCompatActivity {
    TextView textViewStringsCF;
    TextView textViewVoicingCF;
    TextView textViewChordNameCF;
    TextView textViewChordNotesCF;
    TextView textViewFingeringCF;
    ArrayList<String> urlArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_finder_result);
        textViewChordNotesCF = findViewById(R.id.textViewChordNotesCF);
        textViewChordNameCF = findViewById(R.id.textViewChordNameCF);
        textViewStringsCF = findViewById(R.id.textViewStringsCF);
        textViewFingeringCF = findViewById(R.id.textViewFingeringCF);
        urlArray = getIntent().getStringArrayListExtra("URLOBJECT");
        System.out.println("FINAL:     "+urlArray);

        textViewFingeringCF.setText(urlArray.get(1));
        textViewChordNameCF.setText(urlArray.get(2));
        textViewChordNotesCF.setText(urlArray.get(4));

    }




}