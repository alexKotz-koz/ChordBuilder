package com.example.chordbuilderv2;

import android.database.Cursor;

public class ChordBuilderDBWrapperUkulele {
    private Cursor cursor;
    String name = "";

    public ChordBuilderDBWrapperUkulele(Cursor cursor){
        this.cursor = cursor;
    }

    public String getName(){
        int col = cursor.getColumnIndex("name");
        name = cursor.getString(col);
        return name;
    }

}