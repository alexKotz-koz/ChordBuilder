package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SavedChordSpecificActivity extends AppCompatActivity {
    TextView textViewSavedSpecificInstrument;
    TextView textViewSavedSpecificChordName;
    TextView textViewSavedSpecificChordFingering;
    TextView textViewSavedSpecificChordNotes;
    ChordBuilderDBHelperSaved chordBuilderDBHelperSaved;
    SavedChordAdapter savedChordAdapter;

    private static final String DATABASE_TABLE ="userChords";

    GUIArrayAdapter adapterG;
    GUIArrayAdapter adapterC;
    GUIArrayAdapter adapterE;
    GUIArrayAdapter adapterA;

    ListView listViewGSaved;
    ListView listViewCSaved;
    ListView listViewESaved;
    ListView listViewASaved;

    ArrayList<String> listG = new ArrayList<>();
    ArrayList<String> listC = new ArrayList<>();
    ArrayList<String> listE = new ArrayList<>();
    ArrayList<String> listA = new ArrayList<>();

    String instrument;
    String chordName;
    String chordNotes;
    String chordFingering;
    int position;

    int noteForGString;
    int noteForCString;
    int noteForEString;
    int noteForAString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_chord_specific);
        textViewSavedSpecificInstrument = findViewById(R.id.textViewSavedSpecificInstrument);
        textViewSavedSpecificChordName = findViewById(R.id.textViewSavedSpecificChordName);
        textViewSavedSpecificChordFingering = findViewById(R.id.textViewSavedSpecificChordFingering);
        textViewSavedSpecificChordNotes = findViewById(R.id.textViewSavedSpecificChordNotes);

        listViewASaved = findViewById(R.id.listViewStringASaved);
        listViewCSaved = findViewById(R.id.listViewStringCSaved);
        listViewESaved = findViewById(R.id.listViewStringESaved);
        listViewGSaved = findViewById(R.id.listViewStringGSaved);

        savedChordAdapter =  new SavedChordAdapter(getApplicationContext());
        chordBuilderDBHelperSaved = new ChordBuilderDBHelperSaved(getApplicationContext());
        chordBuilderDBHelperSaved.getReadableDatabase();

        position = getIntent().getIntExtra("POSITION",0);
        instrument = getIntent().getStringExtra("INSTRUMENT");
        chordName = getIntent().getStringExtra("NAME");
        chordFingering = getIntent().getStringExtra("FINGERING");
        chordNotes = getIntent().getStringExtra("NOTES");

        textViewSavedSpecificInstrument.setText(instrument.toUpperCase());
        textViewSavedSpecificChordName.setText(chordName);
        textViewSavedSpecificChordFingering.setText(chordFingering);
        textViewSavedSpecificChordNotes.setText(chordNotes);

        if (instrument.equals("ukulele")) {
            noteForGString = Integer.parseInt(String.valueOf(chordFingering.charAt(0)))-1;
            noteForCString = Integer.parseInt(String.valueOf(chordFingering.charAt(3)))-1;
            noteForEString = Integer.parseInt(String.valueOf(chordFingering.charAt(6)))-1;
            noteForAString = Integer.parseInt(String.valueOf(chordFingering.charAt(9)))-1;

            for (int i = 0; i < 5; i++) {
                listG.add("o");
                listC.add("o");
                listE.add("o");
                listA.add("o");
            }
            if (noteForGString != -1){
                listG.set(noteForGString,"p");
            }
            if (noteForCString != -1){
                listC.set(noteForCString,"p");
            }
            if (noteForEString != -1){
                listE.set(noteForEString,"p");
            }
            if (noteForAString != -1){
                listA.set(noteForAString,"p");
            }

            adapterG = new GUIArrayAdapter(getApplicationContext(), listG);
            listViewGSaved.setAdapter(adapterG);

            adapterE = new GUIArrayAdapter(getApplicationContext(), listE);
            listViewESaved.setAdapter(adapterE);

            adapterC = new GUIArrayAdapter(getApplicationContext(), listC);
            listViewCSaved.setAdapter(adapterC);

            adapterA = new GUIArrayAdapter(getApplicationContext(), listA);
            listViewASaved.setAdapter(adapterA);
        } else if(instrument.equals("guitar")){
            Intent intent = new Intent(getApplicationContext(),SavedChordSpecificActivityGuitar.class);
            intent.putExtra("NAME",chordName);
            intent.putExtra("FINGERING",chordFingering);
            intent.putExtra("NOTES",chordNotes);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_saved,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.item_home):
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            case (R.id.item_del):
                Cursor cursor;
                SQLiteDatabase sqLiteDatabase2 = chordBuilderDBHelperSaved.getReadableDatabase();
                cursor = sqLiteDatabase2.query("userChords",new String[]{"_id","instrument","chordName","fingering","chordNotes"},null,null,null,null,null);
                cursor.moveToFirst();
                if (cursor.getCount() <= 0){
                    finish();
                }
                else {
                    SQLiteDatabase sqLiteDatabase = chordBuilderDBHelperSaved.getWritableDatabase();
                    sqLiteDatabase.delete(DATABASE_TABLE, "instrument=? and chordName=?", new String[]{instrument, chordName});
                    savedChordAdapter.notifyDataSetChanged();
                    sqLiteDatabase.close();
                    Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent1);
                }
        }
        return super.onOptionsItemSelected(item);
    }
}