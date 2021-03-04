package com.example.chordbuilderv2;

import android.database.Cursor;

public class ChordBuilderDBWrapperSaved {
    private Cursor cursor;

    public ChordBuilderDBWrapperSaved(Cursor cursor){
        this.cursor = cursor;
    }

    public String getInstrument(){
        int col = cursor.getColumnIndex("instrument");
        String instrument = cursor.getString(col);
        return instrument;
    }

    public String getChordName(){
        int col = cursor.getColumnIndex("chordName");
        String chordName = cursor.getString(col);
        return chordName;
    }

    public String getFingering(){
        int col = cursor.getColumnIndex("fingering");
        String fingering = cursor.getString(col);
        return fingering;
    }

    public String getChordNotes(){
        int col = cursor.getColumnIndex("chordNotes");
        String chordNotes = cursor.getString(col);
        return chordNotes;
    }
}
