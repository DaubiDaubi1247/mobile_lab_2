package ru.alex.lab1.utils.converter;

import java.util.List;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public interface MonsterConverterDb {

    MonsterClass toEntity(RecyclerCardPreview monsterClassDto);

    List<MonsterClass> toEntityList(List<RecyclerCardPreview> monsterClassDtoList);

    MonsterClassDto toDto(MonsterClass monsterClassDto);

    List<MonsterClassDto> toDtoList(List<MonsterClass> monsterClassDtoList);
}
