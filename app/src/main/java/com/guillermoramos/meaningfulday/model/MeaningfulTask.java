package com.guillermoramos.meaningfulday.model;

public class MeaningfulTask
{
    private int dailyGoal;
    private String category;

    public MeaningfulTask()
    {

    }
    public MeaningfulTask(int goal, String category)
    {
        this.dailyGoal = goal;
        this.category = category;
    }
}
