package ru.alex.lab1.utils.converter.Impl;

import com.google.gson.Gson;

import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.utils.converter.MonsterConverter;

public class MonsterConverterImpl implements MonsterConverter {

    static Gson gson = new Gson();

    @Override
    public MonsterWithDescriptionDto toMonsterWithDesc(String responseInStr) {

        return gson.fromJson(responseInStr, MonsterWithDescriptionDto.class);
    }
}
