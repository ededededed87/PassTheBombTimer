package com.example.hisg473.passthebombtimer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamsActivity extends Activity {

    List<String> players = new ArrayList<>();
    List<String> team1 = new ArrayList<>();
    List<String> team2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
    }

    public void generateTeams(View view) {

        players.clear();
        team1.clear();
        team2.clear();
        makeListOfPlayers();
        Collections.shuffle(players);
        splitIntoTwoTeams();
        displayTeams();

    }

    private void displayTeams() {

        TextView team1Player1 = (TextView) findViewById(R.id.team1Player1);
        TextView team1Player2 = (TextView) findViewById(R.id.team1Player2);
        TextView team1Player3 = (TextView) findViewById(R.id.team1Player3);
        TextView team1Player4 = (TextView) findViewById(R.id.team1Player4);
        TextView team1Player5 = (TextView) findViewById(R.id.team1Player5);
        TextView team1Player6 = (TextView) findViewById(R.id.team1Player6);
        TextView team2Player1 = (TextView) findViewById(R.id.team2Player1);
        TextView team2Player2 = (TextView) findViewById(R.id.team2Player2);
        TextView team2Player3 = (TextView) findViewById(R.id.team2Player3);
        TextView team2Player4 = (TextView) findViewById(R.id.team2Player4);
        TextView team2Player5 = (TextView) findViewById(R.id.team2Player5);
        TextView team2Player6 = (TextView) findViewById(R.id.team2Player6);

        team1Player1.setText(team1.get(0));
        team1Player2.setText(team1.get(1));
        team1Player3.setText(team1.get(2));
        team1Player4.setText(team1.get(3));
        team1Player5.setText(team1.get(4));
        team1Player6.setText(team1.get(5));

        team2Player1.setText(team2.get(0));
        team2Player2.setText(team2.get(1));
        team2Player3.setText(team2.get(2));
        team2Player4.setText(team2.get(3));
        team2Player5.setText(team2.get(4));
        team2Player6.setText(team2.get(5));
    }

    private void splitIntoTwoTeams() {
        int teamToAddTo = 1;
        for (String player : players) {
            if (teamToAddTo == 1) {
                team1.add(player);
                teamToAddTo = 2;
            }
            else {
                team2.add(player);
                teamToAddTo = 1;
            }
        }
        fillTeamLists();
    }

    private void fillTeamLists() {

        while (team1.size() != 6) {
            team1.add("");
        }

        while (team2.size() != 6) {
            team2.add("");
        }

    }

    private void makeListOfPlayers() {
        CheckBox yasCheckbox = (CheckBox) findViewById(R.id.YasCheckbox);
        CheckBox edCheckbox = (CheckBox) findViewById(R.id.EdCheckbox);
        CheckBox lauraCheckbox = (CheckBox) findViewById(R.id.LauraCheckbox);
        CheckBox peterCheckbox = (CheckBox) findViewById(R.id.PeterCheckbox);
        CheckBox jamesCheckbox = (CheckBox) findViewById(R.id.JamesCheckbox);
        CheckBox livCheckbox = (CheckBox) findViewById(R.id.LivCheckbox);
        CheckBox tomCheckbox = (CheckBox) findViewById(R.id.TomCheckbox);
        CheckBox georginaCheckbox = (CheckBox) findViewById(R.id.GeorginaCheckbox);

        CheckBox[] checkboxes = {yasCheckbox, edCheckbox, lauraCheckbox, peterCheckbox, jamesCheckbox, livCheckbox, tomCheckbox, georginaCheckbox};

        for (CheckBox checkbox : checkboxes) {
            if (checkbox.isChecked()) {
                players.add(String.valueOf(checkbox.getText()));
            }
        }

        EditText extraPlayer1 = (EditText) findViewById(R.id.extraPerson1);
        EditText extraPlayer2 = (EditText) findViewById(R.id.extraPerson2);
        EditText extraPlayer3 = (EditText) findViewById(R.id.extraPerson3);
        EditText extraPlayer4 = (EditText) findViewById(R.id.extraPerson4);

        String[] extraPlayers = {String.valueOf(extraPlayer1.getText()), String.valueOf(extraPlayer2.getText()), String.valueOf(extraPlayer3.getText()), String.valueOf(extraPlayer4.getText())};

        for (String player : extraPlayers) {
            if (!player.equals("")) {
                players.add(player);
            }
        }
    }
}
