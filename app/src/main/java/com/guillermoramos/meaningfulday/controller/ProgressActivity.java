package com.guillermoramos.meaningfulday.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.guillermoramos.meaningfulday.R;

import java.util.ArrayList;
import java.util.List;

public class ProgressActivity extends AppCompatActivity
{
    private float dailyGoal = 20;
    private float tasksDone = (float) MainActivity.taskList.size();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        setupPieChart();
    }

    private void setupPieChart()
    {
        String parameter = "Current Progress";
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(tasksDone, "Current Progress"));
        pieEntries.add(new PieEntry(dailyGoal, "Daily Goal"));

        PieDataSet dataSet = new PieDataSet(pieEntries, "Daily Goal Progress");
        PieData data = new PieData(dataSet);

        PieChart chart = (PieChart) findViewById(R.id.dailyGoalChart);

    }
}
