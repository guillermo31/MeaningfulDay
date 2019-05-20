package com.guillermoramos.meaningfulday.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.guillermoramos.meaningfulday.R;
import com.guillermoramos.meaningfulday.model.MeaningfulTask;

public class ViewHistoryActivity extends AppCompatActivity
{
    private ViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        adapter = new ViewAdapter(recyclerView, this.getApplicationContext(), MainActivity.taskList);
    }
}
