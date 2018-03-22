package com.example.lili.scorekeeper;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String SCORE_TEAM_A_BUNDLE_KEY ="scoreTeamA";
    private final String SCORE_TEAM_B_BUNDLE_KEY ="scoreTeamB" ;

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putInt(SCORE_TEAM_A_BUNDLE_KEY, scoreTeamA);
        saveInstanceState.putInt(SCORE_TEAM_B_BUNDLE_KEY, scoreTeamB);

        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt(SCORE_TEAM_A_BUNDLE_KEY);
        scoreTeamB = savedInstanceState.getInt(SCORE_TEAM_B_BUNDLE_KEY);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    //Resets the score for both teams back to 0.
    public void resetScore(View v) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
    }

    // Displays the given score for Team A/TeamB.
    public void displayForTeamA(int score) {
        TextView scoreView1 = findViewById(R.id.team_a_score);
        scoreView1.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView2 = findViewById(R.id.team_b_score);
        scoreView2.setText(String.valueOf(score));
    }
    //

    //Increase the score for Team A/B by 1 point.
    public void increaseTeamA(View view) {
        if (scoreTeamA == 100) {
            Toast.makeText(this, getString(R.string.moreThat100), Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamA++;
        displayForTeamA(scoreTeamA);
    }

    public void increaseTeamB(View view) {
        if (scoreTeamB == 100) {
            Toast.makeText(this, getString(R.string.moreThat100), Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }
    //

    //Decrease the score for Team A/B by 1 point.
    public void decreaseTeamA(View view) {
        if (scoreTeamA == 0) {
            Toast.makeText(this, getString(R.string.lessThat0), Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamA--;
        displayForTeamA(scoreTeamA);
    }

    public void decreaseTeamB(View view) {
        if (scoreTeamB == 0) {
            Toast.makeText(this, getString(R.string.lessThat0), Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamB--;
        displayForTeamB(scoreTeamB);
    }
    //
}
