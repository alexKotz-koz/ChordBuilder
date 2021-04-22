package com.example.chordbuilderv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChordBuilderDBHelperUkulele extends SQLiteOpenHelper {
    public static final String DB_NAME = "ukuleleChords.sqlite";
    public static final int DB_VERSION = 1;
    ChordBuilderDBContractUkulele chordBuilderDBContractUkulele;
    private static final String TABLE_USER_TABLE = "userChords";
    private static final String TABLE_UKULELE = "ukuleleChords";
    public ChordBuilderDBHelperUkulele(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        chordBuilderDBContractUkulele = new ChordBuilderDBContractUkulele();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ChordBuilderDBContractUkulele.SQL_CREATE_TABLE_UKULELE);
        db.execSQL(ChordBuilderDBContractUkulele.SQL_CREATE_USER_TABLE);
        db.execSQL(ChordBuilderDBContractUkulele.INSERT_UKULELE_CHORDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UKULELE );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_TABLE );
        onCreate(db);
    }
}