package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class UkuleleActivity extends AppCompatActivity {

    ChordBuilderDBHelper chordBuilderDBHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ChordBuilderDBWrapper chordBuilderDBWrapper;
    ArrayList<Integer> preBuildChord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukulele);
        preBuildChord = (ArrayList<Integer>) getIntent().getSerializableExtra("finalist");
        String s1 = String.valueOf(preBuildChord.get(0));
        String s2 = String.valueOf(preBuildChord.get(1));
        String s3 = String.valueOf(preBuildChord.get(2));
        String s4 = String.valueOf(preBuildChord.get(3));
        chordBuilderDBHelper = new ChordBuilderDBHelper(getApplicationContext());
        sqLiteDatabase = chordBuilderDBHelper.getReadableDatabase();
        cursor = sqLiteDatabase.query("ukuleleChords", new String[]{ "name"}, "string1=? AND string2=? AND string3=? AND string4=?", new String[]{s1,s2,s3,s4}, null, null, null);
        cursor.moveToFirst();
        chordBuilderDBWrapper = new ChordBuilderDBWrapper(cursor);
        System.out.println(chordBuilderDBWrapper.getName());
    }
}