package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class GuitarActivity extends AppCompatActivity {

    TextView textViewStrings;
    TextView textViewName;
    TextView textViewChordNotes;
    TextView textViewFingering;
    ProgressBar progressBar;
    String parseChordString;
    private Handler mainHandler;
    ChordHandlerThreadGuitar chordHandlerThreadGuitar;
    ArrayList<Integer> preBuildChord;
    ArrayList<String> urlArray;
    ChordBuilderDBHelperSaved chordBuilderDBHelperSaved;
    SavedChordAdapter savedChordAdapter;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar);
        textViewName = findViewById(R.id.textViewChordNameCF);
        textViewStrings = findViewById(R.id.textViewStringsCF);
        textViewChordNotes = findViewById(R.id.textViewChordNotesCF);
        textViewFingering = findViewById(R.id.textViewFingeringCF);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        preBuildChord = (ArrayList<Integer>) getIntent().getSerializableExtra("finalist");
        chordBuilderDBHelperSaved = new ChordBuilderDBHelperSaved(getApplicationContext());
        savedChordAdapter = new SavedChordAdapter(getApplicationContext());

         mainHandler = new Handler(){
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                   if (msg.what == 1){

                   }
                   else if (msg.what == 2){
                       progressBar.setVisibility(View.GONE);
                       chordHandlerThreadGuitar.quit();
                   }
                   else if (msg.what == 3){
                       progressBar.setVisibility(View.GONE);
                       urlArray = (ArrayList<String>) msg.obj;
                       textViewStrings.setText("Strings: " + urlArray.get(0));
                       textViewFingering.setText("Fingering" + urlArray.get(1));
                       parseChordString = urlArray.get(2);

                       for (int i = 0; i < parseChordString.length();i++){
                           if (parseChordString.charAt(2) == ','){
                               textViewName.setText("Chord Name: " + parseChordString.charAt(0));
                           }
                           else{
                               textViewName.setText("Chord Name: " + parseChordString);
                           }
                       }
                       textViewChordNotes.setText("Chord Notes: " + urlArray.get(4));
                   }
            }
        };
         getPreBuildChord();
    }

    public void getPreBuildChord(){
        chordHandlerThreadGuitar = new ChordHandlerThreadGuitar(getApplicationContext(),mainHandler, preBuildChord);
        chordHandlerThreadGuitar.start();
        progressBar.setVisibility(View.VISIBLE);
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
            case (R.id.item_home):
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            case (R.id.item_del):
                ContentValues contentValues = new ContentValues();
                contentValues.put("instrument", "guitar");
                contentValues.put("chordName",parseChordString);
                contentValues.put("fingering", urlArray.get(1));
                contentValues.put("chordNotes", urlArray.get(4));
                SQLiteDatabase sqLiteDatabase = chordBuilderDBHelperSaved.getWritableDatabase();
                sqLiteDatabase.insert("userChords",null,contentValues);
                savedChordAdapter.notifyDataSetChanged();
                sqLiteDatabase.close();
                Intent intent1 = new Intent(getApplicationContext(), SavedChordsActivity.class);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}