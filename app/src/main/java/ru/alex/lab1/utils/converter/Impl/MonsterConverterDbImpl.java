package ru.alex.lab1.utils.converter.Impl;

import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterBase;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.utils.converter.MonsterConverterDb;

public class MonsterConverterDbImpl implements MonsterConverterDb {
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
    public Monster toMonsterEntity(RecyclerCardPreview monsterClassDto) {
        return Monster.builder()
                .id(monsterClassDto.getId())
                .name(monsterClassDto.getName())
                .imgName(monsterClassDto.getImgName())
                .imgDirection(monsterClassDto.getSource())
                .build();
    }

    @Override
    public List<Monster> toMonsterEntityList(List<RecyclerCardPreview> monsterClassDtoList) {
        return monsterClassDtoList.stream()
                .map(this::toMonsterEntity)
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

    @Override
    public MonsterDto toMonsterDto(Monster monsterClassDto) {
        return MonsterDto.builder()
                .id(monsterClassDto.getId())
                .name(monsterClassDto.getName())
                .imgName(monsterClassDto.getImgName())
                .imgDirection(monsterClassDto.getImgDirection())
                .build();
    }

    @Override
    public List<MonsterDto> toMonsterDtoList(List<Monster> monsterClassDtoList) {
        return monsterClassDtoList.stream()
                .map(this::toMonsterDto)
                .collect(Collectors.toList());
    }
}
