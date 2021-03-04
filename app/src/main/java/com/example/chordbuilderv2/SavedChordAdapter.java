package com.example.chordbuilderv2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SavedChordAdapter extends RecyclerView.Adapter {
    Chord chord;

    ChordBuilderDBContractUkulele contractSaved;
    ChordBuilderDBHelperSaved dBHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ChordBuilderDBWrapperSaved wrapperSaved;
    Context context;

    public SavedChordAdapter(Context context){
        this.context = context;
        contractSaved = new ChordBuilderDBContractUkulele();
        dBHelper = new ChordBuilderDBHelperSaved(context);
        sqLiteDatabase = dBHelper.getReadableDatabase();
        cursor = sqLiteDatabase.query("userChords", new String[]{"_id", "instrument", "chordName","fingering","chordNotes"}, null,null,null,null, null,null);
    }


    public static class ChordViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewChordNameText;
        public TextView textViewChordFingeringText;
        public TextView textViewChordNoteText;
        public TextView textViewInstrumentText;


        public ChordViewHolder(View view) {
            super(view);
            this.textViewChordNameText = view.findViewById(R.id.textViewChordNameText);
            this.textViewChordFingeringText = view.findViewById(R.id.textViewChordFingeringText);
            this.textViewChordNoteText = view.findViewById(R.id.textViewChordNoteText);
            this.textViewInstrumentText = view.findViewById(R.id.textViewInstrumentText);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_frame_saved_chord,parent,false);
        return new ChordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ChordViewHolder chordViewHolder = (ChordViewHolder) holder;
        wrapperSaved = new ChordBuilderDBWrapperSaved(cursor);

        cursor.moveToPosition(position);

        String fingering = wrapperSaved.getFingering();
        String chordName = wrapperSaved.getChordName();
        String chordNotes = wrapperSaved.getChordNotes();
        String instrument = wrapperSaved.getInstrument();
        chordViewHolder.textViewChordNoteText.setText(chordNotes);
        chordViewHolder.textViewChordNameText.setText(chordName);
        chordViewHolder.textViewChordFingeringText.setText(fingering);
        chordViewHolder.textViewInstrumentText.setText(instrument);

    }

    @Override
    public int getItemCount() {
        sqLiteDatabase =  dBHelper.getReadableDatabase();
        cursor = sqLiteDatabase.query("userChords", new String[]{"_id", "instrument", "chordName","fingering","chordNotes"}, null,null,null,null, null,null);
        return cursor.getCount();
    }
}
