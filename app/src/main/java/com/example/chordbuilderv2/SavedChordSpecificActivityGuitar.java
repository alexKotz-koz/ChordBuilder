package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SavedChordSpecificActivityGuitar extends AppCompatActivity {

    TextView textViewSavedSpecificInstrumentGuitar;
    TextView textViewSavedSpecificChordNameGuitar;
    TextView textViewSavedSpecificChordFingeringGuitar;
    TextView textViewSavedSpecificChordNotesGuitar;
    ChordBuilderDBHelperSaved chordBuilderDBHelperSavedGuitar;
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



    }
}