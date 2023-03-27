package ru.alex.lab1.onClickHandler;

import android.content.Intent;
import android.view.View;

import ru.alex.lab1.activity.CardDescriptionActivity;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public class MonsterOnclickHandler implements View.OnClickListener {
    private final RecyclerCardPreview monster;

    public MonsterOnclickHandler(RecyclerCardPreview monster) {
        this.monster = monster;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext() ,CardDescriptionActivity.class);
        intent.putExtra("id", monster.getId());
        view.getContext().startActivity(intent);
    }
}
