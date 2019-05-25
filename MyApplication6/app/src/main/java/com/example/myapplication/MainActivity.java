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

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AssetFileDescriptor descriptor;
    private Button play;
    private Button pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager manager = getResources().getAssets();
        try {
            descriptor = manager.openFd("WINNER_MILLIONS");
        } catch (IOException e) {
            e.printStackTrace();
        }

        play = (Button)findViewById(R.id.paly);
        pause = (Button)findViewById(R.id.pause);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MediaPlayer mediaPlayer = new MediaPlayer();

        if(v.getId() == R.id.paly) {

            try {

                mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            if(mediaPlayer != null)
                mediaPlayer.stop();
        }
    }
}
