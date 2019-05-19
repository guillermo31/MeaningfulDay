package com.guillermoramos.meaningfulday.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.guillermoramos.meaningfulday.R;

public class MainActivity extends AppCompatActivity
{

    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                openAddScreen();
            }
        });

    }

    public void openAddScreen()
    {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }


}
