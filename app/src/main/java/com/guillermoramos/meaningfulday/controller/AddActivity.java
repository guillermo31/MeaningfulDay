package com.guillermoramos.meaningfulday.controller;

import android.app.Activity;
import android.os.Bundle;

import com.guillermoramos.meaningfulday.R;
import com.guillermoramos.meaningfulday.model.MeaningfulTask;

import java.util.ArrayList;

public class AddActivity extends Activity
{
    private ArrayList<MeaningfulTask> taskArray = new ArrayList<MeaningfulTask>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
}
