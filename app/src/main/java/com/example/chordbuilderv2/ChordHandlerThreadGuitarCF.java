package com.example.chordbuilderv2;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ChordHandlerThreadGuitarCF extends HandlerThread {
    String chord;
    Context context;
    private Handler mainHandler;
    String urlStrings = "";
    String urlFingering = "";
    String urlChordName = "";
    String urlVoicing = "";
    String urlChordNotes = "";

    static ArrayList <String> urlObject = new ArrayList<String>();

    public ChordHandlerThreadGuitarCF(Context context, Handler mainHandler, String chord) {
        super("ChordHandlerThreadGuitarCF");
        this.context = context;
        this.mainHandler = mainHandler;
        this.chord=chord;
    }

    @Override
    public void run() {
        try{
            URL url = new URL("https://api.uberchord.com/v1/chords/" + chord);
            System.out.println(url);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = bufferedReader.readLine();
            JSONArray jsonArray1 = new JSONArray(line);
            for (int i = 0; i < jsonArray1.length();i++){

                String urlObjects = jsonArray1.getString(i);
                JSONObject jsonObject = new JSONObject(urlObjects);
                for (int j=0; j < jsonObject.length(); j++){
                    urlStrings = jsonObject.getString("strings");
                    urlFingering = jsonObject.getString("fingering");
                    urlChordName = jsonObject.getString("chordName");
                    urlVoicing = jsonObject.getString("voicingID");
                    urlChordNotes = jsonObject.getString("tones");
                }
            }
            urlObject.add(urlStrings);
            urlObject.add(urlFingering);
            urlObject.add(urlChordName);
            urlObject.add(urlVoicing);
            urlObject.add(urlChordNotes);
            Message message = Message.obtain();
            message.what = 2;
            mainHandler.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> getURLArr(){
        return urlObject;
    }
}
