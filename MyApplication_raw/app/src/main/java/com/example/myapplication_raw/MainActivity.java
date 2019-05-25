package com.example.myapplication_raw;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonstart;
    private Button buttonstop;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonstart = (Button)findViewById(R.id.buttonStart);
        buttonstop = (Button)findViewById(R.id.buttonStop);
        buttonstart.setOnClickListener(this);
        buttonstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.buttonStart) {
            mediaPlayer = MediaPlayer.create(this, R.raw.twice_likey);
            mediaPlayer.start();

        }else{
            mediaPlayer.stop();
        }

    }
}