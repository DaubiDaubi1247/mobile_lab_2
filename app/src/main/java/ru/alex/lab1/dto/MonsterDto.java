package ru.alex.lab1.dto;

import ru.alex.lab1.pojo.MonsterCardPreview;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public class MonsterDto extends BaseCardPreviewDto{

    @Override
    public RecyclerCardPreview toPojo() {
        return new MonsterCardPreview(id, name, source, imgName);
    }
}
