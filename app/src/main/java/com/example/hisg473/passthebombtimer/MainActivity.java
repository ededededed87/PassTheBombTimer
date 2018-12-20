package com.example.hisg473.passthebombtimer;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTimer(View view) {

        EditText minimumTime = findViewById(R.id.minimumEntry);
        EditText maximumTime = findViewById(R.id.maximumEntry);

        String min = minimumTime.getText().toString();
        String max = maximumTime.getText().toString();

        int a = Integer.parseInt(min);
        int b = Integer.parseInt(max);

        int timeToCountdownInMilliseconds = ((int) ((Math.random() * b) + a)) * 1000;

        ImageView bomb = findViewById(R.id.bombImage);
        bomb.setImageResource(R.drawable.fuse);

        Timer timer = new Timer();


        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        playSound();
                        ImageView bomb = findViewById(R.id.bombImage);
                        bomb.setImageResource(R.drawable.explosion);
                    }
                });

            }
        };


        timer.schedule(task, timeToCountdownInMilliseconds);


    }

    private void playSound() {

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.explosion );
        mp.start();

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

    }


}
