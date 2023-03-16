package ru.alex.lab1.pojo;

import androidx.recyclerview.widget.RecyclerView;

import ru.alex.lab1.adapter.MonstersAdapter;
import ru.alex.lab1.recycler.ElementType;

public class Monster implements ElementType {
    private final String name;
    private final int imgResource;

    public Monster(String name, int imgResource) {
        this.name = name;
        this.imgResource = imgResource;
    }

    @Override
    public int getViewType() {
        return ElementType.CARDS;
    }

    @Override
    public void onBindHandler(RecyclerView.ViewHolder viewHolder) {
        MonstersAdapter.MonsterViewHolder monsterViewHolder = (MonstersAdapter.MonsterViewHolder) viewHolder;
        monsterViewHolder.getMonsterTextView().setText(name);
        monsterViewHolder.getMonsterImage().setImageResource(imgResource);
    }
}
