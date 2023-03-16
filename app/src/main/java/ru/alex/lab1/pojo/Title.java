package ru.alex.lab1.pojo;

import androidx.recyclerview.widget.RecyclerView;

import ru.alex.lab1.recycler.ElementType;

public class Title implements ElementType {
    public Title() {
    }

    @Override
    public int getViewType() {
        return ElementType.TITLE;
    }

    @Override
    public void onBindHandler(RecyclerView.ViewHolder viewHolder) {

    }
}
