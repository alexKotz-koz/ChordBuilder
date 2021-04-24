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

public class SavedChordSpecificActivityGuitar extends AppCompatActivity {

    TextView textViewSavedSpecificInstrumentGuitar;
    TextView textViewSavedSpecificChordNameGuitar;
    TextView textViewSavedSpecificChordFingeringGuitar;
    TextView textViewSavedSpecificChordNotesGuitar;
    ChordBuilderDBHelperSaved chordBuilderDBHelperSaved;
    SavedChordAdapter savedChordAdapter;
    private static final String DATABASE_TABLE ="userChords";


    GUIArrayAdapter adapterE;
    GUIArrayAdapter adapterA;
    GUIArrayAdapter adapterD;
    GUIArrayAdapter adapterG;
    GUIArrayAdapter adapterB;
    GUIArrayAdapter adapterEh;

    ListView listViewESaved;
    ListView listViewASaved;
    ListView listViewDSaved;
    ListView listViewGSaved;
    ListView listViewBSaved;
    ListView listViewEhSaved;

    ArrayList<String> listE = new ArrayList<>();
    ArrayList<String> listA = new ArrayList<>();
    ArrayList<String> listD = new ArrayList<>();
    ArrayList<String> listG = new ArrayList<>();
    ArrayList<String> listB = new ArrayList<>();
    ArrayList<String> listEh = new ArrayList<>();


    String instrument;
    String chordName;
    String chordNotes;
    String chordFingering;
    int position;

    int noteForEString;
    int noteForAString;
    int noteForDString;
    int noteForGString;
    int noteForBString;
    int noteForEhString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_chord_specific_guitar);
        textViewSavedSpecificInstrumentGuitar = findViewById(R.id.textViewSavedSpecificInstrumentGuitar);
        textViewSavedSpecificChordNameGuitar = findViewById(R.id.textViewSavedSpecificChordNameGuitar);
        textViewSavedSpecificChordFingeringGuitar = findViewById(R.id.textViewSavedSpecificChordFingeringGuitar);
        textViewSavedSpecificChordNotesGuitar = findViewById(R.id.textViewSavedSpecificChordNotesGuitar);

        listViewESaved = findViewById(R.id.listViewStringESavedGuitar);
        listViewASaved = findViewById(R.id.listViewStringASavedGuitar);
        listViewDSaved = findViewById(R.id.listViewStringDSavedGuitar);
        listViewGSaved = findViewById(R.id.listViewStringGSavedGuitar);
        listViewBSaved = findViewById(R.id.listViewStringBSavedGuitar);
        listViewEhSaved = findViewById(R.id.listViewStringEhSavedGuitar);

        savedChordAdapter =  new SavedChordAdapter(getApplicationContext());
        chordBuilderDBHelperSaved = new ChordBuilderDBHelperSaved(getApplicationContext());
        chordBuilderDBHelperSaved.getReadableDatabase();

        instrument = getIntent().getStringExtra("INSTRUMENT");
        chordName = getIntent().getStringExtra("NAME");
        chordFingering = getIntent().getStringExtra("FINGERING");
        chordNotes = getIntent().getStringExtra("NOTES");

        textViewSavedSpecificInstrumentGuitar.setText(instrument);
        textViewSavedSpecificChordNameGuitar.setText(chordName);
        textViewSavedSpecificChordFingeringGuitar.setText(chordFingering);
        textViewSavedSpecificChordNotesGuitar.setText(chordNotes);

        System.out.println("CHORD FINGERING: \n"+chordFingering);

        for(int i = 0; i < chordFingering.length(); i++){
            if(chordFingering.charAt(i) == 'X'){
                chordFingering = chordFingering.replace('X','0');
            }

        }
        System.out.println(chordFingering);





        noteForEString = Integer.parseInt(String.valueOf(chordFingering.charAt(0))) - 1;
        noteForAString = Integer.parseInt(String.valueOf(chordFingering.charAt(2))) - 1;
        noteForDString = Integer.parseInt(String.valueOf(chordFingering.charAt(4))) - 1;
        noteForGString = Integer.parseInt(String.valueOf(chordFingering.charAt(6))) - 1;
        noteForBString = Integer.parseInt(String.valueOf(chordFingering.charAt(8))) - 1;
        noteForEhString = Integer.parseInt(String.valueOf(chordFingering.charAt(10))) - 1;


        for (int i = 0; i < 6; i++) {
            listE.add("o");
            listA.add("o");
            listD.add("o");
            listG.add("o");
            listB.add("o");
            listEh.add("o");
        }
        if (noteForEString != -1){
            listE.add(noteForEString,"p");
        }
        if (noteForAString != -1){
            listA.add(noteForAString,"p");
        }
        if (noteForDString != -1){
            listD.add(noteForDString,"p");
        }
        if (noteForGString != -1){
            listG.add(noteForGString,"p");
        }
        if (noteForBString != -1){
            listB.add(noteForBString,"p");
        }
        if (noteForEhString != -1){
            listEh.add(noteForEhString,"p");
        }

        adapterE = new GUIArrayAdapter(this, listE);
        listViewESaved.setAdapter(adapterE);

        adapterA = new GUIArrayAdapter(this, listA);
        listViewASaved.setAdapter(adapterA);

        adapterD = new GUIArrayAdapter(this, listD);
        listViewDSaved.setAdapter(adapterD);

        adapterG = new GUIArrayAdapter(this, listG);
        listViewGSaved.setAdapter(adapterG);

        adapterB = new GUIArrayAdapter(this, listB);
        listViewBSaved.setAdapter(adapterB);

        adapterEh = new GUIArrayAdapter(this, listEh);
        listViewEhSaved.setAdapter(adapterEh);
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
            case R.id.item_home:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            case (R.id.item_del):
                Cursor cursor;
                SQLiteDatabase sqLiteDatabase2 = chordBuilderDBHelperSaved.getReadableDatabase();
                cursor = sqLiteDatabase2.query("userChords",new String[]{"_id","instrument","chordName","fingering","chordNotes"},null,null,null,null,null);
                cursor.moveToFirst();
                if (cursor.getCount() <= 0){
                    System.out.println("Inhere");
                    finish();
                }
                else {
                    SQLiteDatabase sqLiteDatabase = chordBuilderDBHelperSaved.getWritableDatabase();
                    sqLiteDatabase.delete(DATABASE_TABLE, "instrument=? and chordName=?", new String[]{instrument, chordName});
                    savedChordAdapter.notifyDataSetChanged();
                    sqLiteDatabase.close();
                    Intent intent1 = new Intent(getApplicationContext(), SavedChordsActivity.class);
                    startActivity(intent1);
                }


        }
        return super.onOptionsItemSelected(item);
    }
}