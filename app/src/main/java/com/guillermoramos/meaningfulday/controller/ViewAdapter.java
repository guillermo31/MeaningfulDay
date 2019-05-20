package com.guillermoramos.meaningfulday.controller;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guillermoramos.meaningfulday.R;
import com.guillermoramos.meaningfulday.model.MeaningfulTask;

import java.util.ArrayList;

public class ViewAdapter
{
    private Context mContext;
    private MyAdapter adapter;
    private ItemView itemView;
    private MyAdapter myAdapter;

    public ViewAdapter(RecyclerView recyclerView, Context context, ArrayList<MeaningfulTask> tasks)
    {
        setConfig(recyclerView, context, tasks);
    }

    public void setConfig(RecyclerView recyclerView, Context context, ArrayList<MeaningfulTask> tasks)
    {
        mContext = context;
        adapter = new MyAdapter(tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

    }

    class ItemView extends RecyclerView.ViewHolder
    {
        private TextView text;

        private String key;

        public ItemView(ViewGroup parent)
        {
            super(LayoutInflater.from(mContext).inflate(R.layout.task_item, parent, false));

            text = (TextView) itemView.findViewById(R.id.text);
        }

        public void bind(MeaningfulTask task)
        {
            text.setText(task.getTask());
        }

    }

    class MyAdapter extends RecyclerView.Adapter<ItemView>
    {
        private ArrayList<MeaningfulTask> tasks;

        public MyAdapter(ArrayList<MeaningfulTask> tasks)
        {
            this.tasks = tasks;
        }

        @Override
        public ItemView onCreateViewHolder(ViewGroup parent, int viewType)
        {
            return new ItemView(parent);
        }

        @Override
        public void onBindViewHolder(ItemView holder, int position)
        {
            holder.bind(tasks.get(position));

        }

        @Override
        public int getItemCount()
        {
            return tasks.size();
        }
    }
}
