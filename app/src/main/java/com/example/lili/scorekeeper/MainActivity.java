package com.example.lili.scorekeeper;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putInt("scoreTeamA", scoreTeamA);
        saveInstanceState.putInt("scoreTeamB", scoreTeamB);
        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void resetScor(View v) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
    }

    public void displayForTeamA(int score) {
        TextView scoreView1 = (TextView) findViewById(R.id.team_a_score);
        scoreView1.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView2 = (TextView) findViewById(R.id.team_b_score);
        scoreView2.setText(String.valueOf(score));
    }

    public void increaseTeamA(View view) {
        if (scoreTeamA == 100) {
            Toast.makeText(this, "You cannot have more than 100 points", Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void increaseTeamB(View view) {
        if (scoreTeamB == 100) {
            Toast.makeText(this, "You cannot have more than 100 points", Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void decreaseTeamA(View view) {
        if (scoreTeamA == 0) {
            Toast.makeText(this, "You cannot have less than 0 point", Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamA = scoreTeamA - 1;
        displayForTeamA(scoreTeamA);
    }

    public void decreaseTeamB(View view) {
        if (scoreTeamB == 0) {
            Toast.makeText(this, "You cannot have less than 0 point", Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamB = scoreTeamB - 1;
        displayForTeamB(scoreTeamB);
    }
}
