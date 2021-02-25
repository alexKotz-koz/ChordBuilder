package com.example.chordbuilderv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChordBuilderDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "ukuleleChords.sqlite";
    public static final int DB_VERSION = 1;
    public ChordBuilderDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE ukuleleChords (_id INTEGER PRIMARY KEY, name TEXT, string1 INTEGER, string2 INTEGER, string3 INTEGER, string4 INTEGER )";
        sqLiteDatabase.execSQL(query);
        String insertQuery = "INSERT INTO ukuleleChords\n" +
                "\t\t(name, string1, string2, string3, string4)\n" +
                "\tVALUES\n" +
                "\t\t(\"C\", 0, 0 ,0, 3),\n" +
                "\t\t(\"C7\", 0, 0 ,0, 1),\n" +
                "\t\t(\"Cm\", 0, 3 ,3, 3),\n" +
                "\t\t(\"Cm7\", 3, 3 ,3, 3),\n" +
                "\t\t(\"Cdim\", 2, 3 ,2, 3),\n" +
                "\t\t(\"Caug\", 1, 0 ,0, 3),\n" +
                "\t\t(\"C6\", 0, 0 ,0, 0),\n" +
                "\t\t(\"Cmaj7\", 0, 0 ,0, 2),\n" +
                "\t\t(\"C9\", 0, 2 ,0, 1),\n" +
                "\t\t(\"Db\", 1, 1 ,1, 4),\n" +
                "\t\t(\"Db7\", 1, 1 ,1, 2),\n" +
                "\t\t(\"Dbm\", 1, 1 ,0, 3),\n" +
                "\t\t(\"Dbm7\", 4, 4 ,4, 4),\n" +
                "\t\t(\"Dbdim\", 0, 1 ,0, 1),\n" +
                "\t\t(\"Dbaug\", 2, 1 ,1, 0),\n" +
                "\t\t(\"Db6\", 1, 1 ,1, 1),\n" +
                "\t\t(\"Dbmaj7\", 1, 1 ,1, 3),\n" +
                "\t\t(\"Db9\", 1, 3 ,1, 2),\n" +
                "\t\t(\"D\", 2, 2 ,2, 5),\n" +
                "\t\t(\"D7\", 2, 2 ,2, 3),\n" +
                "\t\t(\"Dm\", 2, 2 ,1, 0),\n" +
                "\t\t(\"Dm7\", 2, 2 ,1, 3),\n" +
                "\t\t(\"Ddim\", 1, 2 ,1, 2),\n" +
                "\t\t(\"Daug\", 3, 2 ,2, 1),\n" +
                "\t\t(\"D6\", 2, 2 ,2, 2),\n" +
                "\t\t(\"Dmaj7\", 2, 2 ,2, 4),\n" +
                "\t\t(\"D9\", 2, 4 ,2, 3),\n" +
                "\t\t(\"Eb\", 3, 3 ,3, 1),\n" +
                "\t\t(\"Eb7\", 3, 3 ,3, 4),\n" +
                "\t\t(\"Ebm\", 3, 3 ,2, 1),\n" +
                "\t\t(\"Ebm7\", 3, 3 ,2, 4),\n" +
                "\t\t(\"Ebdim\", 2, 3 ,2, 3),\n" +
                "\t\t(\"Ebaug\", 2, 1 ,1, 4),\n" +
                "\t\t(\"Eb6\", 3, 3 ,3, 3),\n" +
                "\t\t(\"Ebmaj7\", 3, 3 ,3, 0),\n" +
                "\t\t(\"Eb9\", 0, 1 ,1, 1),\n" +
                "\t\t(\"E\", 4, 4 ,4, 2),\n" +
                "\t\t(\"E7\", 1, 2 ,0, 2),\n" +
                "\t\t(\"Em\", 0, 4 ,3, 2),\n" +
                "\t\t(\"Em7\", 0, 2 ,0, 2),\n" +
                "\t\t(\"Edim\", 0, 1 ,0, 1),\n" +
                "\t\t(\"Eaug\", 1, 0 ,0, 3),\n" +
                "\t\t(\"E6\", 1, 0 ,2, 0),\n" +
                "\t\t(\"Emaj7\", 1, 3 ,0, 2),\n" +
                "\t\t(\"E9\", 1, 2 ,2, 2),\n" +
                "\t\t(\"F\", 2, 0 ,1, 0),\n" +
                "\t\t(\"F7\", 2, 3 ,1, 0),\n" +
                "\t\t(\"Fm\", 1, 0 ,1, 3),\n" +
                "\t\t(\"Fm7\", 1, 3 ,1, 3),\n" +
                "\t\t(\"Fdim\", 1, 2 ,1, 2),\n" +
                "\t\t(\"Faug\", 2, 1 ,1, 0),\n" +
                "\t\t(\"F6\", 2, 2 ,1, 3),\n" +
                "\t\t(\"Fmaj7\", 2, 4 ,1, 3),\n" +
                "\t\t(\"F9\", 2, 3 ,3, 3),\n" +
                "\t\t(\"Gb\", 3, 1 ,2, 1),\n" +
                "\t\t(\"Gb7\", 3, 4 ,2, 4),\n" +
                "\t\t(\"Gbm\", 2, 1 ,2, 0),\n" +
                "\t\t(\"Gbm7\", 2, 4 ,2, 4),\n" +
                "\t\t(\"Gbdim\", 2, 3 ,2, 3),\n" +
                "\t\t(\"Gbaug\", 4, 3 ,2, 2),\n" +
                "\t\t(\"Gb6\", 3, 3 ,2, 4),\n" +
                "\t\t(\"Gbmaj7\", 0, 1 ,1, 1),\n" +
                "\t\t(\"Gb9\", 1, 1 ,0, 1),\n" +
                "\t\t(\"G\", 0, 2 ,3, 2),\n" +
                "\t\t(\"G7\", 0, 2 ,1, 2),\n" +
                "\t\t(\"Gm\", 0, 2 ,3, 1),\n" +
                "\t\t(\"Gm7\", 0, 2 ,1, 1),\n" +
                "\t\t(\"Gdim\", 0, 1 ,0, 1),\n" +
                "\t\t(\"Gaug\", 4, 3 ,3, 2),\n" +
                "\t\t(\"G6\", 0, 2 ,0, 2),\n" +
                "\t\t(\"Gmaj7\", 0, 2 ,2, 2),\n" +
                "\t\t(\"G9\", 2, 2 ,1, 2),\n" +
                "\t\t(\"Ab\", 5, 3 ,4, 3),\n" +
                "\t\t(\"Ab7\", 1, 3 ,2, 3),\n" +
                "\t\t(\"Abm\", 1, 3 ,4, 2),\n" +
                "\t\t(\"Abm7\", 0, 3 ,2, 2),\n" +
                "\t\t(\"Abdim\", 1, 2 ,1, 2),\n" +
                "\t\t(\"Abaug\", 1, 0 ,0, 0),\n" +
                "\t\t(\"Ab6\", 1, 3 ,1, 3),\n" +
                "\t\t(\"Abmaj7\", 1, 3 ,3, 3),\n" +
                "\t\t(\"Ab9\", 3, 3 ,2, 3),\n" +
                "\t\t(\"A\", 2, 1 ,0, 0),\n" +
                "\t\t(\"A7\", 0, 1 ,0, 0),\n" +
                "\t\t(\"Am\", 2, 0 ,0, 0),\n" +
                "\t\t(\"Am7\", 0, 4 ,3, 3),\n" +
                "\t\t(\"Adim\", 2, 3 ,2, 3),\n" +
                "\t\t(\"Aaug\", 2, 1 ,1, 1),\n" +
                "\t\t(\"A6\", 2, 4 ,2, 4),\n" +
                "\t\t(\"Amaj7\", 1, 1 ,0, 0),\n" +
                "\t\t(\"A9\", 0, 1 ,0, 2),\n" +
                "\t\t(\"Bb\", 3, 2 ,1, 1),\n" +
                "\t\t(\"Bb7\", 1, 2 ,1, 1),\n" +
                "\t\t(\"Bbm\", 3, 1 ,1, 1),\n" +
                "\t\t(\"Bbm7\", 1, 1 ,1, 1),\n" +
                "\t\t(\"Bbdim\", 0, 1 ,0, 1),\n" +
                "\t\t(\"Bbaug\", 3, 2 ,2, 1),\n" +
                "\t\t(\"Bb6\", 0, 2 ,1, 1),\n" +
                "\t\t(\"Bbmaj7\", 3, 2 ,1, 0),\n" +
                "\t\t(\"Bb9\", 1, 2 ,1, 3),\n" +
                "\t\t(\"B\", 4, 3 ,2, 2),\n" +
                "\t\t(\"B7\", 2, 3 ,2, 2),\n" +
                "\t\t(\"Bm\", 4, 2 ,2, 2),\n" +
                "\t\t(\"Bm7\", 2, 2 ,2, 2),\n" +
                "\t\t(\"Bdim\", 1, 2 ,1, 2),\n" +
                "\t\t(\"Baug\", 4, 3 ,3, 2),\n" +
                "\t\t(\"B6\", 1, 3 ,2, 2),\n" +
                "\t\t(\"Bmaj7\", 3, 3 ,2, 2),\n" +
                "\t\t(\"B9\", 2, 3 ,2, 4);";
        sqLiteDatabase.execSQL(insertQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
