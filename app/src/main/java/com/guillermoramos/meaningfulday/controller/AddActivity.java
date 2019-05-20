package com.guillermoramos.meaningfulday.controller;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.guillermoramos.meaningfulday.R;
import com.guillermoramos.meaningfulday.model.MeaningfulTask;

import java.util.ArrayList;


public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private Button submitButton;
    private MeaningfulTask newMeaningfulTask;

    private ArrayList<MeaningfulTask> taskArrayList = new ArrayList<MeaningfulTask>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        submitButton = (Button) findViewById(R.id.submitButton);

        final Spinner categorySpinner = findViewById(R.id.task_categories);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
        categorySpinner.setOnItemSelectedListener(this);

        final EditText taskInput = findViewById(R.id.textInput);

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String task = taskInput.getText().toString();
                String category = categorySpinner.getSelectedItem().toString();

                newMeaningfulTask = new MeaningfulTask(task, category);

                taskArrayList.add(newMeaningfulTask);

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String category = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }


}
