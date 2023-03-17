package ru.alex.lab1.pojo;

import androidx.recyclerview.widget.RecyclerView;

import ru.alex.lab1.recycler.RecyclerViewElement;

public class Title implements RecyclerViewElement {
    public Title() {
    }

    @Override
    public int getViewType() {
        return RecyclerViewElement.TITLE;
    }

    @Override
    public void onBindHandler(RecyclerView.ViewHolder viewHolder) {

    }
}
