package com.ricardogwill.mediaplayersongtest;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer songPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songPlayer = MediaPlayer.create(this, R.raw.donations_sting);

        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        Button buttonPause = (Button)findViewById(R.id.buttonPause);
        Button buttonStop = (Button)findViewById(R.id.buttonStop);


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songPlayer.start();
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songPlayer.pause();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songPlayer.stop();
                try {
                    songPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
