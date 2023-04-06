package ru.alex.lab1.pojo;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import ru.alex.lab1.R;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.urls.monster.MonsterUrls;

public class RecyclerCardPreview implements RecyclerViewElement {

    private final Long id;

    public Long getId() {
        return id;
    }

    private final String name;

    public String getName() {
        return name;
    }

    private final String source;
    private final String imgName;

    private View.OnClickListener onClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public RecyclerCardPreview(Long id, String name, String source, String imgName) {
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

        CardPreviewAdapter.MonsterViewHolder monsterViewHolder = (CardPreviewAdapter.MonsterViewHolder) viewHolder;
        monsterViewHolder.getMonsterTextView().setText(name);

        Glide.with(monsterViewHolder.getMonsterImage())
                .load(MonsterUrls.BASE_FOR_IMG + source + imgName)
                .thumbnail(Glide.with(monsterViewHolder.getMonsterImage()).load(R.drawable.preloader))
                .fitCenter()
                .into(monsterViewHolder.getMonsterImage());

        monsterViewHolder.itemView.setOnClickListener(onClickListener);
    }
}
