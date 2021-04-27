package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    Button ukuleleButtonMain;
    Button guitarButtonMain;
    ChordBuilderDBHelperUkulele chordBuilderDBHelperUkulele;
    ChordBuilderDBHelperSaved chordBuilderDBHelperSaved;


    public static boolean checkActivityMain = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chordBuilderDBHelperUkulele = new ChordBuilderDBHelperUkulele(getApplicationContext());
        chordBuilderDBHelperSaved = new ChordBuilderDBHelperSaved(getApplicationContext());

        ukuleleButtonMain = findViewById(R.id.buttonUkulele);
        guitarButtonMain = findViewById(R.id.buttonGuitar);
        checkActivityMain = true;

    }
    public void onClickUkulele(View view){
        Intent intent = new Intent(getApplicationContext(), GUIGridUkulele.class);
        startActivity(intent);
    }

    public void onClickGuitar(View view){
        Intent intent = new Intent(getApplicationContext(), GUIGridGuitar.class);
        startActivity(intent);
    }

   /* public void onClickCF(View view){
        Intent intent = new Intent(getApplicationContext(), ChordFinderActivity.class);
        startActivity(intent);
    }*/


    public void onClickSavedChord(View view){

        Intent intent = new Intent(getApplicationContext(), SavedChordsActivity.class);
        startActivity(intent);

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
            case (R.id.item_instruction):
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("INSTRUCTIONS");
                builder.setMessage("Select an Instrument to Build a Chord \n\nSelect Saved Chords to View Your Chords \n\nSelect Chord Finder to Find Chord From Root ");

                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        
                    }
                });

                builder.show();
                break;
            case (R.id.item_metro):
                Intent intent1 = new Intent(getApplicationContext(),MetronomeActivity.class);
                startActivity(intent1);


        }
        return super.onOptionsItemSelected(item);
    }



}


