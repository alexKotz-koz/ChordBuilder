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
    TextView textViewVoicing;
    TextView textViewName;
    TextView textViewChordNotes;
    TextView textViewFingering;
    ProgressBar progressBar;
    String parseChordString;
    private Handler mainHandler;
    ChordHandlerThreadGuitar chordHandlerThreadGuitar;
    ArrayList<Integer> preBuildChord;
    ArrayList<String> urlArray;
    ChordBuilderDBHelper chordBuilderDBHelper;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar);
        textViewStrings = findViewById(R.id.textViewStrings);
        textViewName = findViewById(R.id.textViewName);
        textViewChordNotes = findViewById(R.id.textViewChordNotes);
        textViewFingering = findViewById(R.id.textViewFingering);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        preBuildChord = (ArrayList<Integer>) getIntent().getSerializableExtra("finalist");
        chordBuilderDBHelper = new ChordBuilderDBHelper(getApplicationContext());
        

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
                               //textViewName.setText("\tChord Quality: "+ parseChordString.charAt(2));

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
            case R.id.item_home:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_save:
                ContentValues contentValues = new ContentValues();
                contentValues.put("instrument", "guitar");
                contentValues.put("chordName",parseChordString);
                contentValues.put("fingering", parseChordString);
                contentValues.put("chordNotes", urlArray.get(4));
                SQLiteDatabase sqLiteDatabase = chordBuilderDBHelper.getWritableDatabase();
                sqLiteDatabase.insert("userChords",null,contentValues);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}