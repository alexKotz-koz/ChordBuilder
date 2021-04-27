package com.example.chordbuilderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GUIGridGuitar extends AppCompatActivity {
    ListView listViewE;
    ListView listViewA;
    ListView listViewD;
    ListView listViewG;
    ListView listViewB;
    ListView listViewEh;
    ArrayList<String> listE = new ArrayList<>();
    ArrayList<String> listA = new ArrayList<>();
    ArrayList<String> listD = new ArrayList<>();
    ArrayList<String> listG = new ArrayList<>();
    ArrayList<String> listB = new ArrayList<>();
    ArrayList<String> listEh = new ArrayList<>();
    GUIArrayAdapter adapterE;
    GUIArrayAdapter adapterA;
    GUIArrayAdapter adapterD;
    GUIArrayAdapter adapterG;
    GUIArrayAdapter adapterB;
    GUIArrayAdapter adapterEh;
    boolean openE;
    boolean openA;
    boolean openD;
    boolean openG;
    boolean openB;
    boolean openEh;

    ArrayList<String> finalList = new ArrayList<>();
    int state = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_u_i_grid_guitar);
        openE = true;
        openA = true;
        openD = true;
        openG = true;
        openB = true;
        openEh = true;

        for(int i=0; i<6; i++){
            finalList.add("0");
        }

        for(int i=0; i<5; i++){
            listE.add("o");
            listA.add("o");
            listD.add("o");
            listG.add("o");
            listB.add("o");
            listEh.add("o");
        }

        adapterE = new GUIArrayAdapter(this, listE);
        listViewE = findViewById(R.id.listViewStringESaved);
        listViewE.setAdapter(adapterE);

        listViewE.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(openE == false && listE.get(i) == "o"){
                    Toast.makeText(getApplicationContext(), "note already exists for string E please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(openE == false && listE.get(i) != "o"){
                    switch (state) {
                        case 0:
                            listE.set(i, "o");
                            finalList.set(0, "0");
                            break;
                        case 1:
                            listE.set(i, "p");
                            finalList.set(0, String.valueOf(i+1));
                            break;
                        case 2:
                            listE.set(i, "x");
                            finalList.set(0, "X");
                    }
                    if(listE.get(i) == "o"){
                        openE = true;
                    }
                }
                else{
                    switch (state) {
                        case 1:
                            listE.set(i, "p");
                            openE = false;
                            finalList.set(0, String.valueOf(i+1));
                            break;
                        case 2:
                            listE.set(i, "x");
                            openE = false;
                            finalList.set(0, "X");
                    }
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
                if(openA == false && listA.get(i) == "o"){
                    Toast.makeText(getApplicationContext(), "note already exists for string A please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(openA == false && listA.get(i) != "o"){
                    switch (state) {
                        case 0:
                            listA.set(i, "o");
                            finalList.set(1, "0");
                            break;
                        case 1:
                            listA.set(i, "p");
                            finalList.set(1, String.valueOf(i+1));
                            break;
                        case 2:
                            listA.set(i, "x");
                            finalList.set(1, "X");
                    }
                    if(listA.get(i) == "o"){
                        openA = true;
                    }
                }
                else{
                    switch (state) {
                        case 1:
                            listA.set(i, "p");
                            openA = false;
                            finalList.set(1, String.valueOf(i+1));
                            break;
                        case 2:
                            listA.set(i, "x");
                            openA = false;
                            finalList.set(1, "X");
                    }
                }
                adapterA.notifyDataSetChanged();
            }
        });

        adapterD = new GUIArrayAdapter(this, listD);
        listViewD = findViewById(R.id.listViewStringD);
        listViewD.setAdapter(adapterD);

        listViewD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(openD == false && listD.get(i) == "o"){
                    Toast.makeText(getApplicationContext(), "note already exists for string D please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(openD == false && listD.get(i) != "o"){
                    switch (state) {
                        case 0:
                            listD.set(i, "o");
                            finalList.set(2, "0");
                            break;
                        case 1:
                            listD.set(i, "p");
                            finalList.set(2, String.valueOf(i+1));
                            break;
                        case 2:
                            listD.set(i, "x");
                            finalList.set(2, "X");
                    }
                    if(listD.get(i) == "o"){
                        openD = true;
                    }
                }
                else {
                    switch (state) {
                        case 1:
                            listD.set(i, "p");
                            openD = false;
                            finalList.set(2, String.valueOf(i+1));
                            break;
                        case 2:
                            listD.set(i, "x");
                            openD = false;
                            finalList.set(2, "X");
                    }
                }
                adapterD.notifyDataSetChanged();
            }
        });

        adapterG = new GUIArrayAdapter(this, listG);
        listViewG = findViewById(R.id.listViewStringGSaved);
        listViewG.setAdapter(adapterG);

        listViewG.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!openG && listG.get(i) == "o"){
                    Toast.makeText(getApplicationContext(), "note already exists for string G please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(!openG && listG.get(i) != "o"){
                    switch (state) {
                        case 0:
                            listG.set(i, "o");
                            finalList.set(3, "0");
                            break;
                        case 1:
                            listG.set(i, "p");
                            finalList.set(3, String.valueOf(i+1));
                            break;
                        case 2:
                            listG.set(i, "x");
                            finalList.set(3, "X");
                    }
                    if(listG.get(i) == "o"){
                        openG = true;
                    }
                }
                else{
                    switch (state) {
                        case 1:
                            listG.set(i, "p");
                            openG = false;
                            finalList.set(3, String.valueOf(i+1));
                            break;
                        case 2:
                            listG.set(i, "x");
                            openG = false;
                            finalList.set(3, "X");
                    }
                }
                adapterG.notifyDataSetChanged();
            }
        });

        adapterB = new GUIArrayAdapter(this, listB);
        listViewB = findViewById(R.id.listViewStringB);
        listViewB.setAdapter(adapterB);

        listViewB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!openB && listB.get(i).equals("o")){
                    Toast.makeText(getApplicationContext(), "note already exists for string B please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(!openB && !listB.get(i).equals("o")){
                    switch (state) {
                        case 0:
                            listB.set(i, "o");
                            finalList.set(4, "0");
                            break;
                        case 1:
                            listB.set(i, "p");
                            finalList.set(4, String.valueOf(i+1));
                            break;
                        case 2:
                            listB.set(i, "x");
                            finalList.set(4, "X");
                    }
                    if(listB.get(i) == "o"){
                        openB = true;
                    }
                }
                else{
                    switch (state) {
                        case 1:
                            listB.set(i, "p");
                            openB = false;
                            finalList.set(4, String.valueOf(i+1));
                            break;
                        case 2:
                            listB.set(i, "x");
                            openB = false;
                            finalList.set(4, "X");
                    }
                }
                adapterB.notifyDataSetChanged();
            }
        });


        adapterEh = new GUIArrayAdapter(this, listEh);
        listViewEh = findViewById(R.id.listViewStringEh);
        listViewEh.setAdapter(adapterEh);

        listViewEh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!openEh && listEh.get(i).equals("o")){
                    Toast.makeText(getApplicationContext(), "note already exists for string Eh please deselect it to add a new one.", Toast.LENGTH_LONG).show();
                }
                else if(!openEh && !listEh.get(i).equals("o")){
                    switch (state) {
                        case 0:
                            listEh.set(i, "o");
                            finalList.set(5, "0");
                            break;
                        case 1:
                            listEh.set(i, "p");
                            finalList.set(5, String.valueOf(i+1));
                            break;
                        case 2:
                            listEh.set(i, "x");
                            finalList.set(5, "X");
                    }
                    if(listEh.get(i).equals("o")){
                        openEh = true;
                    }
                }
                else{
                    switch (state) {
                        case 1:
                            listEh.set(i, "p");
                            openEh = false;
                            finalList.set(5, String.valueOf(i+1));
                            break;
                        case 2:
                            listEh.set(i, "x");
                            openEh = false;
                            finalList.set(5, "X");
                    }
                }
                adapterEh.notifyDataSetChanged();
            }
        });
    }



    public void submitClick(View view) {
        Intent intent = new Intent(getApplicationContext(),GuitarActivity.class);
        intent.putExtra("finalist",finalList);
        startActivity(intent);
    }
    public void mutedClick(View view) {
        state = 2;
    }

    public void playedClick(View view) {
        state = 1;
    }

    public void openClick(View view) {
        state = 0;
    }

}