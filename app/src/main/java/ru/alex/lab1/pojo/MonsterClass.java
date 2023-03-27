package ru.alex.lab1.pojo;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import ru.alex.lab1.adapter.MonsterClassAdapter;
import ru.alex.lab1.onClickHandler.MonsterOnclickHandler;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.urls.monster.MonsterUrls;

public class MonsterClass implements RecyclerViewElement {
    public MonsterClass() {
    }

    private Long id;

    public Long getId() {
        return id;
    }

    private String name;

    private String source;
    private String imgName;

    public MonsterClass(Long id, String name, String source, String imgName) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.imgName = imgName;
    }


    @Override
    public int getViewType() {
        return RecyclerViewElement.CARDS;
    }

    @Override
    public void onBindHandler(RecyclerView.ViewHolder viewHolder) {

        MonsterOnclickHandler monsterOnclickHandler = new MonsterOnclickHandler(this);

        MonsterClassAdapter.MonsterViewHolder monsterViewHolder = (MonsterClassAdapter.MonsterViewHolder) viewHolder;
        monsterViewHolder.getMonsterTextView().setText(name);
        Glide.with(monsterViewHolder.getMonsterImage())
                .load(MonsterUrls.BASE_FOR_IMG + source + imgName)
                .into(monsterViewHolder.getMonsterImage());
        monsterViewHolder.itemView.setOnClickListener(monsterOnclickHandler);
    }
}
