package com.example.chordbuilderv2;

public class ChordBuilderDBContractSaved {


    public static final String TABLE_NAME_UKULELE = "ukuleleChords";
    public static final String SQL_CREATE_TABLE_UKULELE="CREATE TABLE ukuleleChords (_id INTEGER PRIMARY KEY, name TEXT, string1 INTEGER, string2 INTEGER, string3 INTEGER, string4 INTEGER )";
    public static final String SQL_CREATE_USER_TABLE="CREATE TABLE userChords (_id INTEGER PRIMARY KEY, instrument TEXT, chordName TEXT, fingering TEXT, chordNotes TEXT)";

    public static final String TABLE_NAME_SAVED_GUITAR = "CREATE TABLE savedChords (_id INTEGER PRIMARY KEY, instrumentName TEXT, )";

}
