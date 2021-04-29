package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GUIGridUkulele extends AppCompatActivity {
    ListView listViewG;
    ListView listViewC;
    ListView listViewE;
    ListView listViewA;
    ArrayList<String> listG = new ArrayList<>();
    ArrayList<String> listC = new ArrayList<>();
    ArrayList<String> listE = new ArrayList<>();
    ArrayList<String> listA = new ArrayList<>();
    GUIArrayAdapter adapterG;
    GUIArrayAdapter adapterC;
    GUIArrayAdapter adapterE;
    GUIArrayAdapter adapterA;
    boolean openG;
    boolean openC;
    boolean openE;
    boolean openA;

    ArrayList<String> finalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_u_i_grid_ukulele);

        openG = true;
        openC = true;
        openE = true;
        openA = true;

        for(int i=0; i<4; i++){
            finalList.add("0");
        }

        for(int i=0; i<5; i++){
            listG.add("o");
            listC.add("o");
            listE.add("o");
            listA.add("o");
        }

        adapterG = new GUIArrayAdapter(this, listG);
        listViewG = findViewById(R.id.listViewStringGSaved);
        listViewG.setAdapter(adapterG);

        listViewG.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!openG && listG.get(i).equals("o")){
                    Toast.makeText(getApplicationContext(), "note already exists for string G please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(!openG && listG.get(i).equals("p")){
                    listG.set(i, "o");
                    openG = true;
                    finalList.set(0, "0");

                }
                else{
                    openG = false;
                    listG.set(i, "p");
                    finalList.set(0, String.valueOf(i+1));
                }
                adapterG.notifyDataSetChanged();
            }
        });

        adapterC = new GUIArrayAdapter(this, listC);
        listViewC = findViewById(R.id.listViewStringCSaved);
        listViewC.setAdapter(adapterC);

        listViewC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!openC && listC.get(i).equals("o")){
                    Toast.makeText(getApplicationContext(), "note already exists for string C please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(!openC && listC.get(i).equals("p")){
                    listC.set(i, "o");
                    openC = true;
                    finalList.set(1, "0");
                }
                else{
                    openC = false;
                    listC.set(i, "p");
                    finalList.set(1, String.valueOf(i+1));
                }
                adapterC.notifyDataSetChanged();
            }
        });

        adapterE = new GUIArrayAdapter(this, listE);
        listViewE = findViewById(R.id.listViewStringESaved);
        listViewE.setAdapter(adapterE);

        listViewE.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!openE && listE.get(i).equals("o")){
                    Toast.makeText(getApplicationContext(), "note already exists for string E please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(!openE && listE.get(i).equals("p")){
                    listE.set(i, "o");
                    openE = true;
                    finalList.set(2, "0");
                }
                else{
                    openE = false;
                    listE.set(i, "p");
                    finalList.set(2, String.valueOf(i+1));
                }
                adapterE.notifyDataSetChanged();
            }
        });

        adapterA = new GUIArrayAdapter(this, listA);
        listViewA = findViewById(R.id.listViewStringASaved);
        listViewA.setAdapter(adapterA);

        listViewA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!openA && listA.get(i).equals("o")){
                    Toast.makeText(getApplicationContext(), "note already exists for string A please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(!openA && listA.get(i).equals("p")){
                    listA.set(i, "o");
                    openA = true;
                    finalList.set(3, "0");
                }
                else{
                    openA = false;
                    listA.set(i, "p");
                    finalList.set(3, String.valueOf(i+1));
                }
                adapterA.notifyDataSetChanged();
            }
        });
    }

    public void submitClick(View view) {
        Intent intent = new Intent(getApplicationContext(),UkuleleActivity.class);
        intent.putExtra("finalist",finalList);
        startActivity(intent);
    }
}