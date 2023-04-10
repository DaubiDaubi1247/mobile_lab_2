package ru.alex.lab1.utils.converter.Impl;

import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.utils.converter.MonsterConverterDb;

public class MonsterConverterDbImpl implements MonsterConverterDb {
    @Override
    public MonsterClass toEntity(RecyclerCardPreview monsterClassDto) {
        return MonsterClass.builder()
                .id(monsterClassDto.getId())
                .name(monsterClassDto.getName())
                .build();
    }

    @Override
    public List<MonsterClass> toEntityList(List<RecyclerCardPreview> monsterClassDtoList) {
        return monsterClassDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
