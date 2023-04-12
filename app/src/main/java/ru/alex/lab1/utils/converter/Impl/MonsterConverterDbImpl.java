package ru.alex.lab1.utils.converter.Impl;

import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.utils.converter.MonsterConverterDb;
import ru.alex.lab1.utils.converter.MonsterConverterDbWithList;

public class MonsterConverterDbImpl implements MonsterConverterDbWithList<RecyclerCardPreview, Monster, MonsterDto> {

    @Override
    public Monster toEntity(RecyclerCardPreview monsterClassDto) {
        return Monster.builder()
                .id(monsterClassDto.getId())
                .name(monsterClassDto.getName())
                .imgName(monsterClassDto.getImgName())
                .imgDirection(monsterClassDto.getSource())
                .build();
    }

    @Override
    public List<Monster> toEntityList(List<RecyclerCardPreview> monsterClassDtoList) {
        return monsterClassDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MonsterDto toDto(Monster monsterClassDto) {
        return MonsterDto.builder()
                .id(monsterClassDto.getId())
                .name(monsterClassDto.getName())
                .imgName(monsterClassDto.getImgName())
                .imgDirection(monsterClassDto.getImgDirection())
                .build();
    }

    @Override
    public List<MonsterDto> toDtoList(List<Monster> monsterClassDtoList) {
        return monsterClassDtoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
