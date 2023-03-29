package ru.alex.lab1.pojo;

import android.content.Intent;

import ru.alex.lab1.activity.CardDescriptionActivity;

public class MonsterCardPreview extends RecyclerCardPreview{

    public MonsterCardPreview(Long id, String name, String source, String imgName) {
        super(id, name, source, imgName);
        setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), CardDescriptionActivity.class);
            intent.putExtra("id", id);
            view.getContext().startActivity(intent);
        });
    }
}
