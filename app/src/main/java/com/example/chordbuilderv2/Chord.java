package com.example.chordbuilderv2;

import java.util.ArrayList;

public class Chord {
    public static ArrayList<Chord> chordArrayList = new ArrayList<Chord>();
    private String chordName;
    private String chordFingering;
    private String chordNotes;

    public Chord(String chordName, String chordFingering, String chordNotes){
        this.chordName = chordName;
        this.chordFingering = chordFingering;
        this.chordNotes = chordNotes;
    }

    public String getChordName(){
        return chordName;
    }
    public String getChordFingering(){
        return chordFingering;
    }
    public String getChordNotes(){
        return chordNotes;
    }

}
