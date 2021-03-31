package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler mainHandler;
    Button ukuleleButtonMain;
    Button guitarButtonMain;
    Menu mainMenu;

    ChordBuilderDBHelperUkulele chordBuilderDBHelperUkulele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chordBuilderDBHelperUkulele = new ChordBuilderDBHelperUkulele(getApplicationContext());
        chordBuilderDBHelperUkulele.getReadableDatabase();
        ukuleleButtonMain = findViewById(R.id.buttonUkulele);
        guitarButtonMain = findViewById(R.id.buttonGuitar);
    }
    public void onClickUkulele(View view){
        Intent intent = new Intent(getApplicationContext(), GUIGridUkulele.class);
        startActivity(intent);
    }

    public void onClickGuitar(View view){
        Intent intent = new Intent(getApplicationContext(), GUIGridGuitar.class);
        startActivity(intent);
    }

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
            case R.id.item_home:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_instruction:
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

        }
        return super.onOptionsItemSelected(item);
    }
}