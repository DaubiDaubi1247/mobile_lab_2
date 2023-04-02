package ru.alex.lab1.pojo;

import android.graphics.Typeface;

import androidx.recyclerview.widget.RecyclerView;

import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.recycler.RecyclerViewElement;

public class MonsterListTitle implements RecyclerViewElement {

    private final String title;

    public MonsterListTitle(String title) {
        this.title = title;
    }

    @Override
    public int getViewType() {
        return RecyclerViewElement.MONSTER_LIST_TITLE;
    }

    @Override
    public void onBindHandler(RecyclerView.ViewHolder viewHolder) {
        CardPreviewAdapter.MonsterTitleViewHolder monsterTitleViewHolder = (CardPreviewAdapter.MonsterTitleViewHolder) viewHolder;

        monsterTitleViewHolder.getTextView().setText(title);
        monsterTitleViewHolder.getTextView().setTypeface(null, Typeface.BOLD);
    }
}
