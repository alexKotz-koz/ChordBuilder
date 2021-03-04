package com.example.chordbuilderv2;

import android.database.Cursor;

public class ChordBuilderDBWrapperUkulele {
    private Cursor cursor;

    public ChordBuilderDBWrapperUkulele(Cursor cursor){
        this.cursor = cursor;
    }

    public String getName(){
        String name = "";
        if( cursor != null && cursor.moveToFirst() ){
            int col = cursor.getColumnIndex("name");
            name = cursor.getString(col);
            cursor.close();
        }

        return name;
    }

}