package com.example.chordbuilderv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChordBuilderDBHelperSaved extends SQLiteOpenHelper {
    public static final String DB_NAME = "ukuleleChords.sqlite";
    public static final int DB_VERSION = 1;
    public ChordBuilderDBHelperSaved(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String userCreateQuery = "CREATE TABLE userChords (_id INTEGER PRIMARY KEY, instrument TEXT, chordName TEXT, fingering TEXT, chordNotes TEXT)";
        sqLiteDatabase.execSQL(userCreateQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
