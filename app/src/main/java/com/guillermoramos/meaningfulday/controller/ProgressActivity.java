package com.guillermoramos.meaningfulday.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.guillermoramos.meaningfulday.R;

import java.util.ArrayList;
import java.util.List;

public class ProgressActivity extends AppCompatActivity
{
    private float dailyGoal = (float) MainActivity.dailyGoal;
    private float tasksDone = (float) MainActivity.taskList.size();

    /**
     * Method required by Android that makes initial setup work
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        setupPieChart();
    }

    /**
     * It sets up the necessary data to create a pie chart
     */
    private void setupPieChart()
    {
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(tasksDone, "Current Progress"));
        pieEntries.add(new PieEntry(dailyGoal, "Daily Goal"));

        PieDataSet dataSet = new PieDataSet(pieEntries, "Daily Goal Progress");
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);

        PieChart chart = (PieChart) findViewById(R.id.dailyGoalChart);
        chart.setData(data);
        chart.invalidate();

    }
}
