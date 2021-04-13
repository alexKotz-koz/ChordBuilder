package com.example.chordbuilderv2;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.EditText;

import java.io.IOException;
import java.sql.Time;

public class MetronomeThread extends HandlerThread {
    private Handler mainHandler;
    Context context;
    EditText bpm;
    MediaPlayer mp;

    public MetronomeThread(Context context, Handler handler, EditText bpm) {
        super("MetronomeThread");
        this.bpm = bpm;
        this.mainHandler = handler;
        this.context = context;
        mp = MetronomeMediaPlayer.getMediaPlayer();
    }

    @Override
    public void run() {
        //AssetFileDescriptor file = context.getResources().openRawResourceFd(R.raw.stick);
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
            Message message = Message.obtain();
            message.what = 2;
            mainHandler.sendMessage(message);
        } else {

                System.out.println("THREAD:" + bpm);
                mp = MediaPlayer.create(context, R.raw.stick);
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mp.start();
                    }
                });
                mainHandler.postDelayed(this, 1000);


        }
    }
}