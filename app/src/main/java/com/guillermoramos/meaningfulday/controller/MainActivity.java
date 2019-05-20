package com.guillermoramos.meaningfulday.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guillermoramos.meaningfulday.R;
import com.guillermoramos.meaningfulday.model.MeaningfulTask;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private Button progressButton;
    private Button updateButton;
    private Button viewButton;
    static ArrayList<MeaningfulTask> taskList;
    static int dailyGoal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadTaskList();
        loadDailyGoal();

        final EditText updatedGoal = findViewById(R.id.dailyGoalInput);

        addButton = (Button) findViewById(R.id.add_button);
        progressButton = (Button) findViewById(R.id.progressPage);
        updateButton = (Button) findViewById(R.id.udpateButton);
        viewButton = (Button) findViewById(R.id.viewButton);

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openAddScreen();
            }
        });
        progressButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openProgressScreen();
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String value = updatedGoal.getText().toString();
                dailyGoal = Integer.parseInt(value);
                saveDailyGoal();
            }
        });
        viewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openViewScreen();
            }
        });

    }

    private void openViewScreen()
    {
        Intent intent = new Intent(this, ViewHistoryActivity.class);
        startActivity(intent);
    }

    /**
     * Method that creates the intent of opening the AddActivity
     */
    public void openAddScreen() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    /**
     * Method that creates the intent of opening the ProgressActivity
     */
    public void openProgressScreen() {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }

    /**
     * Loads the serialized taskList ArrayList from the device's storage onto the running program
     */
    public void loadTaskList()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<MeaningfulTask>>() {}.getType();
        taskList = gson.fromJson(json, type);

        if (taskList == null)
        {
            taskList = new ArrayList<>();
        }
    }

    /**
     * Loads the serialized dailyGoal integer variable from the device's storage
     */
    public void loadDailyGoal()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", 0);
        dailyGoal = sharedPreferences.getInt("daily goal", 0);
    }

    /**
     * Saves the dailyGoal integer variable into the device's storage
     */
    public void saveDailyGoal()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("daily goal", dailyGoal).commit();
    }


}