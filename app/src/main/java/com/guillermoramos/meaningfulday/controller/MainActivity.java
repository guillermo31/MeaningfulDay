package com.guillermoramos.meaningfulday.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guillermoramos.meaningfulday.R;
import com.guillermoramos.meaningfulday.model.MeaningfulTask;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private Button progressButton;
    static ArrayList<MeaningfulTask> taskList;
    static int dailyGoal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<>();

        addButton = (Button) findViewById(R.id.add_button);
        progressButton = (Button) findViewById(R.id.progressPage);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddScreen();
            }
        });
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProgressScreen();
            }
        });

    }

    public void openAddScreen() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void openProgressScreen() {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }


}