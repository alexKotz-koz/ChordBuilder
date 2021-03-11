package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioRecord;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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

        }
        return super.onOptionsItemSelected(item);
    }
}