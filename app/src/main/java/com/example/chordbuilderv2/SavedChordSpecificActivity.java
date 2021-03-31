package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class SavedChordSpecificActivity extends AppCompatActivity {
    TextView textViewSavedSpecificInstrument;
    TextView textViewSavedSpecificChordName;
    TextView textViewSavedSpecificChordFingering;
    TextView textViewSavedSpecificChordNotes;

    String instrument;
    String chordName;
    String chordNotes;
    String chordFingering;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_chord_specific);
        textViewSavedSpecificInstrument = findViewById(R.id.textViewSavedSpecificInstrument);
        textViewSavedSpecificChordName = findViewById(R.id.textViewSavedSpecificChordName);
        textViewSavedSpecificChordFingering = findViewById(R.id.textViewSavedSpecificChordFingering);
        textViewSavedSpecificChordNotes = findViewById(R.id.textViewSavedSpecificChordNotes);

        position = getIntent().getIntExtra("POSITION",0);
        instrument = getIntent().getStringExtra("INSTRUMENT");
        chordName = getIntent().getStringExtra("NAME");
        chordFingering = getIntent().getStringExtra("FINGERING");
        chordNotes = getIntent().getStringExtra("NOTES");

        textViewSavedSpecificInstrument.setText(instrument);
        textViewSavedSpecificChordName.setText(chordName);
        textViewSavedSpecificChordFingering.setText(chordFingering);
        textViewSavedSpecificChordNotes.setText(chordNotes);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}