package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
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
    ArrayAdapter<String> adapterG;
    ArrayAdapter<String> adapterC;
    ArrayAdapter<String> adapterE;
    ArrayAdapter<String> adapterA;
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

        adapterG = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listG
        );
        listViewG = findViewById(R.id.listViewStringG);
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

        adapterC = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listC
        );
        listViewC = findViewById(R.id.listViewStringC);
        listViewC.setAdapter(adapterC);

        listViewC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(openC == false && listC.get(i) == "o"){
                    Toast.makeText(getApplicationContext(), "note already exists for string C please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(openC == false && listC.get(i) == "p"){
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

        adapterE = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listE
        );
        listViewE = findViewById(R.id.listViewStringE);
        listViewE.setAdapter(adapterE);

        listViewE.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(openE == false && listE.get(i) == "o"){
                    Toast.makeText(getApplicationContext(), "note already exists for string E please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(openE == false && listE.get(i) == "p"){
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

        adapterA = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listA
        );
        listViewA = findViewById(R.id.listViewStringA);
        listViewA.setAdapter(adapterA);

        listViewA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!openA && listA.get(i) == "o"){
                    Toast.makeText(getApplicationContext(), "note already exists for string A please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(!openA && listA.get(i) == "p"){
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
        System.out.println("inSubmit");
    }
}