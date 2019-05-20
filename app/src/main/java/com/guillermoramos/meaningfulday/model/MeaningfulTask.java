package com.guillermoramos.meaningfulday.model;

public class MeaningfulTask
{
    private String task;
    private String category;

    public MeaningfulTask()
    {
        task = "reading";
        category = "academic";
    }
    public MeaningfulTask(String task, String category)
    {
        this.task = task;
        this.category = category;
    }
}
