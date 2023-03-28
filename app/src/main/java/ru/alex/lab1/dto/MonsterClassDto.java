package ru.alex.lab1.dto;

import ru.alex.lab1.pojo.MonsterClassCardPreview;

public class MonsterClassDto extends BaseCardPreviewDto {

    @Override
    public MonsterClassCardPreview toPojo() {
        return new MonsterClassCardPreview(id, name, source, imgName);
    }
}
