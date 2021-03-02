package com.example.chordbuilderv2;

public class ChordBuilderContract {


    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_STRING_1 = "string1";
    public static final String COLUMN_STRING_2 = "string2";
    public static final String COLUMN_STRING_3 = "string3";
    public static final String COLUMN_STRING_4 = "string4";

    public static final String TABLE_NAME_UKULELE = "ukuleleChords";
    public static final String SQL_CREATE_TABLE_UKULELE="CREATE TABLE ukuleleChords (_id INTEGER PRIMARY KEY, name TEXT, string1 INTEGER, string2 INTEGER, string3 INTEGER, string4 INTEGER )";
    public static final String SQL_CREATE_USER_TABLE="CREATE TABLE userChords (_id INTEGER PRIMARY KEY, instrument TEXT, chordName TEXT, fingering TEXT, chordNotes TEXT)";

    public static final String TABLE_NAME_SAVED_GUITAR = "CREATE TABLE savedChords (_id INTEGER PRIMARY KEY, instrumentName TEXT, )";

}
