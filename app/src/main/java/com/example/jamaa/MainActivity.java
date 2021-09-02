package com.example.jamaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int progress = getProgress();
        ProgressBar TalkProgress = (ProgressBar) findViewById(R.id.TalkProgress);
        TalkProgress.setProgress(progress);

    }

    public void onReset(View view) {
        ProgressBar TalkProgress = (ProgressBar) findViewById(R.id.TalkProgress);
        TalkProgress.setProgress(0);
        saveProgress();
    }

    public void onTalkPlus(View view) {
        ProgressBar TalkProgress = (ProgressBar) findViewById(R.id.TalkProgress);
        TalkProgress.setProgress(TalkProgress.getProgress() + 10);
        saveProgress();
    }

    public void onTalkMinus(View view) {
        ProgressBar TalkProgress = (ProgressBar) findViewById(R.id.TalkProgress);
        TalkProgress.setProgress(TalkProgress.getProgress() - 10);
        saveProgress();
    }

    public void saveProgress() {
        /*
        saves progress data to cache
         */
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        ProgressBar TalkProgress = (ProgressBar) findViewById(R.id.TalkProgress);
        editor.putInt(getString(R.string.saved_progress), TalkProgress.getProgress());
        editor.apply();
    }

    public int getProgress()
    {
        /*
        gets progress data from cache
         */
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getInt(getString(R.string.saved_progress), 0);
    }

}