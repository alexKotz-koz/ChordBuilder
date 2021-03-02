package com.example.chordbuilderv2;

import android.database.Cursor;

public class ChordBuilderDBWrapper {
    private Cursor cursor;

    public ChordBuilderDBWrapper(Cursor cursor){
        this.cursor = cursor;
    }

    public String getName(){
        int col = cursor.getColumnIndex("name");
        String name = cursor.getString(col);
        return name;
    }
}
