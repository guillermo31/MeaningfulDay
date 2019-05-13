package com.guillermoramos.meaningfulday;

import java.util.ArrayList;

public class TaskController
{
    private ArrayList<MeaningfulTask> taskArray = new ArrayList<MeaningfulTask>();

    public TaskController()
    {

    }
    public TaskController(ArrayList<MeaningfulTask> tasks)
    {
        tasks = new ArrayList<MeaningfulTask>(this.taskArray);
    }


}
