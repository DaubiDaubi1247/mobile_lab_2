package ru.alex.lab1.utils.converter;

import java.util.List;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterBase;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public interface MonsterConverterDb {

    MonsterClass toEntity(RecyclerCardPreview monsterClassDto);

    List<MonsterClass> toEntityList(List<RecyclerCardPreview> monsterClassDtoList);

    Monster toMonsterEntity(RecyclerCardPreview monsterClassDto);

    List<Monster> toMonsterEntityList(List<RecyclerCardPreview> monsterClassDtoList);

    MonsterClassDto toDto(MonsterClass monsterClassDto);

    List<MonsterClassDto> toDtoList(List<MonsterClass> monsterClassDtoList);

    MonsterDto toMonsterDto(Monster monsterClassDto);

    List<MonsterDto> toMonsterDtoList(List<Monster> monsterClassDtoList);
}
