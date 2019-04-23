package com.example.hisg473.passthebombtimer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class PassTheBombActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomb);
    }

    public void startTimer(View view) {

        EditText minimumTimeInput = findViewById(R.id.minimumEntry);
        EditText maximumTimeInput = findViewById(R.id.maximumEntry);

        String minimumTimeAsString = minimumTimeInput.getText().toString();
        String maximumTimeAsString = maximumTimeInput.getText().toString();

        int minimumTime = Integer.parseInt(minimumTimeAsString);
        int maximumTime = Integer.parseInt(maximumTimeAsString);

        int timeToCountdownInMilliseconds = ((int) ((Math.random() * maximumTime) + minimumTime)) * 1000;

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
