package ru.alex.lab1.onClickHandler;

import android.content.Intent;
import android.view.View;

import ru.alex.lab1.activity.CardDescriptionActivity;
import ru.alex.lab1.activity.MonsterListActivity;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public class MonsterCLassOnClickHandler implements View.OnClickListener {
    private final RecyclerCardPreview monster;

    public MonsterCLassOnClickHandler(RecyclerCardPreview monster) {
        this.monster = monster;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext() , MonsterListActivity.class);
        intent.putExtra("id", monster.getId());
        view.getContext().startActivity(intent);
    }
}
