package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SavedChordsActivity extends AppCompatActivity implements SavedChordAdapter.Listener{
    SavedChordAdapter savedChordAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ChordBuilderDBHelperSaved chordBuilderDBHelperSaved;
    ChordBuilderDBWrapperSaved wrapperSaved;
    public static boolean currentActivitySavedChords = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_guitar_chords);
        currentActivitySavedChords = true;
        MainActivity.checkActivityMain = false;
        savedChordAdapter =  new SavedChordAdapter(getApplicationContext());
        savedChordAdapter.setListener(this);
        recyclerView = findViewById(R.id.recyclerViewSavedChords);
        recyclerView.setAdapter(savedChordAdapter);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        chordBuilderDBHelperSaved = new ChordBuilderDBHelperSaved(getApplicationContext());
        chordBuilderDBHelperSaved.getReadableDatabase();

        Cursor cursor;
        SQLiteDatabase sqLiteDatabase = chordBuilderDBHelperSaved.getReadableDatabase();
        cursor = sqLiteDatabase.query("userChords",new String[]{"_id","instrument","chordName","fingering","chordNotes"},null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount() == 0){
            if (!currentActivitySavedChords && MainActivity.checkActivityMain){
                System.out.println("in specific");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
            else {
                System.out.println("in Main");
                Toast.makeText(getApplicationContext(),"No Saved Chords",Toast.LENGTH_LONG).show();
                finish();
            }
        }
        cursor.close();

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getApplicationContext(), SavedChordSpecificActivity.class);
        String chordName;
        String instrument;
        String chordFingering;
        String chordNotes;
        intent.putExtra("INDEX", position);


        Cursor cursor;
        SQLiteDatabase sqLiteDatabase = chordBuilderDBHelperSaved.getReadableDatabase();
        cursor = sqLiteDatabase.query("userChords",new String[]{"_id","instrument","chordName","fingering","chordNotes"},null,null,null,null,null);
        cursor.moveToPosition(position);
        wrapperSaved = new ChordBuilderDBWrapperSaved(cursor);

        instrument = wrapperSaved.getInstrument();
        intent.putExtra("INSTRUMENT",instrument);

        chordName=wrapperSaved.getChordName();
        intent.putExtra("NAME",chordName);

        instrument = wrapperSaved.getInstrument();
        intent.putExtra("INSTRUMENT",instrument);

        chordFingering = wrapperSaved.getFingering();
        intent.putExtra("FINGERING",chordFingering);

        chordNotes = wrapperSaved.getChordNotes();
        intent.putExtra("NOTES",chordNotes);
        cursor.close();
        sqLiteDatabase.close();
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
                    sqLiteDatabase.delete("userChords", null,null);
                    savedChordAdapter.notifyDataSetChanged();
                    sqLiteDatabase.close();
                    Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent1);
                }
                cursor.close();
        }
        return super.onOptionsItemSelected(item);
    }

}