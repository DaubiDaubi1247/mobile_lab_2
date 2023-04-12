package ru.alex.lab1.utils.converter.Impl;

import java.util.List;

import ru.alex.lab1.utils.converter.MonsterConverterDb;

public class MonsterDescriptionConverterDbImpl<T, R, DR> implements MonsterConverterDb<T, R, DR> {
    @Override
    public R toEntity(T monsterClassDto) {
        return null;
    }

    @Override
    public List<R> toEntityList(List<T> monsterClassDtoList) {
        return null;
    }

    @Override
    public DR toDto(R monsterClassDto) {
        return null;
    }

    @Override
    public List<DR> toDtoList(List<R> monsterClassDtoList) {
        return null;
    }
}
