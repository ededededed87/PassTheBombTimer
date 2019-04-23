package com.example.hisg473.passthebombtimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goToTeamsPage(View view) {

        Intent myIntent = new Intent(view.getContext(), TeamsActivity.class);
        startActivityForResult(myIntent, 0);

    }

    public void goToBombPage(View view) {

        Intent myIntent = new Intent(view.getContext(), PassTheBombActivity.class);
        startActivityForResult(myIntent, 0);

    }
}
