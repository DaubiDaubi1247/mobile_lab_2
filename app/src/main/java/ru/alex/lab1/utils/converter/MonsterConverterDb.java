package ru.alex.lab1.utils.converter;

import java.util.List;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterBase;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public interface MonsterConverterDb <T, R, DR> {

    R toEntity(T monsterClassDto);

    List<R> toEntityList(List<T> monsterClassDtoList);

    DR toDto(R monsterClassDto);

    List<DR> toDtoList(List<R> monsterClassDtoList);

}
