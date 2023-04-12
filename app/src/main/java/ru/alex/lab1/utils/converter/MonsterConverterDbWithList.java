package ru.alex.lab1.utils.converter;

import java.util.List;

public interface MonsterConverterDbWithList<T, R, DR> extends MonsterConverterDb<T, R, DR> {

    List<R> toEntityList(List<T> monsterClassDtoList);


    List<DR> toDtoList(List<R> monsterClassDtoList);
}
