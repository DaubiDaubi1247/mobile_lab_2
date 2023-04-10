package ru.alex.lab1.utils.converter;

import java.util.List;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.entity.MonsterClass;

public interface MonsterConverterDb {

    MonsterClass toEntity(MonsterClassDto monsterClassDto);

    List<MonsterClass> toEntityList(List<MonsterClassDto> monsterClassDtoList);
}
