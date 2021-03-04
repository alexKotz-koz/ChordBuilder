package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SavedChordsActivity extends AppCompatActivity{
    SavedChordAdapter savedChordAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_guitar_chords);
        savedChordAdapter =  new SavedChordAdapter(getApplicationContext());

        recyclerView = findViewById(R.id.recyclerViewSavedChords);
        recyclerView.setAdapter(savedChordAdapter);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}