package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UkuleleActivity extends AppCompatActivity {

    ChordBuilderDBHelper chordBuilderDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukulele);
        chordBuilderDBHelper = new ChordBuilderDBHelper(getApplicationContext());
    }
}