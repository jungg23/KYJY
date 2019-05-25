package com.example.myapplication;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonstart;
    private Button buttonstop;
    private AssetFileDescriptor descriptor;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager am = getAssets();

        try {
            descriptor = am.openFd("TWICE-Heart_Shaker.mp3");
        } catch (IOException e) {
            Log.e("TEST", "IOException" + e.toString());
            e.printStackTrace();
        }
        buttonstart = (Button)findViewById(R.id.buttonStart);
        buttonstop = (Button)findViewById(R.id.buttonStop);
        buttonstart.setOnClickListener(this);
        buttonstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonStart) {
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(),descriptor.getLength());
                descriptor.close();
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            if(mediaPlayer != null)
                mediaPlayer.stop();
        }

    }
}
