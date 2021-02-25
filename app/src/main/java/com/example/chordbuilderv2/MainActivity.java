package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ChordBuilderDBHelper chordDatabaseHelper;
    //ChordWrapper chordWrapper;
    private Handler mainHandler;
   // ChordHandlerThread chordHandlerThread;
    Button ukukleleButtonMain;
    Button guitarButtonMain;

    ChordBuilderDBHelper chordBuilderDBHelper;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chordDatabaseHelper = new ChordBuilderDBHelper(getApplicationContext());
        chordDatabaseHelper.getReadableDatabase();
        ukukleleButtonMain = findViewById(R.id.buttonUkulele);
        guitarButtonMain = findViewById(R.id.buttonGuitar);
        chordBuilderDBHelper = new ChordBuilderDBHelper(getApplicationContext());

    }
    public void onClickUkulele(View view){
        Intent intent = new Intent(getApplicationContext(), GUIGridUkulele.class);
        startActivity(intent);
    }

    public void onClickGuitar(View view){
        Intent intent = new Intent(getApplicationContext(), GUIGridGuitar.class);
        startActivity(intent);

    }
}