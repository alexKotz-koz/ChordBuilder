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

import java.util.ArrayList;

public class ChordFinderResultActivity extends AppCompatActivity {
    TextView textViewChordNameCF;
    TextView textViewChordNotesCF;
    TextView textViewFingeringCF;
    ArrayList<String> urlArray;
    ChordBuilderDBHelperSaved chordBuilderDBHelperSaved;
    SavedChordAdapter savedChordAdapter;
    String fingering;
    String chordName;
    String chordNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_finder_result);
        textViewChordNotesCF = findViewById(R.id.textViewChordNotesCF);
        textViewChordNameCF = findViewById(R.id.textViewChordNameCF);
        textViewFingeringCF = findViewById(R.id.textViewFingeringCF);

        chordBuilderDBHelperSaved = new ChordBuilderDBHelperSaved(getApplicationContext());
        savedChordAdapter = new SavedChordAdapter(getApplicationContext());

        urlArray = getIntent().getStringArrayListExtra("URLOBJECT");

        fingering = urlArray.get(1);
        chordName = urlArray.get(2);
        chordNotes = urlArray.get(4);

        textViewFingeringCF.setText(fingering);
        textViewChordNameCF.setText(chordName);
        textViewChordNotesCF.setText(chordNotes);
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
            case (R.id.item_home):
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case (R.id.item_del):
                ContentValues contentValues = new ContentValues();
                contentValues.put("instrument", "guitar");
                contentValues.put("chordName", chordName);
                contentValues.put("fingering", fingering);
                contentValues.put("chordNotes", chordNotes);
                SQLiteDatabase sqLiteDatabase = chordBuilderDBHelperSaved.getWritableDatabase();
                sqLiteDatabase.insert("userChords", null, contentValues);
                savedChordAdapter.notifyDataSetChanged();
                Intent intent1 = new Intent(getApplicationContext(), SavedChordsActivity.class);
                startActivity(intent1);


                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}