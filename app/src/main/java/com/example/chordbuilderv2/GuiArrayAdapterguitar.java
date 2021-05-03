package com.example.chordbuilderv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GuiArrayAdapterguitar extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public GuiArrayAdapterguitar(Context context, ArrayList<String> values) {
        super(context, R.layout.gui_images_guitar, values);
        this.context = context;
        this.values = values;
    }
    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.gui_images_guitar, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView2Guitar);

        if(values.get(position).equals("p")){
            imageView.setBackgroundResource(R.drawable.played);
        }
        else if(values.get(position).equals("x")){
            imageView.setBackgroundResource(R.drawable.muted);
        }
        else{
            imageView.setBackgroundResource(R.drawable.open);
        }
        return rowView;
    }
}
