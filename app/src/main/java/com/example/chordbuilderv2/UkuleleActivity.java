package com.example.chordbuilderv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class UkuleleActivity extends AppCompatActivity {

    ChordBuilderDBHelperUkulele chordBuilderDBHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ChordBuilderDBWrapperUkulele chordBuilderDBWrapper;
    SavedChordAdapter savedChordAdapter;
    ArrayList<Integer> preBuildChord;
    TextView textViewStrings;
    TextView textViewName;
    TextView textViewNotes;
    ArrayList<String> s1Array;
    ArrayList<String> s2Array;
    ArrayList<String> s3Array;
    ArrayList<String> s4Array;
    String chordNotes = "";
    String fingering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukulele);
        preBuildChord = (ArrayList<Integer>) getIntent().getSerializableExtra("finalist");
        textViewStrings = findViewById(R.id.textViewStringsUke);
        textViewName = findViewById(R.id.textViewNameUke);
        textViewNotes = findViewById(R.id.textViewNotesUke);
        chordBuilderDBHelper = new ChordBuilderDBHelperUkulele(getApplicationContext());
        sqLiteDatabase = chordBuilderDBHelper.getReadableDatabase();

        s1Array = new ArrayList<>();
        s2Array = new ArrayList<>();
        s3Array = new ArrayList<>();
        s4Array = new ArrayList<>();

        s1Array.add(0,"G");
        s1Array.add(1,"G#/Ab");
        s1Array.add(2,"A");
        s1Array.add(3,"A#/Bb");
        s1Array.add(4,"B");
        s1Array.add(5,"C");
        s1Array.add(6,"C#/Db");
        s1Array.add(7,"D");
        s1Array.add(8,"D#/Eb");
        s1Array.add(9,"E");
        s1Array.add(10,"F");
        s1Array.add(11,"F#/Gb");
        s1Array.add(12,"Ghigh");

        s2Array.add(0,"C");
        s2Array.add(1,"C#/Db");
        s2Array.add(2,"D");
        s2Array.add(3,"D#/Eb");
        s2Array.add(4,"E");
        s2Array.add(5,"F");
        s2Array.add(6,"F#/Gb");
        s2Array.add(7,"G");
        s2Array.add(8, "G#/Ab");
        s2Array.add(9,"A");
        s2Array.add(10,"A#/Bb");
        s2Array.add(11,"B");
        s2Array.add(12,"Chigh");

        s3Array.add(0,"E");
        s3Array.add(1,"F");
        s3Array.add(2,"F#/Gb");
        s3Array.add(3,"G");
        s3Array.add(4, "G#/Ab");
        s3Array.add(5,"A");
        s3Array.add(6,"A#/Bb");
        s3Array.add(7,"B");
        s3Array.add(8,"C");
        s3Array.add(9,"C#/Db");
        s3Array.add(10,"D");
        s3Array.add(11,"D#/Eb");
        s3Array.add(12,"Ehigh");

        s4Array.add(0,"A");
        s4Array.add(1,"A#/Bb");
        s4Array.add(2,"B");
        s4Array.add(3,"C");
        s4Array.add(4,"C#/Db");
        s4Array.add(5,"D");
        s4Array.add(6,"D#/Eb");
        s4Array.add(7,"E");
        s4Array.add(8,"F");
        s4Array.add(9,"F#/Gb");
        s4Array.add(10,"G");
        s4Array.add(11,"G#/Ab");
        s4Array.add(12,"A");

        savedChordAdapter = new SavedChordAdapter(getApplicationContext());

        String s1 = String.valueOf(preBuildChord.get(0));
        String s2 = String.valueOf(preBuildChord.get(1));
        String s3 = String.valueOf(preBuildChord.get(2));
        String s4 = String.valueOf(preBuildChord.get(3));
        switch (s1){
            case "0":
                chordNotes += s1Array.get(0);
                break;
            case "1":
                chordNotes += s1Array.get(1);
                break;
            case "2":
                chordNotes += s1Array.get(2);
                break;
            case "3":
                chordNotes += s1Array.get(3);
                break;
            case "4":
                chordNotes += s1Array.get(4);
                break;
            case "5":
                chordNotes += s1Array.get(5);
                break;
            case "6":
                chordNotes += s1Array.get(6);
                break;
            case "7":
                chordNotes += s1Array.get(7);
                break;
            case "8":
                chordNotes += s1Array.get(8);
                break;
            case "9":
                chordNotes += s1Array.get(9);
                break;
            case "10":
                chordNotes += s1Array.get(10);
                break;
            case "11":
                chordNotes += s1Array.get(11);
                break;
            case "12":
                chordNotes += s1Array.get(12);
                break;
        }

        switch (s2){
            case "0":
                chordNotes += ", " + s2Array.get(0);
                break;
            case "1":
                chordNotes += ", " + s2Array.get(1);
                break;
            case "2":
                chordNotes += ", " + s2Array.get(2);
                break;
            case "3":
                chordNotes += ", " + s2Array.get(3);
                break;
            case "4":
                chordNotes += ", " + s2Array.get(4);
                break;
            case "5":
                chordNotes += ", " + s2Array.get(5);
                break;
            case "6":
                chordNotes += ", " + s2Array.get(6);
                break;
            case "7":
                chordNotes += ", " + s2Array.get(7);
                break;
            case "8":
                chordNotes += ", " + s2Array.get(8);
                break;
            case "9":
                chordNotes += ", " + s2Array.get(9);
                break;
            case "10":
                chordNotes += ", " + s2Array.get(10);
                break;
            case "11":
                chordNotes += ", " + s2Array.get(11);
                break;
            case "12":
                chordNotes += ", " + s2Array.get(12);
                break;
        }

        switch (s3){
            case "0":
                chordNotes += ", " + s3Array.get(0);
                break;
            case "1":
                chordNotes += ", " + s3Array.get(1);
                break;
            case "2":
                chordNotes += ", " + s3Array.get(2);
                break;
            case "3":
                chordNotes += ", " + s3Array.get(3);
                break;
            case "4":
                chordNotes += ", " + s3Array.get(4);
                break;
            case "5":
                chordNotes += ", " + s3Array.get(5);
                break;
            case "6":
                chordNotes += ", " + s3Array.get(6);
                break;
            case "7":
                chordNotes += ", " + s3Array.get(7);
                break;
            case "8":
                chordNotes += ", " + s3Array.get(8);
                break;
            case "9":
                chordNotes += ", " + s3Array.get(9);
                break;
            case "10":
                chordNotes += ", " + s3Array.get(10);
                break;
            case "11":
                chordNotes += ", " + s3Array.get(11);
                break;
            case "12":
                chordNotes += ", " + s3Array.get(12);
                break;
        }

        switch (s4){
            case "0":
                chordNotes += ", " + s4Array.get(0);
                break;
            case "1":
                chordNotes += ", " + s4Array.get(1);
                break;
            case "2":
                chordNotes += ", " + s4Array.get(2);
                break;
            case "3":
                chordNotes += ", " + s4Array.get(3);
                break;
            case "4":
                chordNotes += ", " + s4Array.get(4);
                break;
            case "5":
                chordNotes += ", " + s4Array.get(5);
                break;
            case "6":
                chordNotes += ", " + s4Array.get(6);
                break;
            case "7":
                chordNotes += ", " + s4Array.get(7);
                break;
            case "8":
                chordNotes += ", " + s4Array.get(8);
                break;
            case "9":
                chordNotes += ", " + s4Array.get(9);
                break;
            case "10":
                chordNotes += ", " + s4Array.get(10);
                break;
            case "11":
                chordNotes += ", " + s4Array.get(11);
                break;
            case "12":
                chordNotes += ", " + s4Array.get(12);
                break;
        }

        cursor = sqLiteDatabase.query("ukuleleChords", new String[]{ "name"}, "string1=? AND string2=? AND string3=? AND string4=?", new String[]{s1,s2,s3,s4}, null, null, null);
        cursor.moveToFirst();
        chordBuilderDBWrapper = new ChordBuilderDBWrapperUkulele(cursor);
        fingering = s1 + ", " + s2 + ", " + s3 + ", " + s4;
        if(cursor.getCount() == 0){
            textViewStrings.setText("Sorry!");
            textViewName.setText("No Matching Chord Found");
            textViewNotes.setText("Please Try Again");
        }
        else{
            textViewStrings.setText("Fingerings: " + fingering);
            textViewName.setText("Name: " + chordBuilderDBWrapper.getName());
            textViewNotes.setText("Notes of Chord: " + chordNotes);
        }
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
                contentValues.put("instrument", "ukulele");
                contentValues.put("chordName", chordBuilderDBWrapper.getName());
                contentValues.put("fingering",fingering);
                contentValues.put("chordNotes", chordNotes);
                SQLiteDatabase sqLiteDatabase = chordBuilderDBHelper.getWritableDatabase();
                sqLiteDatabase.insert("userChords",null,contentValues);
                savedChordAdapter.notifyDataSetChanged();
                Intent intent1 = new Intent(getApplicationContext(), SavedChordsActivity.class);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}