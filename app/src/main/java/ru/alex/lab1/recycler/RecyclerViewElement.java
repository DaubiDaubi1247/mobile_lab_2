package ru.alex.lab1.recycler;

import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerViewElement {
    int CARDS = 0;
    int TITLE = 1;

    int getViewType();

    void onBindHandler(RecyclerView.ViewHolder viewHolder);
}
