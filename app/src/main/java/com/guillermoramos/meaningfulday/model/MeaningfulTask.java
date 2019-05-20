package com.guillermoramos.meaningfulday.model;

public class MeaningfulTask
{
    private String task;
    private String category;

    /**
     * Default constructor
     */
    public MeaningfulTask()
    {
        task = "reading";
        category = "academic";
    }

    /**
     * Constructor that inputs the task itself and its category
     * @param task  the task to be inputted by the user
     * @param category the category of the inputted task
     */
    public MeaningfulTask(String task, String category)
    {
        this.task = task;
        this.category = category;
    }

    public String getTask()
    {
        return task;
    }

    public String getCategory() {
        return category;
    }
}
