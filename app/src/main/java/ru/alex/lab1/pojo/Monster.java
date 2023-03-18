package ru.alex.lab1.pojo;

import androidx.recyclerview.widget.RecyclerView;

import ru.alex.lab1.adapter.MonstersAdapter;
import ru.alex.lab1.onClickHandler.MonsterOnclickHandler;
import ru.alex.lab1.recycler.RecyclerViewElement;

public class Monster implements RecyclerViewElement {

    private int id;

    public int getId() {
        return id;
    }

    private final String name;
    private final int imgResource;

    public Monster(int id, String name, int imgResource) {
        this.id = id;
        this.name = name;
        this.imgResource = imgResource;
    }

    @Override
    public int getViewType() {
        return RecyclerViewElement.CARDS;
    }

    @Override
    public void onBindHandler(RecyclerView.ViewHolder viewHolder) {

        MonsterOnclickHandler monsterOnclickHandler = new MonsterOnclickHandler(this);

        MonstersAdapter.MonsterViewHolder monsterViewHolder = (MonstersAdapter.MonsterViewHolder) viewHolder;
        monsterViewHolder.getMonsterTextView().setText(name);
        monsterViewHolder.getMonsterImage().setImageResource(imgResource);
        monsterViewHolder.itemView.setOnClickListener(monsterOnclickHandler);
    }
}
