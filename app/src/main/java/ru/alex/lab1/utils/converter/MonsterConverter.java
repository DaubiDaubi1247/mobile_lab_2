package ru.alex.lab1.utils.converter;

import java.util.List;

import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public interface MonsterConverter {
    MonsterWithDescriptionDto toMonsterWithDesc(String responseInStr);

    List<RecyclerCardPreview> toMonsterDtoList(String responseInStr);

    List<RecyclerCardPreview> toMonsterClassDtoList(String responseInStr);
}
