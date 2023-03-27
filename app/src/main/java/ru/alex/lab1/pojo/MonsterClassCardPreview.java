package ru.alex.lab1.pojo;

import ru.alex.lab1.onClickHandler.MonsterOnclickHandler;

public class MonsterClassCardPreview extends RecyclerCardPreview {
    public MonsterClassCardPreview(Long id, String name, String source, String imgName) {
        super(id, name, source, imgName);
        setOnClickListener(new MonsterOnclickHandler(this));
    }
}
