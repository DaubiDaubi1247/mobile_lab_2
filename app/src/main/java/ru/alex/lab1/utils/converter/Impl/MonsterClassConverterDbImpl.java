package ru.alex.lab1.utils.converter.Impl;

import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.utils.converter.MonsterConverterDb;
import ru.alex.lab1.utils.converter.MonsterConverterDbWithList;

public class MonsterClassConverterDbImpl implements MonsterConverterDbWithList<RecyclerCardPreview, MonsterClass, MonsterClassDto> {
    @Override
    public MonsterClass toEntity(RecyclerCardPreview monsterClassDto) {
        return MonsterClass.builder()
                .id(monsterClassDto.getId())
                .name(monsterClassDto.getName())
                .imgName(monsterClassDto.getImgName())
                .imgDirection(monsterClassDto.getSource())
                .build();
    }

    @Override
    public List<MonsterClass> toEntityList(List<RecyclerCardPreview> monsterClassDtoList) {
        return monsterClassDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MonsterClassDto toDto(MonsterClass monsterClassDto) {
        return MonsterClassDto.builder()
                .id(monsterClassDto.getId())
                .name(monsterClassDto.getName())
                .imgName(monsterClassDto.getImgName())
                .imgDirection(monsterClassDto.getImgDirection())
                .build();
    }

    @Override
    public List<MonsterClassDto> toDtoList(List<MonsterClass> monsterClassDtoList) {
        return monsterClassDtoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
