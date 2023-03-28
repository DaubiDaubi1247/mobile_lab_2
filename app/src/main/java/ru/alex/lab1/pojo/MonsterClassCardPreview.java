package ru.alex.lab1.pojo;

import ru.alex.lab1.onClickHandler.MonsterCLassOnClickHandler;

public class MonsterClassCardPreview extends RecyclerCardPreview {
    public MonsterClassCardPreview(Long id, String name, String source, String imgName) {
        super(id, name, source, imgName);
        setOnClickListener(new MonsterCLassOnClickHandler(this));
    }
}
